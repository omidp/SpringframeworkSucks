package com.omidbiz.vacation;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.omidbiz.vacation.model.Vacation.VacationType;

@Name("vacation")
@AutoCreate
@Scope(ScopeType.EVENT)
public class Vacation implements Serializable
{

    @Factory("vacationType")
    public VacationType[] vacationTypes()
    {
        return VacationType.values();
    }

}
