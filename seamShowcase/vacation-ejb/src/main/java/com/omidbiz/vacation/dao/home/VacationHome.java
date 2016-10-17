package com.omidbiz.vacation.dao.home;

import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityHome;

import com.omidbiz.vacation.Constants;
import com.omidbiz.vacation.model.User;
import com.omidbiz.vacation.model.Vacation;

@Name("vacationHome")
@Scope(ScopeType.CONVERSATION)
public class VacationHome extends EntityHome<Vacation>
{

    private User substituteUser;

    public User getSubstituteUser()
    {
        if(substituteUser == null)
            substituteUser = new User();
        return substituteUser;
    }

    public void setSubstituteUser(User substituteUser)
    {
        this.substituteUser = substituteUser;
    }

    public void load()
    {
        getInstance().setFromDate(new Date());
    }

    public void wire()
    {
        User u = new User();
        u.setId((Long) getSessionContext().get(Constants.CURRENT_USER_ID));
        getInstance().setUser(u);
        getInstance().setSubstitute(getSubstituteUser());
    }

    @Override
    public String persist()
    {
        wire();
        if (getInstance().getSubstitute() == null)
        {
            getStatusMessages().addFromResourceBundle("Substitute_Error");
            return null;
        }
        return super.persist();
    }

    @Override
    public String update()
    {
        wire();
        if (getInstance().getSubstitute() == null)
        {
            getStatusMessages().addFromResourceBundle("Substitute_Error");
            return null;
        }
        return super.update();
    }

}
