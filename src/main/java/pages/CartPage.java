package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends BasePage{

//    private final By productName = By.cssSelector("td.product-name a");

    @FindBy(css = "td.product-name a")
    private WebElement productName;
//    private final By checkOutBtn = By.cssSelector("a[href*='checkout']");
    @FindBy(css = "a[href*='checkout']")
    private WebElement checkOutBtn;
    //private final By checkOutTxt = By.xpath("//h1[text()='Checkout']");
    @FindBy(xpath = "//h1[text()='Checkout']") @CacheLookup
    private WebElement checkOutTxt;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public String getProductName(){
        return getElement(productName).getText();
//        return productName.getText();
    }

    public CheckoutPage checkOut(){
        getElement(checkOutBtn).click();
//        driver.findElement(checkOutBtn).click();
        Assert.assertTrue(isCheckoutPageDisplayed(),"user is not on checkout page");
        return new CheckoutPage(driver);
    }

    private boolean isCheckoutPageDisplayed() {
        return getElement(checkOutTxt).isDisplayed();
//        return driver.findElement(checkOutTxt).isDisplayed();
    }


}
