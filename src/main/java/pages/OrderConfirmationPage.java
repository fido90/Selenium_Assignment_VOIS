package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private WebDriver driver;
    private By mainText = By.className("box");
    private By accountBtn = By.className("account");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderReference() {
        String allText = driver.findElement(mainText).getText();
        String[] arr1 = allText.split("order reference ");
        String[] arr2 = arr1[1].split(" in the subject of your bank");
        return arr2[0];
    }

    public AccountPage clickAccountName() {
        driver.findElement(accountBtn).click();
        return new AccountPage(driver);
    }
}
