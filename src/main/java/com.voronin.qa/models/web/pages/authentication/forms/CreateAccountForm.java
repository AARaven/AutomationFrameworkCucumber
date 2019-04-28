package com.voronin.qa.models.web.pages.authentication.forms;

import com.voronin.qa.models.web.abstracts.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CreateAccountForm extends AbstractWebForm {

    private static final int TIME_FOR_LOAD = 10;

    private static final String XPATH_MAIN_FORM_LOCATOR = "//form[@id='create-account_form']";

    @FindBy( xpath = CreateAccountForm.XPATH_MAIN_FORM_LOCATOR )
    private WebElement mainForm;

    @FindBys( { @FindBy( xpath = CreateAccountForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='email_create']" ) } )
    private WebElement inputEmail;

    @FindBys( { @FindBy( xpath = CreateAccountForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//button[@id='SubmitCreate']" ) } )
    private WebElement buttonSubmit;

    private void setEmail( String email ) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys( email );
    }

    private void clickSubmit() {
        this.buttonSubmit.click();
    }

    @Override
    protected int getTimeout() {
        return CreateAccountForm.TIME_FOR_LOAD;
    }

    @Override
    protected WebElement getMainForm() {
        return this.mainForm;
    }

    public CreateAccountForm( WebDriver driver ) {
        super( driver );
    }

    public void followToCreateAnAccount( String email ) {
        setEmail( email );
        clickSubmit();
    }
}
