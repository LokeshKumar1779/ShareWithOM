package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.BillingAddress;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {


    private final By firstNameFld = By.cssSelector("#billing_first_name");
    private final By lastNameFld = By.cssSelector("#billing_last_name");
    private final By addressLine1Fld = By.cssSelector("#billing_address_1");
    private final By billingCityFld = By.cssSelector("#billing_city");
    private final By billingPostcodeFld = By.cssSelector("#billing_postcode");
    private final By billingEmailFld = By.cssSelector("#billing_email");
    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");
    private final By placeOrderBtn = By.cssSelector("#place_order");

    private final By loginLink = By.cssSelector("a.showlogin");
    private final By userNameFld = By.cssSelector("#username");
    private final By pwdFld = By.cssSelector("#password");
    private final By loginBtn = By.cssSelector("button[name='login']");

    private final By thankYouMsg = By.cssSelector(".woocommerce-notice");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    private final By alternateStateDropDown = By.id("select2-billing_state-container");

    private final By alternateCountryDropDown = By.id("select2-billing_country-container");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    private CheckoutPage clearBillingAddress() {
        getElement(firstNameFld).clear();
        getElement(lastNameFld).clear();
        getElement(addressLine1Fld).clear();
        getElement(billingCityFld).clear();
        getElement(billingPostcodeFld).clear();
        getElement(billingEmailFld).clear();
        return this;

    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        return
                enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                enterAddressLine1(billingAddress.getAddress1()).
                 enterBillingCity(billingAddress.getCity()).
                        selectState(billingAddress.getState()).
                        enterBillingPostcode(billingAddress.getPostalCode()).
                        enterBillingEmail(billingAddress.getEmail());

    }

    private CheckoutPage enterFirstName(String firstName) {
        WebElement element = getElement(firstNameFld);
        element.clear();
        element.sendKeys(firstName);
        return this;
    }

    private CheckoutPage enterLastName(String lastName) {
        WebElement element = getElement(lastNameFld);
        element.clear();
        element.sendKeys(lastName);
        return this;
    }

    public CheckoutPage selectCountry(String countryName) {
        getElement(alternateCountryDropDown).click();
        WebElement element = waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + countryName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//li[text()='" + countryName + "']")));
        element.click();
        return this;
    }

    public CheckoutPage selectState(String stateName) {
        getElement(alternateStateDropDown).click();
        WebElement element = waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + stateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//li[text()='" + stateName + "']")));
        element.click();
        return this;
    }

    public By getStateDropDown() {
        return stateDropDown;
    }

    private CheckoutPage enterAddressLine1(String address1) {
        driver.findElement(addressLine1Fld).clear();
        driver.findElement(addressLine1Fld).sendKeys(address1);
        return this;
    }

    private CheckoutPage enterBillingCity(String city) {
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    private CheckoutPage enterBillingPostcode(String postCode) {
        driver.findElement(billingPostcodeFld).clear();
        driver.findElement(billingPostcodeFld).sendKeys(postCode);
        return this;
    }

    private CheckoutPage enterBillingEmail(String email) {
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder() {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAYS SIZE: " + overlays.size());
        if (overlays.size() > 0) {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS ARE DISAPPEARED...");
        }
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public CheckoutPage clickLoginLink() {
        getElement(loginLink).click();
//        driver.findElement(loginLink).click();
        return this;
    }

    private CheckoutPage enterUserName(String userName) {
        WebElement element = getElement(userNameFld);
        element.clear();
        waitShort.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(userName);
//        driver.findElement(userNameFld).sendKeys(userName);
        return this;
    }

    private CheckoutPage enterPwd(String pwd) {
        WebElement element = getElement(pwdFld);
        element.clear();
        element.sendKeys(pwd);
//        driver.findElement(pwdFld).sendKeys(pwd);
        return this;
    }

    private void clickLoginBtn() {
        getElement(loginBtn).click();
//        driver.findElement(loginBtn).click();
    }

    public CheckoutPage login(String userName, String pwd) {
        clickLoginLink().enterUserName(userName).enterPwd(pwd).clickLoginBtn();
        return this;
    }

    public String getThankYouMsg() {
        return getElement(thankYouMsg, 5).getText();
//        return getElement(thankYouMsg).getText();
//        return driver.findElement(thankYouMsg).getText();
    }

    public CheckoutPage selectDirectBankTransfer() {
//        waitShort.until(ExpectedConditions.elementToBeSelected(directBankTransferRadioBtn));
        WebElement e = getElement(directBankTransferRadioBtn);
        if (!e.isSelected()) {
            e.click();
        }
        return this;
    }
}
