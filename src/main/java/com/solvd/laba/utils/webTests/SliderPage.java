package com.solvd.laba.utils.webTests;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends AbstractPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[4]")
    private ExtendedWebElement sliderPage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[4]")
    private ExtendedWebElement sliderElement;
    @FindBy(xpath = "//*[@id=\"sliderValue\"]")
    private ExtendedWebElement sliderValue;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[5]")
    private ExtendedWebElement progressBarPage;
    @FindBy(xpath = "//*[@id=\"startStopButton\"]")
    private ExtendedWebElement startButton;


    public SliderPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public SliderPage sliderClick() {
        sliderPage.click();
        return new SliderPage(driver);
    }

    public SliderPage sliderMove(int moveRange) {
        sliderValue.doubleClick();
        sliderValue.type(String.valueOf(moveRange));
        return new SliderPage(driver);
    }

    public SliderPage getProgressBarPage() {
        progressBarPage.click();
        return new SliderPage(driver);
    }

    public SliderPage clickStartStopButton() {
        startButton.click();
        return new SliderPage(driver);
    }

}
