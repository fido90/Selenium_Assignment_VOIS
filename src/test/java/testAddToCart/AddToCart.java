package testAddToCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlousesPage;
import pages.CartPage;
import testBase.Config;

public class AddToCart extends Config {

    private BlousesPage blousesPage;
    private String productName;

    @Test
    public void testAddProductToCart() {
        blousesPage = homePage.clickBlouses();
        productName = blousesPage.addBlouseToCart(1);
        String successMessage = blousesPage.getAddSuccessfulMessage();
        Assert.assertTrue(successMessage.contains("Product successfully added to your shopping cart"));
    }

    @Test (priority = 1 , dependsOnMethods = "testAddProductToCart")
    public void confirmProductAdd() {
        CartPage cartPage = blousesPage.clickProceedToCheckout();
        String productNameInCart = cartPage.getProductName(1);
        Assert.assertEquals(productNameInCart , productName);
    }
}
