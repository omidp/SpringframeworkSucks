package com.omidbiz.vacation.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.jboss.seam.annotations.security.management.RoleName;

@Entity
@Table(name = "role")
public class Role extends BasePO
{
    private String rolename;

    @RoleName
    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }
}
