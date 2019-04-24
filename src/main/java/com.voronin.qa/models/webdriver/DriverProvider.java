package com.voronin.qa.models.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;
import java.util.Objects;

public class DriverProvider {

    private static final ThreadLocal < WebDriver > DRIVER_STORAGE = new ThreadLocal <>();

    private static final Browsers browser = Browsers.valueOf( System.getProperty( "browser" ) );

    public static WebDriver getDriver() {

        WebDriver driver = DRIVER_STORAGE.get();

        if ( driver == null ) {

            switch ( browser ) {

                case CHROME_DRIVER_WINDOWS:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments( Collections.singletonList( "start-maximized" ) );

                    System.setProperty( "webdriver.chrome.driver" ,
                                        "src/test/resources/drivers/chromedriver.exe" );
                    driver = new ChromeDriver( chromeOptions );
                    DRIVER_STORAGE.set( driver );
                    break;
                case FIREFOX_DRIVER_WINDOWS:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    System.setProperty( "webdriver.gecko.driver" ,
                                        "src/test/resources/drivers/geckodriver.exe" );

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