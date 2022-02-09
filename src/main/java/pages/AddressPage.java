package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage {

    private WebDriver driver;
    private By proceedToCheckoutBtn = By.name("processAddress");

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShippingPage clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
        return new ShippingPage(driver);
    }
}
