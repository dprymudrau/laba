package com.solvd.laba.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private ExtendedWebElement firstNameField;
    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private ExtendedWebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"input-email\"]")
    private ExtendedWebElement emailField;
    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private ExtendedWebElement telephoneField;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//*[@id=\"address1\"]")
    private ExtendedWebElement addressField;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private ExtendedWebElement addressCityField;
    @FindBy (xpath = "//*[@id=\"postcode\"]")
    private ExtendedWebElement postCodeField;
    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private ExtendedWebElement registerButton;
    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private ExtendedWebElement stateSelector;

    public RegisterPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public void fillFirstName(String text){
        firstNameField.type(text);
    }

    public void fillLastName(String text){
        lastNameField.type(text);
    }

    public void fillTelephoneField(String text){
        telephoneField.type(text);
    }

    public void fillEmailField(String text){
        emailField.type(text);
    }

    public void fillPasswordField(String text){
        passwordField.type(text);
    }

    public void fillAddressField(String text){
        addressField.type(text);
    }

    public void fillAddressCityField(String text){
        addressCityField.type(text);
    }

    public void fillPostCodeField(String text){
        postCodeField.type(text);
    }

    public void selecStateSelector(int index){
        stateSelector.select(index);
    }

    public AccountPage clickRegisterButton(){
        registerButton.click();
        return new AccountPage(driver);
    }
}

