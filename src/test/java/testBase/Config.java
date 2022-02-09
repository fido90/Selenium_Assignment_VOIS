package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.SignupPage;

public class Config {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void startup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024 , 768));
        driver.get("http://automationpractice.com/index.php");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }

    public SignupPage.SignupPageErrors getErrors() {
        return new SignupPage.SignupPageErrors(driver);
    }
}
