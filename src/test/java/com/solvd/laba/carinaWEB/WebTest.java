package com.solvd.laba.carinaWEB;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.utils.webTests.ButtonsPage;
import com.solvd.laba.utils.webTests.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {
    @Test()
    public void test1() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
        ButtonsPage buttonsPage = homePage.openButtonsPage().buttonClick();
        buttonsPage.doubleClick();
        buttonsPage.rightClick();
        //buttonsPage.click();
        int k =5;
    }
    @Test()
    public void test2() {

    }
    @Test()
    public void test3() {

    }
}
