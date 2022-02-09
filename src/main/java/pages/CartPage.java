package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * index starts at 1
     * @param index
     */
    public String getProductName(int index) {
        WebElement desiredProduct = driver.findElement(By.xpath("(//table/tbody/tr)[" + index + "]"));
        return desiredProduct.findElement(By.className("cart_description p a")).getText();
    }
}
