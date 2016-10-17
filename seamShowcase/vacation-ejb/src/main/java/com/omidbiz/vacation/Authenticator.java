package com.omidbiz.vacation;

import javax.ejb.Local;

@Local
public interface Authenticator {

    public boolean authenticate();
    
    public void createAdminUser();

}
