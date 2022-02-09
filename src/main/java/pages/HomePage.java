package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;
    private By signin = By.className("login");
    private By women = By.cssSelector("a[title='Women']");
    private By blouses = By.cssSelector("a[title='Blouses']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        driver.findElement(signin).click();
        return new LoginPage(driver);
    }

    public BlousesPage clickBlouses() {
        WebElement womenElement = driver.findElement(women);
        WebElement blousesElement = driver.findElement(blouses);
        Actions action = new Actions(driver);
        action.moveToElement(womenElement).click(blousesElement).perform();
        return new BlousesPage(driver);
    }
}
