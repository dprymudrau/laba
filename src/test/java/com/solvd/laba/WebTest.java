package com.solvd.laba;

import com.solvd.laba.web.AccountPage;
import com.solvd.laba.web.HomePage;
import com.solvd.laba.web.RegisterPage;
import com.solvd.laba.web.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {
    @Test
    public void registrationTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.openRegisterPage();
        signInPage.fillEmailField("aaaaa@bbb.ccc");
        RegisterPage registerPage = signInPage.openRegisterPage();
        Assert.assertTrue(registerPage.isPageOpened());
        registerPage.fillFirstName("Katerina");
        registerPage.fillLastName("Tebenkova");
        registerPage.fillPasswordField("xxyyyyyy");
        registerPage.fillTelephoneField("kkk");
        registerPage.fillAddressField("nnn");
        registerPage.fillAddressCityField("mmm");
        registerPage.fillPostCodeField("00000");
        registerPage.selecStateSelector(1);
        AccountPage accountPage = registerPage.clickRegisterButton();
        Assert.assertTrue(accountPage.isPageOpened());
    }

    @Test
    public void LoginTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.openRegisterPage();
        signInPage.fillLoginEmailField("aaaaa@bbb.ccc");
        signInPage.fillPasswordEmailField("xxyyyyyy");
        AccountPage accountPage = signInPage.loginButtonClick();
    }

    @Test
    public void signOutTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.openRegisterPage();
        signInPage.fillLoginEmailField("aaaaa@bbb.ccc");
        signInPage.fillPasswordEmailField("xxyyyyyy");
        AccountPage accountPage = signInPage.loginButtonClick();
        signInPage = accountPage.signOutClick();
    }
}
