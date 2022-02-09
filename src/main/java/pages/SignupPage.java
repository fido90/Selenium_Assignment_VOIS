package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class SignupPage {

    private WebDriver driver;
    private By firstNameField =By.id("customer_firstname");
    private By lastNameField =By.id("customer_lastname");
    private By passwordField =By.id("passwd");
    private By addressField =By.id("address1");
    private By cityField =By.id("city");
    private By stateMenu =By.id("id_state");
    private By zipCodeField =By.id("postcode");
    private By mobileField =By.id("phone_mobile");
    private By registerBtn =By.id("submitAccount");
    private By emailField =By.id("email");
    private By firstNameField2 =By.id("firstname");
    private By lastNameField2 =By.id("lastname");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPersonalInfo(String firstName , String lastName , String password) {
        Utils.waitVisibility(driver , firstNameField , 5);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void fillAddressInfo(String address , String city , String state , String zipCode , String mobile) {
        Utils.waitVisibility(driver , addressField , 5);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);

        Actions action = new Actions(driver);
        WebElement zipCodeElement = driver.findElement(zipCodeField);
        action.moveToElement(zipCodeElement).perform();
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(mobileField).sendKeys(mobile);

        WebElement stateElement = driver.findElement(stateMenu);
        Select select = new Select(stateElement);
        select.selectByVisibleText(formatState(state));
    }

    public String getEmail() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getFirstName() {
        return driver.findElement(firstNameField2).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastNameField2).getAttribute("value");
    }

    public AccountPage clickRegister() {
        Utils.waitVisibility(driver , registerBtn , 5);
        driver.findElement(registerBtn).click();
        return new AccountPage(driver);
    }

    private String formatState(String str) {
        String firstLetter = str.substring(0 , 1);
        firstLetter = firstLetter.toUpperCase();
        String rest = str.substring(1);
        rest = rest.toLowerCase();
        return (firstLetter + rest);
    }

    public static class SignupPageErrors {

        private By mainError = By.cssSelector(".alert-danger p");
        private By mobileError = By.xpath("//li[contains(text() ,'phone number')]");
        private By lastError = By.xpath("//li/b[contains(text() ,'lastname')]");
        private By firstError = By.xpath("//li/b[contains(text() ,'firstname')]");
        private By passError = By.xpath("//li/b[contains(text() ,'passwd')]");
        private By addressError = By.xpath("//li/b[contains(text() ,'address1')]");
        private By cityError = By.xpath("//li/b[contains(text() ,'city')]");
        private By zipError = By.xpath("//li[contains(text() ,'Zip/Postal code')]");
        private By stateError = By.xpath("//li[contains(text() ,'choose a State')]");

        private WebDriver driver;

        public SignupPageErrors(WebDriver driver) {
            Utils.waitVisibility(driver , mainError , 4);
            this.driver = driver;
        }

        private String getText(By by) {
            return driver.findElement(by).getText();
        }

        public String getMainError() {
            return getText(mainError);
        }

        public String getMobileError() {
            return getText(mobileError);
        }

        public String getLastNameError() {
            return getText(lastError)+" is required";
        }

        public String getFirstNameError() {
            return getText(firstError)+" is required";
        }

        public String getPasswordError() {
            return getText(passError)+" is required";
        }

        public String getAddressError() {
            return getText(addressError)+" is required";
        }

        public String getCityError() {
            return getText(cityError)+" is required";
        }

        public String getZipcodeError() {
            return getText(zipError);
        }

        public String getStateError() {
            return getText(stateError);
        }
    }
}
