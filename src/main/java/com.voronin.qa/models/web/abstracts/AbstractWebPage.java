package com.voronin.qa.models.web.abstracts;

import com.voronin.qa.models.web.interfaces.WebPage;
import com.voronin.qa.utils.LocalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractWebPage implements WebPage {

    private final String url;

    private final WebDriver driver;

    protected WebDriver getDriver() {
        return this.driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public AbstractWebPage( WebDriver driver ) {
        this.driver = driver;
        this.url    = LocalProperties.getProperty( getClass().getSimpleName() );

        PageFactory.initElements( driver , this );
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
