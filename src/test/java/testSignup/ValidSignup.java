package testSignup;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.SignupPage;
import testBase.Config;

public class ValidSignup extends Config {

    //Please enter new email each time to signup
    private String email = "789@blabla.com";
    private String password = "123456";
    private LoginPage loginPage;
    private SignupPage signupPage;

    @Test
    public void validateEmailFormat() {
        loginPage = homePage.openLoginPage();
        Boolean isValid = loginPage.enterSignupEmail(email);
        Assert.assertTrue(isValid);
    }

    @Test (priority = 1 , dependsOnMethods = "validateEmailFormat")
    public void validateAutocompleteFields() {
        signupPage = loginPage.clickCreateAccount();
        signupPage.fillPersonalInfo("ahmed" , "ezzat" , password);
        signupPage.fillAddressInfo("main street" , "miami" , "idaho" , "12345" , "0123456789");
        String mail = signupPage.getEmail();
        String first = signupPage.getFirstName();
        String last = signupPage.getLastName();
        Assert.assertEquals(mail , email , "Email is not the same");
        //Please enter first and last name below same as in personal info
        Assert.assertEquals(first , "ahmed" , "First name is not the same");
        Assert.assertEquals(last , "ezzat" , "Last name is not the same");
    }

    @Test (priority = 2 , dependsOnMethods = {"validateEmailFormat" , "validateAutocompleteFields"})
    public void testCreateAccount() {
        AccountPage accountPage = signupPage.clickRegister();
        String welcomeMessage = accountPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome to your account"));
    }
}
