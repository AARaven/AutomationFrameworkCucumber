package com.voronin.qa.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DateOfBirth {

    @JsonProperty( "day" )
    private final String dayOfBirth;

    @JsonProperty( "month" )
    private final String monthOfBirth;

    @JsonProperty( "year" )
    private final String yearOfBirth;

    public String getDayOfBirth() {
        return this.dayOfBirth;
    }

    public String getMonthOfBirth() {
        return this.monthOfBirth;
    }

    public String getYearOfBirth() {
        return this.yearOfBirth;
    }

    private DateOfBirth() {
        this.dayOfBirth   = null;
        this.monthOfBirth = null;
        this.yearOfBirth  = null;
    }

    public DateOfBirth( String dayOfBirth , String monthOfBirth , String yearOfBirth ) {
        this.dayOfBirth   = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth  = yearOfBirth;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof DateOfBirth ) ) return false;
        DateOfBirth that = ( DateOfBirth ) o;
        return this.dayOfBirth.equals( that.dayOfBirth ) &&
               this.monthOfBirth.equals( that.monthOfBirth ) &&
               this.yearOfBirth.equals( that.yearOfBirth );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.dayOfBirth , this.monthOfBirth , this.yearOfBirth );
    }

    @Override
    public String toString() {
        return "Date of birth { " +
               this.dayOfBirth + '.' +
               this.monthOfBirth + '.' +
               this.yearOfBirth +
               " }";
    }
}