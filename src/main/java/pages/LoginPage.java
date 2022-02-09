package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class LoginPage {

    private WebDriver driver;
//    private By createAccountForm = By.id("create-account_form");
    private By createAccountDiv = By.cssSelector("#create-account_form .form-group");
    private By createAccountEmail = By.id("email_create");
    private By createAccountLabel = By.cssSelector("[for='email_create']");
    private By createAccountBtn = By.id("SubmitCreate");
    private By loginEmail = By.id("email");
    private By loginPassword = By.id("passwd");
    private By loginBtn = By.id("SubmitLogin");

    private By createAccountErrorMsg = By.cssSelector("#create_account_error li");
    private By loginMainErrorMsg = By.cssSelector(".alert-danger p");
    private By loginSubErrorMsg = By.cssSelector(".alert-danger li");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean enterSignupEmail(String email) {
        driver.findElement(createAccountEmail).sendKeys(email);
        return isEmailValid();
    }

    public SignupPage clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
        return new SignupPage(driver);
    }

    public String getCreateAccountError() {
        Utils.waitVisibility(driver , createAccountErrorMsg , 3);
        return driver.findElement(createAccountErrorMsg).getText();
    }

    public void enterLoginData(String email , String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
    }

    public AccountPage clickLogin() {
        driver.findElement(loginBtn).click();
        return new AccountPage(driver);
    }

    public String getLoginMainError() {
        Utils.waitVisibility(driver , loginMainErrorMsg , 2);
        return driver.findElement(loginMainErrorMsg).getText();
    }

    public String getLoginSubError() {
        Utils.waitVisibility(driver , loginSubErrorMsg , 2);
        return driver.findElement(loginSubErrorMsg).getText();
    }

    //In case of accessing login page while checking out
    public AddressPage clickLoginInCheckout() {
        driver.findElement(loginBtn).click();
        return new AddressPage(driver);
    }

    private boolean isEmailValid() {
        driver.findElement(createAccountLabel).click();
        String classContent = driver.findElement(createAccountDiv).getAttribute("class");
        if (classContent.contains("ok")) {
            return true;
        } else {
            return false;
        }
    }
}
