package driverManager;

import constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    WebDriver driver;

    public WebDriver initializeDriver() {
        String browserName = System.getProperty("browser");
//        String browserName = "chrome";
        switch (DriverType.valueOf(browserName)){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("INVALID BROWSER NAME : " +browserName);
        }

//        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
