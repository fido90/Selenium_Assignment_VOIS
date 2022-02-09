package testSignup;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;
import testBase.Config;

public class InvalidSignup extends Config {

    @Test
    public void testSignupWithEmptyEmail() {
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.clickCreateAccount();
        String error = loginPage.getCreateAccountError();
        Assert.assertTrue(error.contains("Invalid email address"));
    }

    @Test (priority = 1)
    public void validateEmailFormat() {
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterSignupEmail("mail");
        boolean isEmailValid = loginPage.isSignupEmailValid();
        Assert.assertFalse(isEmailValid);
        terminate();
    }

    @Test (priority = 2)
    public void TestSignupWithExistingEmail() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterSignupEmail("fido@example.com");
        loginPage.clickCreateAccount();
        String error = loginPage.getCreateAccountError();
        Assert.assertTrue(error.contains("An account using this email address has already been registered"));
        terminate();
    }

    @Test (priority = 3)
    public void testSubmitSignupFormWithEmptyFields() {
        startup();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterSignupEmail("tyty@oio.com");
        SignupPage signupPage = loginPage.clickCreateAccount();
        signupPage.clickRegister();
        SignupPage.SignupPageErrors errors = getErrors();

        Assert.assertTrue(errors.getMainError().contains("There are 8 errors"));
        Assert.assertTrue(errors.getFirstNameError().contains("firstname is required") , "First name error is not visible");
        Assert.assertTrue(errors.getLastNameError().contains("lastname is required") , "Last name error is not visible");
        Assert.assertTrue(errors.getPasswordError().contains("passwd is required") , "Password error is not visible");
        Assert.assertTrue(errors.getAddressError().contains("address1 is required") , "Address error is not visible");
        Assert.assertTrue(errors.getCityError().contains("city is required") , "City error is not visible");
        Assert.assertTrue(errors.getZipcodeError().contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
        Assert.assertTrue(errors.getStateError().contains("This country requires you to choose a State"));
        Assert.assertTrue(errors.getMobileError().contains("You must register at least one phone number"));
    }
}
