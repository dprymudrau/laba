package com.solvd.laba.utils.webTests;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PracticeForm extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"item-0\"]")
    private ExtendedWebElement buttonClick;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private ExtendedWebElement firstName;
    @FindBy(xpath = "//*[@id=\"lastName\"]\n")
    private ExtendedWebElement lastName;

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
        lastName.click();
    }

}
