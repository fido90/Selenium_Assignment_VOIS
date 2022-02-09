package testSignup;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.SignupPage;
import testBase.Config;

public class ValidSignup extends Config {

    /**Please enter new email each time to signup**/
    private String email = "sds878@blabla.com";
    private String password = "123456";
    private String firstName = "ahmed";
    private String lastName = "ezzat";

    private LoginPage loginPage;
    private SignupPage signupPage;

    @Test
    public void validateEmailFormat() {
        loginPage = homePage.openLoginPage();
        loginPage.enterSignupEmail(email);
        boolean isEmailValid = loginPage.isSignupEmailValid();
        Assert.assertTrue(isEmailValid);
    }

    @Test (priority = 1 , dependsOnMethods = "validateEmailFormat")
    public void validateAutocompleteFields() {
        signupPage = loginPage.clickCreateAccount();
        signupPage.fillPersonalInfo(firstName , lastName , password);
        signupPage.fillAddressInfo("main street" , "miami" , "idaho" , "12345" , "0123456789");
        String mail = signupPage.getEmail();
        String first = signupPage.getFirstName();
        String last = signupPage.getLastName();

        Assert.assertEquals(mail , email , "Email is not the same");
        Assert.assertEquals(first , firstName , "First name is not the same");
        Assert.assertEquals(last , lastName , "Last name is not the same");
    }

    @Test (priority = 2 , dependsOnMethods = "validateAutocompleteFields")
    public void testCreateAccount() {
        AccountPage accountPage = signupPage.clickRegister();
        String welcomeMessage = accountPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome to your account"));
    }
}
