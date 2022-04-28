package amazon.components;

import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductInfoComponent extends BaseComponent {

    private final String baseElement = "centerCol";

    public ProductInfoComponent(AmazonDriver driver, BundleFile file) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public By baseElement() {
        return By.id(baseElement);
    }

    public By aboutItemText() {
        return By.xpath("//div[@id='feature-bullets']/ul[normalize-space()]");
    }

    public By productTitle(String title) {
        return By.xpath("//div[@id='titleSection']//span[normalize-space()='" + title + "']");
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("ProductInfoComponent - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        throw new RuntimeException("Method not implemented.");
    }

    public void verifyItemTitle(String title) {
        logger.info("verifyItemTitle(String title): " + title);
        Assertions.assertTrue(driver.isDisplayed(productTitle(title)),
                "Product title is incorrect in Product details page");
    }

    public String getAboutItemDescription() {
        logger.info("getAboutItemDescription()");
        return driver.getText(aboutItemText());
    }
}
