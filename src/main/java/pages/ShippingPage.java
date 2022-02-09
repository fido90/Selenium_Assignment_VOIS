package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

    private WebDriver driver;
    private By termsCheckbox = By.id("cgv");
    private By proceedToCheckoutBtn = By.name("processCarrier");
    private By termsErrorMsg = By.className("fancybox-error");
    private By errorClosBtn = By.cssSelector("[title='Close']");

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkAgreeToTerms() {
        driver.findElement(termsCheckbox).click();
    }

    public String getTermsErrorMessage() {
        return driver.findElement(termsErrorMsg).getText();
    }

    public PaymentPage clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
        return new PaymentPage(driver);
    }

    public void closeErrorMessage() {
        driver.findElement(errorClosBtn).click();
    }
}
