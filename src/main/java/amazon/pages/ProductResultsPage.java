package amazon.pages;

import amazon.components.FilterComponent;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductResultsPage extends BasePage {

    public ProductResultsPage(AmazonDriver driver, BundleFile file) {
        System.out.println(file);
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public FilterComponent filterComponent() {
        return new FilterComponent(driver, BundleFile.PRODUCT_RESULTS_PAGE);
    }

    private By productsSearch() {
        return By.id("search");
    }

    @Override
    public void waitForPageLoad() {
        logger.info("Wait for Home page to load.");
        driver.waitUntilElementVisible(productsSearch(), 10);
        verifyPageTitle();
    }

    @Override
    public void verifyPageTitle() {
        logger.info("Validating Products Results page title");
        String currentTitle = driver.getTitle();
        String expectedTitle = bundle.getString("pageTitle");
        assertEquals(expectedTitle, currentTitle, "Amazon Product results page browser title is incorrect.");
    }
}
