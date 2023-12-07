package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.StorePage;
import pojo.BillingAddress;
import pojo.Product;
import utils.JacksonUtils;

import java.io.IOException;

public class TestCase01 extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {

//        BillingAddress billingAddress = new BillingAddress("kumar","l01","Test Address Line1","Los Angels","90048","kumarl01@gmail.com");

        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        HomePage hp = new HomePage(driver);
        StorePage storePage = hp.navigateToStoreUsingMenu();
        storePage.searchProduct("Blue");
        Thread.sleep(2000);
        Assert.assertEquals(storePage.getSearchedProductTitle(), "Search results: “Blue”");
        storePage.addProductToCart(product.getName());
        CartPage cartPage = storePage.viewCart();

//        Cart Page
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.checkOut();

//        Checkout Page
        checkoutPage.setBillingAddress(billingAddress).selectDirectBankTransfer().placeOrder();
        Assert.assertEquals(checkoutPage.getThankYouMsg(), "Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
//        BillingAddress billingAddress = new BillingAddress("kumar", "l01", "Test Address Line1", "Los Angels", "90048", "kumarl01@gmail.com");
        BillingAddress billingAddress = JacksonUtils.deserializeJson("billingAddress.json", BillingAddress.class);
        Product product = new Product(1215);

        HomePage hp = new HomePage(driver);
        StorePage storePage = hp.navigateToStoreUsingMenu();
        storePage.searchProduct("Blue");
//        Thread.sleep(2000);
        Assert.assertEquals(storePage.getSearchedProductTitle(), "Search results: “Blue”");
        storePage.addProductToCart(product.getName());
        CartPage cartPage = storePage.viewCart();

        // Cart Page
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.checkOut();

        // Checkout Page
//        checkoutPage.clickLoginLink();
        checkoutPage.login("kumarl02@gmail.com", "kumarl02");
//        Thread.sleep(2000);
        checkoutPage.setBillingAddress(billingAddress).selectDirectBankTransfer().placeOrder();

        Assert.assertEquals(checkoutPage.getThankYouMsg(), "Thank you. Your order has been received.");


    }


}
