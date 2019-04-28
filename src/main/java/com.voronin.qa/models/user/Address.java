package com.voronin.qa.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.voronin.qa.models.web.pages.create_an_account.forms.States;

import java.util.Objects;

public class Address {

    @JsonProperty( "company_name" )
    private final String companyName;

    @JsonProperty( "address_line_1" )
    private final String street;

    @JsonProperty( "address_line_2" )
    private final String apartment;

    @JsonProperty( "city" )
    private final String city;

    @JsonProperty( "state" )
    private final States state;

    @JsonProperty( "postal_code" )
    private final String postalCode;

    @JsonProperty( "country" )
    private final String country;

    @JsonProperty( "additional_information" )
    private final String aboutYourself;

    @JsonProperty( "home_phone" )
    private final String phoneNumber;

    @JsonProperty( "mobile_phone" )
    private final String mobilePhoneNumber;

    @JsonProperty( "address_alias" )
    private final String addressAlias;

    public String getCompanyName() {
        return this.companyName;
    }

    public String getStreet() {
        return this.street;
    }

    public String getApartment() {
        return this.apartment;
    }

    public String getCity() {
        return this.city;
    }

    public States getState() {
        return this.state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getAboutYourself() {
        return this.aboutYourself;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getMobilePhoneNumber() {
        return this.mobilePhoneNumber;
    }

    public String getAddressAlias() {
        return this.addressAlias;
    }

    public static final class Builder {

        /*Required fields : */
        private final String street;
        private final String city;
        private final States state;
        private final String postalCode;
        private final String country;
        private final String mobilePhoneNumber;
        private final String addressAlias;

        /*Not required fields : */
        private String companyName;
        private String apartment;
        private String aboutYourself;
        private String phoneNumber;

        private Builder( String street , String city , States state ,
                         String postalCode , String country , String mobilePhoneNumber ,
                         String addressAlias ) {

            // Builder private constructor with required fields :
            this.street            = street;
            this.city              = city;
            this.state             = state;
            this.postalCode        = postalCode;
            this.country           = country;
            this.mobilePhoneNumber = mobilePhoneNumber;
            this.addressAlias      = addressAlias;
        }

        public static Builder createAddress( String street , String city , States state ,
                                             String postalCode , String country ,
                                             String mobilePhoneNumber , String addressAlias ) {

            return new Builder( street , city , state , postalCode ,
                                country , mobilePhoneNumber , addressAlias );
        }

        public Builder withCompanyName( String companyName ) {
            this.companyName = companyName;
            return this;
        }

        public Builder withApartment( String apartment ) {
            this.apartment = apartment;
            return this;
        }

        public Builder withAboutYourself( String aboutYourself ) {
            this.aboutYourself = aboutYourself;
            return this;
        }

        public Builder withPhoneNumber( String phoneNumber ) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Address build() {
            return new Address( this );
        }
    }

    private Address() {
        this.companyName       = null;
        this.street            = null;
        this.apartment         = null;
        this.city              = null;
        this.state             = null;
        this.postalCode        = null;
        this.country           = null;
        this.aboutYourself     = null;
        this.phoneNumber       = null;
        this.mobilePhoneNumber = null;
        this.addressAlias      = null;
    }

    private Address( Builder builder ) {
        this.postalCode        = builder.postalCode;
        this.country           = builder.country;
        this.street            = builder.street;
        this.city              = builder.city;
        this.phoneNumber       = builder.phoneNumber;
        this.mobilePhoneNumber = builder.mobilePhoneNumber;
        this.aboutYourself     = builder.aboutYourself;
        this.addressAlias      = builder.addressAlias;
        this.companyName       = builder.companyName;
        this.apartment         = builder.apartment;
        this.state             = builder.state;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Address ) ) return false;
        Address that = ( Address ) o;
        return this.companyName.equals( that.companyName ) &&
               this.street.equals( that.street ) &&
               this.apartment.equals( that.apartment ) &&
               this.city.equals( that.city ) &&
               this.state == that.state &&
               this.postalCode.equals( that.postalCode ) &&
               this.country.equals( that.country ) &&
               this.aboutYourself.equals( that.aboutYourself ) &&
               this.phoneNumber.equals( that.phoneNumber ) &&
               this.mobilePhoneNumber.equals( that.mobilePhoneNumber ) &&
               this.addressAlias.equals( that.addressAlias );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.companyName ,
                             this.street ,
                             this.apartment ,
                             this.city ,
                             this.state ,
                             this.postalCode ,
                             this.country ,
                             this.aboutYourself ,
                             this.phoneNumber ,
                             this.mobilePhoneNumber ,
                             this.addressAlias );
    }

    @Override
    public String toString() {
        return "Address :\n{" +
               "\ncompanyName = '" + this.companyName + '\'' +
               "\nstreet = '" + this.street + '\'' +
               "\napartment = '" + this.apartment + '\'' +
               "\ncity = '" + this.city + '\'' +
               "\nstate = " + this.state.getDescription() +
               "\npostalCode = '" + this.postalCode + '\'' +
               "\ncountry = '" + this.country + '\'' +
               "\naboutYourself = '" + this.aboutYourself + '\'' +
               "\nphoneNumber = '" + this.phoneNumber + '\'' +
               "\nmobilePhoneNumber = '" + this.mobilePhoneNumber + '\'' +
               "\naddressAlias = '" + this.addressAlias + '\'' +
               "\n}";
    }
}