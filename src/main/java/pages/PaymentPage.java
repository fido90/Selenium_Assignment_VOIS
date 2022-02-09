package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private WebDriver driver;
    private By bankWireLink = By.cssSelector("[title='Pay by bank wire']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderSummaryPage clickPayByBankWire() {
        driver.findElement(bankWireLink).click();
        return new OrderSummaryPage(driver);
    }
}
