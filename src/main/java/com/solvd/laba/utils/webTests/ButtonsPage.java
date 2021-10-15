package com.solvd.laba.utils.webTests;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"item-4\"]")
    private ExtendedWebElement buttonClick;
    @FindBy(id = "doubleClickBtn")
    private ExtendedWebElement doubleClickMe;
    @FindBy(id = "rightClickBtn")
    private ExtendedWebElement rightClickMe;
    @FindBy(name = "Click Me")
    private ExtendedWebElement clickMe;

    public ButtonsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
    public ButtonsPage buttonClick() {
        buttonClick.click();
        return new ButtonsPage(driver);
    }
    public ButtonsPage doubleClick() {
        doubleClickMe.doubleClick();
        return new ButtonsPage(driver);
    }

    public ButtonsPage rightClick() {
        rightClickMe.rightClick();
        return new ButtonsPage(driver);
    }

    public ButtonsPage click() {
        clickMe.rightClick();
        return new ButtonsPage(driver);
    }

}
