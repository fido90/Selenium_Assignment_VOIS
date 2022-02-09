package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {

    private WebDriver driver;
    private By latestOrder = By.cssSelector("#order-list .first_item .history_link a");

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLatestOrderReference() {
        return driver.findElement(latestOrder).getText();
    }
}
