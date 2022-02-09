package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By signin = By.className("login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        driver.findElement(signin).click();
        return new LoginPage(driver);
    }
}
