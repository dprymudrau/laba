package com.solvd.laba.carinaWEB;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.utils.webTests.ButtonsPage;
import com.solvd.laba.utils.webTests.HomePage;
import com.solvd.laba.utils.webTests.PracticeForm;
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
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage = new HomePage(getDriver());
        PracticeForm practiceForm = homePage.getFormsPage().formClick();
        practiceForm.setFirstName("Alena");
        practiceForm.setLastName("Vozniuk");
        practiceForm.setMail("MyRandomMail@gmail.com");
        practiceForm.setMale();
        practiceForm.clicSubmit();
    }

    @Test()
    public void test3() {

    }
}
