package amazon.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonDriver {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Logger logger = Logger.getLogger(AmazonDriver.class);

    public AmazonDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void get(String url) {
        logger.info("Navigating to "+ url);
        driver.get().get(url);
    }

    // Click the element
    public void clickElement(By by) {
        logger.info("Locate and click the following element: " + by);
        findElement(by).click();
    }

    // Get the current browser title
    public String getTitle() {
        String title = driver.get().getTitle();
        logger.info("Current Browser Window Title: " + title);
        return title;
    }

    // Locate the web element
    public WebElement findElement(By by) {
        logger.info("Locate the following element: " + by);
        try {
            return driver.get().findElement(by);
        } catch (Exception e) {
            logger.trace("Exception occurred while locating the element: " + by, e);
        }
        return null;
    }

    // Move to the element
    public void scrollToElement(By by) {
        logger.info("Scroll to the element: " + by);
        Actions actions = new Actions(driver.get());
        actions.moveToElement(findElement(by)).build().perform();
    }

    // Hover on the given element
    public void clickElementUsingJS(By by) {
        logger.info("Click on element using JS: " + by);
        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].click()", findElement(by));
    }

    // Wait until element is visible
    public void waitUntilElementVisible(By by, long seconds) {
        logger.info("Wait until following element is visible till " + seconds + " seconds : " + by);
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // Wait until element not visible
    public void waitUntilElementNotVisible(By by, int seconds) {
        logger.info("Wait until following element is not visible till " + seconds + " seconds : " + by);
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // Verify the element is displayed or not
    public boolean isDisplayed(By by) {
        logger.info("isDisplayed(By by): " + by);
        boolean isDisplayed = false;

        try {
            isDisplayed = findElement(by).isDisplayed();
        } catch (Exception e) {
            isDisplayed = false;
        }

        return isDisplayed;
    }
}
