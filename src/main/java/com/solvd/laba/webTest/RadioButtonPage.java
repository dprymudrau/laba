package com.solvd.laba.webTest;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"item-7\"]")
    private ExtendedWebElement download;
    @FindBy(xpath = "//*[@id=\\\"downloadButton\\\"]")
    private ExtendedWebElement downloadButton;

    @FindBy(xpath = "//*[@id=\\\"uploadFile\\\"]")
    private ExtendedWebElement uploadFileButton;


    public RadioButtonPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }


    public RadioButtonPage download() {
        download.click();
        return new ButtonsPage(driver);
    }
    public RadioButtonPage downloadButton() {
        downloadButton.click();
        return new RadioButtonPage(driver);
    }

    public RadioButtonPage uploadFileButton() {
        uploadFileButton.click();
        return new RadioButtonPage(driver);
    }

}