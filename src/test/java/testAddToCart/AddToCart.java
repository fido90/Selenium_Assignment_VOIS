package testAddToCart;

import org.testng.annotations.Test;
import pages.BlousesPage;
import testBase.Config;

public class AddToCart extends Config {

    @Test
    public void addProductToCart() {
        BlousesPage blousesPage = homePage.clickBlouses();
    }
}
