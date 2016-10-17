package com.omidbiz;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.omidbiz.userConverter")
public class UserConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        if (value == null)
        {
           return null;
        }
        if (value instanceof String) 
        {
           return (String) value;
        }
        return null;
    }

}
