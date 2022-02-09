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

    @Test (priority = 1)
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

    @Test (dataProvider = "dataProvide")
    public void testWrongData(String email , String password) {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData(email , password);
        loginPage.clickLogin();
        String mainError = loginPage.getLoginMainError();
        String subError = loginPage.getLoginSubError();
        Assert.assertTrue(mainError.contains("There is 1 error"));
        Assert.assertTrue(subError.contains("Authentication failed"));
        terminate();
    }
}
