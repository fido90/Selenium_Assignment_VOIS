package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage {

    private WebDriver driver;
    private By totalAmount = By.id("amount");
    private By confirmOrderBtn = By.cssSelector("#cart_navigation button");

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalPriceInSummary() {
        return driver.findElement(totalAmount).getText();
    }

    public OrderConfirmationPage confirmOrder() {
        driver.findElement(confirmOrderBtn).click();
        return new OrderConfirmationPage(driver);
    }
}
