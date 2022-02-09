package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static void waitVisibility(WebDriver driver , By by , int seconds) {
        WebDriverWait wait = new WebDriverWait(driver , seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
