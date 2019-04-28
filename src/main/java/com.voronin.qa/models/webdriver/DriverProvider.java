package com.voronin.qa.models.webdriver;

import com.voronin.qa.utils.LocalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Collections;
import java.util.Objects;

public class DriverProvider {

    private static final ThreadLocal < WebDriver > DRIVER_STORAGE = new ThreadLocal <>();

    private static final Browsers BROWSER = Browsers.valueOf( System.getProperty( "browser" ) );

    private static final File PROPERTIES_DIR = new File( "src/test/resources/properties" );

    public static WebDriver getDriver() {

        LocalProperties.readProperties( PROPERTIES_DIR );

        WebDriver driver = DRIVER_STORAGE.get();

        if ( driver == null ) {

            switch ( BROWSER ) {

                case CHROME_DRIVER_WINDOWS:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments( Collections.singletonList( "start-maximized" ) );

                    System.setProperty( LocalProperties.getProperty( "chrome.name" ) ,
                                        LocalProperties.getProperty( "chrome.win.path" ) );
                    driver = new ChromeDriver( chromeOptions );
                    DRIVER_STORAGE.set( driver );
                    break;
                case FIREFOX_DRIVER_WINDOWS:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    System.setProperty( LocalProperties.getProperty( "firefox.name" ) ,
                                        LocalProperties.getProperty( "firefox.win.path" ) );

                    driver = new FirefoxDriver( firefoxOptions );
                    DRIVER_STORAGE.set( driver );
                    break;
            }
            Runtime.getRuntime()
                   .addShutdownHook( new Thread( Objects.requireNonNull( driver ) :: quit ) );
        }
        return driver;
    }
}