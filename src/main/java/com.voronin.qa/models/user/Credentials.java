package com.voronin.qa.models.user;

public class Credentials {

    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    private Credentials() {
        this.email    = null;
        this.password = null;
    }

    public Credentials( String email , String password ) {
        this.email    = email;
        this.password = password;
    }
}