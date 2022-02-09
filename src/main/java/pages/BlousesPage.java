package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class BlousesPage {

    private WebDriver driver;
    private By allProducts = By.className("product_list");
    private By productName = By.className("product-name");
    private By productAddBtn = By.cssSelector("a[title='Add to cart']");
    private By addSuccessMsg = By.cssSelector(".layer_cart_product h2");
    private By proceedToCheckoutBtn = By.cssSelector("a[title='Proceed to checkout']");

    public BlousesPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts at 1
     */
    public String addBlouseToCart(int index) {
        List<WebElement> allProductsElements = driver.findElements(allProducts);
        String pName = allProductsElements.get(index - 1).findElement(productName).getText();
        allProductsElements.get(index - 1).findElement(productAddBtn).click();
        return pName;
    }

    public String getAddSuccessfulMessage() {
        Utils.waitVisibility(driver , addSuccessMsg , 3);
        return driver.findElement(addSuccessMsg).getText();
    }

    public CartPage clickProceedToCheckout() {
        Utils.waitVisibility(driver , proceedToCheckoutBtn , 3);
        driver.findElement(proceedToCheckoutBtn).click();
        return new CartPage(driver);
    }
}
