package com.voronin.qa.models.web.pages.create_an_account.forms;

/**
 * This enumeration provides following genres :
 *
 * <ol><li>MALE</li><li>FEMALE</li></ol>
 */
public enum Gender {

    MALE( "male" ),
    FEMALE( "female" ),
    ;

    private final String description;

    public String getDescription() {
        return this.description;
    }

    Gender( String description ) {
        this.description = description;
    }
}