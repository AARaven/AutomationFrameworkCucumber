package com.voronin.qa.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.voronin.qa.models.web.pages.create_an_account.forms.Gender;

@JsonRootName( "user" )
public class User {

    @JsonProperty( "first_name" )
    private final String name;

    @JsonProperty( "last_name" )
    private final String surname;

    @JsonProperty( "gender" )
    private final Gender gender;

    @JsonProperty( "date_of_birth" )
    private final DateOfBirth dateOfBirth;

    @JsonProperty( "credentials" )
    private final Credentials credentials;

    @JsonProperty( "address" )
    private final Address address;

    @JsonProperty( "newsletters" )
    private final boolean isReceiveNewsLetters;

    @JsonProperty( "special_offers" )
    private final boolean isReceiveSpecialOffers;

    public Credentials getCredentials() {
        return this.credentials;
    }

    public Address getAddress() {
        return this.address;
    }

    public DateOfBirth getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Gender getGender() {
        return this.gender;
    }

    public boolean isReceiveNewsLetters() {
        return this.isReceiveNewsLetters;
    }

    public boolean isReceiveSpecialOffers() {
        return this.isReceiveSpecialOffers;
    }

    private User() {
        this.address                = null;
        this.credentials            = null;
        this.dateOfBirth            = null;
        this.gender                 = null;
        this.isReceiveNewsLetters   = false;
        this.isReceiveSpecialOffers = false;
        this.name                   = null;
        this.surname                = null;
    }

    public User( Gender gender , String name , String surname ,
                 Credentials credentials , DateOfBirth dateOfBirth , Address address ,
                 boolean isReceiveNewsLetters , boolean isReceiveSpecialOffers ) {

        this.gender                 = gender;
        this.name                   = name;
        this.surname                = surname;
        this.credentials            = credentials;
        this.dateOfBirth            = dateOfBirth;
        this.address                = address;
        this.isReceiveNewsLetters   = isReceiveNewsLetters;
        this.isReceiveSpecialOffers = isReceiveSpecialOffers;
    }
}