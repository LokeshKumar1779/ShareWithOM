package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait waitLong;
    protected WebDriverWait waitShort;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitShort = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    /**
     * Waits for the visibility of element
     * @param element
     * @return WebElement
     */
    public WebElement getElement(WebElement element){
//        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(by));
        return waitShort.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the visibility of element
     * @param by
     * @return WebElement
     */
    public WebElement getElement(By by){
        waitShort = new WebDriverWait(driver, Duration.ofSeconds(10));
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Waits for the visibility of element for specified duration before throwing timeout exception
     * @param by locator
     * @return WebElement
     * @exception org.openqa.selenium.TimeoutException
     */
    public WebElement getElement(By by , int sec){
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(sec));
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
