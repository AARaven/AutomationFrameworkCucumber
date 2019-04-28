package com.voronin.qa.models.web.pages.create_an_account.containers;

import com.voronin.qa.models.web.abstracts.AbstractWebForm;
import com.voronin.qa.models.web.pages.create_an_account.forms.PersonalInformationForm;
import com.voronin.qa.models.web.pages.create_an_account.forms.YourAddressForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountFormContainer extends AbstractWebForm {

    private static final int TIME_FOR_LOAD = 10;

    private static final String XPATH_MAIN_FORM_LOCATOR = "//form[@id='account-creation_form']";

    @FindBy( xpath = CreateAnAccountFormContainer.XPATH_MAIN_FORM_LOCATOR )
    private WebElement mainForm;

    private PersonalInformationForm personalInformationForm;
    private YourAddressForm         yourAddressForm;

    public PersonalInformationForm getPersonalInformationForm() {
        return ( this.personalInformationForm == null )
               ? this.personalInformationForm = new PersonalInformationForm( getDriver() )
               : this.personalInformationForm;
    }

    public YourAddressForm getYourAddressForm() {
        return ( this.yourAddressForm == null )
               ? this.yourAddressForm = new YourAddressForm( getDriver() )
               : this.yourAddressForm;
    }

    @Override
    protected int getTimeout() {
        return CreateAnAccountFormContainer.TIME_FOR_LOAD;
    }

    @Override
    protected WebElement getMainForm() {
        return this.mainForm;
    }

    public CreateAnAccountFormContainer( WebDriver driver ) {
        super( driver );
    }
}