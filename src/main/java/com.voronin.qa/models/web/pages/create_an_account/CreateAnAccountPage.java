package com.voronin.qa.models.web.pages.create_an_account;

import com.voronin.qa.models.user.User;
import com.voronin.qa.models.web.abstracts.AbstractWebPage;
import com.voronin.qa.models.web.pages.create_an_account.containers.CreateAnAccountFormContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends AbstractWebPage {

    @FindBy( xpath = "//button[@id='submitAccount']" )
    private WebElement buttonSubmit;

    private CreateAnAccountFormContainer createAnAccountFormContainer;

    private CreateAnAccountFormContainer getCreateAnAccountFormContainer() {
        return ( this.createAnAccountFormContainer == null )
               ? this.createAnAccountFormContainer = new CreateAnAccountFormContainer( getDriver() )
               : this.createAnAccountFormContainer;
    }

    public void fillRequiredFields( User user ) {
        getCreateAnAccountFormContainer().getPersonalInformationForm()
                                         .fillPersonalInfoSection( user );

        getCreateAnAccountFormContainer().getYourAddressForm()
                                         .fillAddressSection( user );
    }

    public void clickSubmit() {
        this.buttonSubmit.click();
    }

    public CreateAnAccountPage( WebDriver driver ) {
        super( driver );
    }
}
