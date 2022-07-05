package com.resources;

import java.security.SecureRandom;

public class Login {
    String []empIds;
    String []passwords;

    Login(){
        empIds= new String[]{"emp001", "emp002", "emp003", "emp004"};
        passwords=new String[]{"test1","test2","test3","test4"};
    }

    public String[] getEmpIds() {
        return empIds;
    }

    public String[] getPasswords() {
        return passwords;
    }


}
