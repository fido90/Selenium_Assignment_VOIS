package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] dataProvide() {
        Object[][] data = new Object[3][2];

        data[0][0] = "ahmed@exam.com";     data[0][1] = "123456";
        data[1][0] = "ahmed@example.com";     data[1][1] = "654321";
        data[2][0] = "ahmed@exam.com";     data[2][1] = "654321";

        return data;
    }

    public SignupPage.SignupPageErrors getErrors() {
        return new SignupPage.SignupPageErrors(driver);
    }
}
