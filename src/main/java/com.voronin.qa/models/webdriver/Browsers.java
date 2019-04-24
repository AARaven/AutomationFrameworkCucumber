package com.voronin.qa.models.webdriver;

/**
 * This enumeration provides following drivers :
 * <ul>
 * <li>CHROME_DRIVER_WINDOWS</li>
 * <li>FIREFOX_DRIVER_WINDOWS</li>
 * </ul>
 */
public enum Browsers {

    /** Implementation of chrome browser web driver for Windows */
    CHROME_DRIVER_WINDOWS( "chrome_driver_windows" ) {

    },
    /** Implementation of firefox browser web driver for Windows */
    FIREFOX_DRIVER_WINDOWS( "firefox_driver_windows" ) {

    },
    ;

    private String description;

    Browsers( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}