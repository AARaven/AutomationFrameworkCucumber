package com.voronin.qa.models.web.pages.create_an_account.forms;

import com.voronin.qa.models.user.User;
import com.voronin.qa.models.web.abstracts.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class YourAddressForm extends AbstractWebForm {

    private static final int TIME_FOR_LOAD = 10;

    private static final String XPATH_MAIN_FORM_LOCATOR = "//div[@class='account_creation'][2]";

    @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR )
    private WebElement mainForm;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='firstname']" ) } )
    private WebElement inputFirstName;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='lastname']" ) } )
    private WebElement inputLastName;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='company']" ) } )
    private WebElement inputCompany;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='address1']" ) } )
    private WebElement inputAddress1;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='address2']" ) } )
    private WebElement inputAddress2;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='city']" ) } )
    private WebElement inputCity;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//select[@id='id_state']" ) } )
    private WebElement selectState;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='postcode']" ) } )
    private WebElement inputPostCode;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//select[@id='id_country']" ) } )
    private WebElement selectCountry;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//textarea[@id='other']" ) } )
    private WebElement textareaAdditionalInfo;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='phone']" ) } )
    private WebElement inputHomePhone;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='phone_mobile']" ) } )
    private WebElement inputMobilePhone;

    @FindBys( { @FindBy( xpath = YourAddressForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='alias']" ) } )
    private WebElement inputAliasAddress;

    @Override
    protected int getTimeout() {
        return YourAddressForm.TIME_FOR_LOAD;
    }

    @Override
    protected WebElement getMainForm() {
        return this.mainForm;
    }

    public YourAddressForm( WebDriver driver ) {
        super( driver );
    }

    private YourAddressForm setFirstName( String firstName ) {
        this.inputFirstName.clear();
        this.inputFirstName.sendKeys( firstName );
        return this;
    }

    private YourAddressForm setLastName( String lastName ) {
        this.inputLastName.clear();
        this.inputLastName.sendKeys( lastName );
        return this;
    }

    private YourAddressForm setCompany( String company ) {
        this.inputCompany.clear();
        this.inputCompany.sendKeys( company );
        return this;
    }

    private YourAddressForm setAddress1( String address1 ) {
        this.inputAddress1.clear();
        this.inputAddress1.sendKeys( address1 );
        return this;
    }

    private YourAddressForm setAddress2( String address2 ) {
        this.inputAddress2.clear();
        this.inputAddress2.sendKeys( address2 );
        return this;
    }

    private YourAddressForm setCity( String city ) {
        this.inputCity.clear();
        this.inputCity.sendKeys( city );
        return this;
    }

    private YourAddressForm setState( States state ) {
        Select select = new Select( this.selectState );
        select.selectByVisibleText( state.getDescription() );
        return this;
    }

    private YourAddressForm setPostalCode( String postalCode ) {
        this.inputPostCode.clear();
        this.inputPostCode.sendKeys( postalCode );
        return this;
    }

    private YourAddressForm setCountry( String country ) {
        Select select = new Select( this.selectCountry );
        select.selectByVisibleText( country );
        return this;
    }

    private YourAddressForm setAdditionalInfo( String additionalInfo ) {
        this.textareaAdditionalInfo.clear();
        this.textareaAdditionalInfo.sendKeys( additionalInfo );
        return this;
    }

    private YourAddressForm setHomePhone( String homePhone ) {
        this.inputHomePhone.clear();
        this.inputHomePhone.sendKeys( homePhone );
        return this;
    }

    private YourAddressForm setMobilePhone( String mobilePhone ) {
        this.inputMobilePhone.clear();
        this.inputMobilePhone.sendKeys( mobilePhone );
        return this;
    }

    private YourAddressForm setAddressAlias( String addressAlias ) {
        this.inputAliasAddress.clear();
        this.inputAliasAddress.sendKeys( addressAlias );
        return this;
    }

    public void fillAddressSection( User user ) {
        this.setFirstName( user.getName() )
            .setLastName( user.getSurname() )
            .setCompany( user.getAddress().getCompanyName() )
            .setCity( user.getAddress().getCity() )
            .setState( user.getAddress().getState() )
            .setCountry( user.getAddress().getCountry() )
            .setAddress1( user.getAddress().getStreet() )
            .setAddress2( user.getAddress().getApartment() )
            .setPostalCode( user.getAddress().getPostalCode() )
            .setAdditionalInfo( user.getAddress().getAboutYourself() )
            .setHomePhone( user.getAddress().getPhoneNumber() )
            .setMobilePhone( user.getAddress().getMobilePhoneNumber() )
            .setAddressAlias( user.getAddress().getAddressAlias() );
    }
}