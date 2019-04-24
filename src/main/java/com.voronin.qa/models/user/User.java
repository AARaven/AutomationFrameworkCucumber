package com.voronin.qa.models.user;

public class User {

    private final Credentials credentials;

    private final Address address;

    public User( Credentials credentials , Address address ) {
        this.credentials = credentials;
        this.address     = address;
    }
}
