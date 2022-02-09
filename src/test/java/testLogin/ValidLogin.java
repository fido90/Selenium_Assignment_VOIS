package testLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import testBase.Config;

public class ValidLogin extends Config {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterLoginData("ahmed@example.com" , "123456");
        AccountPage accountPage = loginPage.clickLogin();
        String welcomeMessage = accountPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome to your account"));
    }
}
