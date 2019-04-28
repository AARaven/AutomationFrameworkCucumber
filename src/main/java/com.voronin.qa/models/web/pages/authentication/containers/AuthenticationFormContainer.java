package com.voronin.qa.models.web.pages.authentication.containers;

import com.voronin.qa.models.web.abstracts.AbstractWebForm;
import com.voronin.qa.models.web.pages.authentication.forms.CreateAccountForm;
import com.voronin.qa.models.web.pages.authentication.forms.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationFormContainer extends AbstractWebForm {

    private static final int TIME_FOR_LOAD = 10;

    private static final String XPATH_MAIN_FORM_LOCATOR = "//div[@id='center_column']";

    @FindBy( xpath = AuthenticationFormContainer.XPATH_MAIN_FORM_LOCATOR )
    private WebElement mainForm;

    private CreateAccountForm createAccountForm;
    private LoginForm         loginForm;

    @Override
    protected WebElement getMainForm() {
        return this.mainForm;
    }

    @Override
    protected int getTimeout() {
        return AuthenticationFormContainer.TIME_FOR_LOAD;
    }

    public AuthenticationFormContainer( WebDriver driver ) {
        super( driver );
    }

    public CreateAccountForm getCreateAccountForm() {
        return ( this.createAccountForm == null )
               ? this.createAccountForm = new CreateAccountForm( getDriver() )
               : this.createAccountForm;
    }

    public LoginForm getLoginForm() {
        return ( this.loginForm == null )
               ? this.loginForm = new LoginForm( getDriver() )
               : this.loginForm;
    }
}
