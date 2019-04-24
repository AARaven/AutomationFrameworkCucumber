package com.voronin.qa.models.web.abstracts;

import com.voronin.qa.models.web.interfaces.WebPage;
import com.voronin.qa.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebPage implements WebPage {

    public final String url;

    private final WebDriver driver;

    public AbstractWebPage( WebDriver driver ) {
        this.driver = driver;
        this.url    = PropertiesReader.getProperty( getClass().getSimpleName() );
    }

    @Override
    public void open() {
        this.driver.get( this.url );
    }

    @Override
    public void close() {
        this.driver.close();
    }

    @Override
    public void forward() {
        this.driver.navigate().forward();
    }

    @Override
    public void back() {
        this.driver.navigate().back();
    }

    @Override
    public void refresh() {
        this.driver.navigate().refresh();
    }
}
