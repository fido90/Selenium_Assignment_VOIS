package testLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testBase.Config;

public class InvalidLogin extends Config {

    @Test (priority = -1)
    public void testEmptyFields() {
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("" , "");
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("An email address required"));
        terminate();
    }

    @Test
    public void testEmptyEmail() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("" , "123456");
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("An email address required"));
        terminate();
    }

    @Test
    public void testEmptyPassword() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("ahmed@example.com" , "");
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("Password is required"));
        terminate();
    }

    @Test
    public void testWrongEmail() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("ahmed@exam.com" , "123456");
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("Authentication failed"));
        terminate();
    }

    @Test
    public void testWrongPassword() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("ahmed@example.com" , "654321");
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("Authentication failed"));
        terminate();
    }

    @Test (priority = 1)
    public void testWrongEmailAndPassword() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("ahmed@exam.com" , "654321");
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("Authentication failed"));
    }
}
