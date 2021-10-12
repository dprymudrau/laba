package com.solvd.airport;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.airport.web.AccountPage;
import com.solvd.airport.web.HomePage;
import com.solvd.airport.web.RegisterPage;
import com.solvd.airport.web.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests implements IAbstractTest {

   /* @Test
    public void registrationTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //HomePage homePage = new HomePage(driver);
        //homePage.open();
        //Assert.assertTrue(homePage.isPageOpened());
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.fillFirstName("Dan");
        registerPage.fillLastName("Zotov");
        registerPage.fillEmailField("aaaa@aaa.aaa");
        registerPage.fillPasswordField("xxxxxx31");
        registerPage.fillTelephoneField("333");
        registerPage.fillPasswordConfirmField("xxxxxx31");
        registerPage.checkPolicyCheckmark();
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isPageOpened());
    }*/

    @Test
    public void registrationTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.openRegisterPage();
        //Assert.assertTrue(signInPage.isPageOpened());
        signInPage.fillEmailField("aaaaa@aaa.aaa");
        RegisterPage registerPage = signInPage.openRegisterPage();
        Assert.assertTrue(registerPage.isPageOpened());
        registerPage.fillFirstName("Dan");
        registerPage.fillLastName("Zotov");
        registerPage.fillPasswordField("xxxxxx31");
        registerPage.fillTelephoneField("333");
        registerPage.fillAddressField("aaa");
        registerPage.fillAddressCityField("aaa");
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
        signInPage.fillLoginEmailField("aaaaa@aaa.aaa");
        signInPage.fillPasswordEmailField("xxxxxx31");
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
        signInPage.fillLoginEmailField("aaaaa@aaa.aaa");
        signInPage.fillPasswordEmailField("xxxxxx31");
        AccountPage accountPage = signInPage.loginButtonClick();
        signInPage = accountPage.signOutClick();
    }
}
