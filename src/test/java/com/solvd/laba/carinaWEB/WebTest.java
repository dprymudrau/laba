package com.solvd.laba.carinaWEB;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.utils.webTests.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {
    @Test()
    public void test1() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/solvd/laba/utils/other/chromedriver.exe");
        driver.get("https://demoqa.com/");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
//        BrandModelsPage productsPage = homePage.selectBrand("Samsung");
//        // Select phone model
//        ModelInfoPage productInfoPage = productsPage.selectModel("Galaxy A52 5G");
//        // Verify phone specifications
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
//        softAssert.assertEquals(productInfoPage.readCamera(), "64MP", "Invalid camera info!");
//        softAssert.assertEquals(productInfoPage.readRam(), "6/8GB RAM", "Invalid ram info!");
//        softAssert.assertEquals(productInfoPage.readBattery(), "4500mAh", "Invalid battery info!");
//        softAssert.assertAll();
    }
    @Test()
    public void test2() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/solvd/laba/utils/other/chromedriver.exe");
        driver.get("https://demoqa.com/");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
    }
    @Test()
    public void test3() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/solvd/laba/utils/other/chromedriver.exe");
        driver.get("https://demoqa.com/");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
    }
}
