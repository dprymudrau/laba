package com.solvd.laba.webTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
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
        int k = 5;
    }

    @Test()
    public void test2() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
        PracticeForm practiceForm = homePage.openFormsPage().formClick();
        practiceForm.setFirstName("Juli");
        practiceForm.setLastName("Vestern");
        practiceForm.setMail("kryak@gmail.com");
        practiceForm.setMale();
        practiceForm.clicSubmit();
    }

    @Test()
    public void test3() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
        RadioButtonPage radioButtonPage = homePage.openWigetsPage().download();
        radioButtonPage.downloadButton();
        radioButtonPage.uploadFileButton();
    }
}
