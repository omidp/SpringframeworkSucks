package com.omidbiz.vacation;

import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.management.IdentityManager;
import org.jboss.seam.security.management.IdentityStore;
import org.jboss.seam.security.management.JpaIdentityStore;

import com.omidbiz.vacation.model.User;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator
{
    @Logger
    private Log log;

    @In
    Identity identity;
    @In
    Credentials credentials;

    @In
    IdentityManager identityManager;
    
    @In
    IdentityStore identityStore;

    @Override
    public boolean authenticate()
    {
        log.info("authenticating {0}", credentials.getUsername());
        // write your authentication logic here,
        // return true if the authentication was
        // successful, false otherwise
        if ("admin".equals(credentials.getUsername()) && "vac@123".equals(credentials.getPassword()))
        {
            identity.addRole("admin");
            return true;
        }
        boolean authenticate = identityManager.authenticate(credentials.getUsername(), credentials.getPassword());
        if (authenticate)
        {
            List<String> roles = identityManager.getGrantedRoles(credentials.getUsername());
            
            for (String r : roles)
            {
                identity.addRole(r);
            }
        }
        return authenticate;
    }

    @Override
    public void createAdminUser()
    {
        identityStore.createUser("admin", "vac@123", "admin", "admin");
    }
    
    @Observer(value=JpaIdentityStore.EVENT_USER_AUTHENTICATED)
    public void afterAuth(User user)
    {
        Contexts.getSessionContext().set(Constants.CURRENT_USER_ID, user.getId());
    }

}
