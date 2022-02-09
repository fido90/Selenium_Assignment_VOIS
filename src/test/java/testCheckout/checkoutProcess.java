package testCheckout;

import org.testng.annotations.Test;
import pages.BlousesPage;
import pages.CartPage;
import pages.LoginPage;
import testBase.Config;

public class checkoutProcess extends Config {

    @Test
    public void testValidCheckout() {
        BlousesPage blousesPage = homePage.clickBlouses();
        blousesPage.addBlouseToCart(1);
        CartPage cartPage = blousesPage.clickProceedToCheckout();
        LoginPage loginPage = cartPage.clickProceedToCheckout();
        loginPage.enterLoginData("ahmed@example.com" , "123456");
        loginPage.clickLogin();
    }
}
