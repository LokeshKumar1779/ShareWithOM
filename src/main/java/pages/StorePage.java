package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By pageTitle = By.cssSelector("h1.woocommerce-products-header__title.page-title");
    private final By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartBtn = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterProductName(String productName) {
//        driver.findElement(searchFld).sendKeys(productName);
        getElement(searchFld).sendKeys(productName);
        return this;
    }

    private StorePage clickSearchBtn() {
        driver.findElement(searchBtn).click();
        return this;
    }

    public StorePage searchProduct(String productName){
        enterProductName(productName).
        clickSearchBtn();
        return this;
    }

    public String getSearchedProductTitle() {
        return getElement(pageTitle).getText();
//        return driver.findElement(pageTitle).getText();

    }

    public void addProductToCart(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        getElement(addToCartBtn).click();
//        driver.findElement(addToCartBtn).click();
    }

    private By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public CartPage viewCart() {
        getElement(viewCartBtn).click();
//        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }

}
