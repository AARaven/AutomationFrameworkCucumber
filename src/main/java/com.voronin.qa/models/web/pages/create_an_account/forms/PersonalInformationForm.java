package com.voronin.qa.models.web.pages.create_an_account.forms;

import com.voronin.qa.models.user.User;
import com.voronin.qa.models.web.abstracts.AbstractWebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationForm extends AbstractWebForm {

    private static final int TIME_FOR_LOAD = 10;

    private static final String XPATH_MAIN_FORM_LOCATOR = "//div[@class='account_creation'][1]";

    @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR )
    private WebElement mainForm;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='id_gender1']" ) } )
    private WebElement radioGenderMale;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='id_gender2']" ) } )
    private WebElement radioGenderFemale;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='customer_firstname']" ) } )
    private WebElement inputFirstName;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='customer_lastname']" ) } )
    private WebElement inputLastName;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='email']" ) } )
    private WebElement inputEmail;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='passwd']" ) } )
    private WebElement inputPassword;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//select[@id='days']" ) } )
    private WebElement selectDayOfBirth;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//select[@id='months']" ) } )
    private WebElement selectMonthOfBirth;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//select[@id='years']" ) } )
    private WebElement selectYearOfBirth;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='newsletter']" ) } )
    private WebElement checkboxNewsLetter;

    @FindBys( { @FindBy( xpath = PersonalInformationForm.XPATH_MAIN_FORM_LOCATOR ) ,
                @FindBy( xpath = "//input[@id='optin']" ) } )
    private WebElement checkboxSpectialOffers;

    @Override
    protected int getTimeout() {
        return PersonalInformationForm.TIME_FOR_LOAD;
    }

    @Override
    protected WebElement getMainForm() {
        return this.mainForm;
    }

    public PersonalInformationForm( WebDriver driver ) {
        super( driver );
    }

    private PersonalInformationForm setGenredMale() {
        this.radioGenderMale.click();
        return this;
    }

    private PersonalInformationForm setGenderFemale() {
        this.radioGenderFemale.click();
        return this;
    }

    private PersonalInformationForm setGender( Gender gender ) {
        switch ( gender ) {
            case MALE:
                this.radioGenderMale.click();
                break;
            case FEMALE:
                this.radioGenderFemale.click();
                break;
        }
        return this;
    }

    private PersonalInformationForm setFirstName( String firstName ) {
        this.inputFirstName.clear();
        this.inputFirstName.sendKeys( firstName );
        return this;
    }

    private PersonalInformationForm setLastName( String lastName ) {
        this.inputLastName.clear();
        this.inputLastName.sendKeys( lastName );
        return this;
    }

    private PersonalInformationForm setEmail( String email ) {
        this.inputEmail.clear();
        this.inputEmail.sendKeys( email );
        return this;
    }

    private PersonalInformationForm setPassword( String password ) {
        this.inputPassword.clear();
        this.inputPassword.sendKeys( password );
        return this;
    }

    private PersonalInformationForm setDayOfBirth( String day ) {
        Select select = new Select( this.selectDayOfBirth );
        select.selectByValue( day );
        return this;
    }

    private PersonalInformationForm setMonthOfBirth( String month ) {
        Select select = new Select( this.selectMonthOfBirth );
        select.selectByValue( month );
        return this;
    }

    private PersonalInformationForm setYearOfBirth( String year ) {
        Select select = new Select( this.selectYearOfBirth );
        select.selectByValue( year );
        return this;
    }

    private PersonalInformationForm chooseNewsLetters( boolean isReceiveNewsLetters ) {
        if ( isReceiveNewsLetters ) {
            this.checkboxNewsLetter.click();
        }
        return this;
    }

    private PersonalInformationForm chooseSpecialOffers( boolean isReceiveSpecialOffers ) {
        if ( isReceiveSpecialOffers ) {
            this.checkboxSpectialOffers.click();
        }
        return this;
    }

    public void fillPersonalInfoSection( User user ) {
        this.setGender( user.getGender() )
            .setFirstName( user.getName() )
            .setLastName( user.getSurname() )
            .setEmail( user.getCredentials().getEmail() )
            .setPassword( user.getCredentials().getPassword() )
            .setDayOfBirth( user.getDateOfBirth().getDayOfBirth() )
            .setMonthOfBirth( user.getDateOfBirth().getMonthOfBirth() )
            .setYearOfBirth( user.getDateOfBirth().getYearOfBirth() )
            .chooseNewsLetters( user.isReceiveNewsLetters() )
            .chooseSpecialOffers( user.isReceiveSpecialOffers() );
    }
}