package com.solvd.laba.utils.webTests;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    private ExtendedWebElement getButtonsPage;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]")
    private ExtendedWebElement getFormsPage;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public ButtonsPage openButtonsPage() {
        getButtonsPage.click();
        return new ButtonsPage(driver);
    }
    public PracticeForm getFormsPage() {
        getFormsPage.click();
        return new PracticeForm(driver);
    }

}