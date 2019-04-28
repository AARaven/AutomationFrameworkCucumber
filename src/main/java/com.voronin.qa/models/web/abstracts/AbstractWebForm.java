package com.voronin.qa.models.web.abstracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractWebForm {

    private final WebDriver driver;

    private int timeout;

    private WebElement mainForm;

    private void waitForFormLoaded() {
        new WebDriverWait( getDriver() , getTimeout() ).until(
                ExpectedConditions.visibilityOf( getMainForm() ) );
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected int getTimeout() {
        return this.timeout;
    }

    protected WebElement getMainForm() {
        return this.mainForm;
    }

    public AbstractWebForm( WebDriver driver ) {
        this.driver = driver;

        PageFactory.initElements( driver , this );

        waitForFormLoaded();
    }
}
