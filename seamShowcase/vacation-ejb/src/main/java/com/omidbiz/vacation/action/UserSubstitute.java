package com.omidbiz.vacation.action;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityController;

import com.omidbiz.vacation.model.User;

@Name("userSubstitute")
@Scope(ScopeType.CONVERSATION)
public class UserSubstitute extends EntityController
{

    public List<User> complete(String query)
    {
        List<User> results = new ArrayList<User>();
        results = getEntityManager()
                .createQuery(
                        "select u from User u where lower(u.username) like lower(:name) or lower(u.lastname) like lower(:name) or lower(u.firstname) like lower(:name)")
                .setParameter("name", "%" + query + "%").setMaxResults(15).getResultList();
        return results;
    }

}
