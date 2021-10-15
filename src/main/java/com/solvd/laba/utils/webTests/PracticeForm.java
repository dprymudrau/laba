package com.solvd.laba.utils.webTests;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PracticeForm extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div")
    private ExtendedWebElement buttonClick;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private ExtendedWebElement firstName;
    @FindBy(id = "lastName")
    private ExtendedWebElement lastName;
    @FindBy(id = "userEmail")
    private ExtendedWebElement mail;
    @FindBy(id = "gender-radio-2")
    private ExtendedWebElement gender;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    private ExtendedWebElement submit;


    public PracticeForm(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
    public PracticeForm formClick() {
        buttonClick.click();
        return new PracticeForm(driver);
    }
    public void setFirstName(String text) {
        firstName.type(text);
    }
    public void setLastName(String text) {
        lastName.type(text);
    }
    public void setMail(String text) {
        mail.type(text);
    }
    public PracticeForm setMale() {
        gender.click();
        return new PracticeForm(driver);
    }
    public PracticeForm clicSubmit() {
        submit.click();
        return new PracticeForm(driver);
    }
}
