package amazon.components;

import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

public class ProductResultsComponent extends BaseComponent {

    private final String baseElement = "div[class*='search-results']+div[class*='s-result-list']";

    public ProductResultsComponent(AmazonDriver driver, BundleFile file) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public By baseElement() {
        return By.cssSelector(baseElement);
    }

    public By products() {
        return By.cssSelector(baseElement + " div[data-index]");
    }

    private String productElement(int index) {
        return baseElement + " div[data-index='" + index + "']";
    }

    public By product(int index) {
        return By.cssSelector(productElement(index));
    }

    public By productLink(int index) {
        return By.cssSelector(productElement(index) + " a[class*='text-normal']");
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("ProductResultsComponent - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        logger.info("ProductResultsComponent - waitForComponentToDisappear");
        driver.waitUntilElementNotVisible(baseElement(), timeoutInSeconds);
    }

    /***
     * Click on the given index product link and return the product title
     * @param index
     * @return
     */
    public String clickOnProduct(int index) {
        logger.info("clickOnProduct(int index): " + index);
        waitForComponentToLoad(10);
        driver.waitUntilElementClickable(productLink(index), 10);
        String productTitle = driver.getText(productLink(index));
        driver.clickElement(productLink(index));
        waitForComponentToDisappear(10);
        return productTitle;
    }
}
