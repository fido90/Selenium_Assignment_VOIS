package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    private By allProducts = By.cssSelector("#cart_summary tbody tr");
    private By productName = By.cssSelector(".cart_description p a");
    private By proceedToCheckoutBtn = By.cssSelector("#center_column [title='Proceed to checkout']");
    private By totalAmount = By.id("total_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts at 1
     */
    public String getProductName(int index) {
        List<WebElement> allProductsElements = driver.findElements(allProducts);
        return allProductsElements.get(index - 1).findElement(productName).getText();
    }

    public LoginPage clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
        return new LoginPage(driver);
    }

    public String getTotalPriceInCart() {
        return driver.findElement(totalAmount).getText();
    }
}
