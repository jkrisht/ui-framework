package amazon.pages;

import amazon.components.FilterComponent;
import amazon.components.ProductResultsComponent;
import amazon.components.SortComponent;
import amazon.factories.BundleFile;
import amazon.factories.PageFactory;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductResultsPage extends BasePage {

    public ProductResultsPage(AmazonDriver driver, BundleFile file) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public FilterComponent filterComponent() {
        return new FilterComponent(driver, BundleFile.PRODUCT_RESULTS_PAGE);
    }

    public SortComponent sortComponent() {
        return new SortComponent(driver);
    }

    public ProductResultsComponent productResultsComponent() {
        return new ProductResultsComponent(driver, BundleFile.PRODUCT_RESULTS_PAGE);
    }

    private By productsSearch() {
        return By.id("a-page");
    }

    @Override
    public void waitForPageLoad() {
        logger.info("Wait for Home page to load.");
        driver.isPageLoadComplete();
        driver.waitUntilElementVisible(productsSearch(), 10);
        verifyPageTitle();
    }

    @Override
    public void verifyPageTitle() {
        logger.info("Validating Products Results page title");
        String currentTitle = driver.getTitle();
        String expectedTitle = bundle.getString("pageTitle");
        Assertions.assertTrue(currentTitle.contains(expectedTitle), "Amazon Product results page browser title is incorrect.");
    }

    public ProductDetailsPage clickOnProduct(int index) {
        logger.info("clickOnProduct(int index): " + index);
        String clickedProductTitle = productResultsComponent().clickOnProduct(index);
        ProductDetailsPage detailsPage = PageFactory.productDetailsPage(driver);
        detailsPage.productTitle = clickedProductTitle;
        return detailsPage;
    }
}
