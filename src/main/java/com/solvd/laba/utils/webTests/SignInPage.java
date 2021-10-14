package com.solvd.laba.utils.webTests;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private ExtendedWebElement emailRegisterField;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private ExtendedWebElement emailLoginField;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private ExtendedWebElement passwordLoginField;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private ExtendedWebElement loginButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void fillEmailField(String text) {
        emailRegisterField.type(text);
    }

    public RegisterPage openRegisterPage() {
        createAccountButton.click();
        return new RegisterPage(driver);
    }

    public void fillLoginEmailField(String text) {
        emailLoginField.type(text);
    }

    public void fillPasswordEmailField(String text) {
        passwordLoginField.type(text);
    }

    public AccountPage loginButtonClick() {
        loginButton.click();
        return new AccountPage(driver);
    }
}