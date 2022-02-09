package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class AccountPage {

    private WebDriver driver;
    private By message = By.className("info-account");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        Utils.waitVisibility(driver , message , 2);
        return driver.findElement(message).getText();
    }
}
