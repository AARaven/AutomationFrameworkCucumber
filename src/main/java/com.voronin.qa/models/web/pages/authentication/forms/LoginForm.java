package com.voronin.qa.models.web.pages.authentication.forms;

import com.voronin.qa.models.web.abstracts.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginForm extends AbstractWebForm {

    private static final int TIME_FOR_LOAD = 10;

    private static final String XPATH_MAIN_FORM_LOCATOR = "//form[@id='login_form']";

    @FindBy( xpath = LoginForm.XPATH_MAIN_FORM_LOCATOR )
    private WebElement mainForm;

    @FindBys( { @FindBy( xpath = LoginForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='email']" ) } )
    private WebElement inputEmail;

    @FindBys( { @FindBy( xpath = LoginForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='passwd']" ) } )
    private WebElement inputPassword;

    @FindBys( { @FindBy( xpath = LoginForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//button[@id='SubmitLogin']" ) } )
    private WebElement buttonSubmit;

    @FindBys( { @FindBy( xpath = LoginForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//a[@title='Recover your forgotten password']" ) } )
    private WebElement linkForgotPassword;

    private void setEmail( String email ) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys( email );
    }

    private void setPassword( String password ) {
        this.inputPassword.clear();
        this.inputPassword.sendKeys( password );
    }

    public void clickSubmit() {
        this.buttonSubmit.click();
    }

    public void authorizeWith( String email , String password ) {
        setEmail( email );
        setPassword( password );
        clickSubmit();
    }

    @Override
    protected int getTimeout() {
        return LoginForm.TIME_FOR_LOAD;
    }

    @Override
    protected WebElement getMainForm() {
        return this.mainForm;
    }

    public LoginForm( WebDriver driver ) {
        super( driver );
    }
}