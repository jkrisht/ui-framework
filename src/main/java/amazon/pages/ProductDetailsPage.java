package amazon.pages;

import amazon.components.ProductInfoComponent;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    public String productTitle;

    public ProductDetailsPage(AmazonDriver driver, BundleFile file) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public ProductInfoComponent productInfoComponent() {
        return new ProductInfoComponent(driver, BundleFile.PRODUCT_DETAILS_PAGE);
    }

    public By baseElement() {
        return By.id("dp");
    }

    @Override
    public void waitForPageLoad() {
        logger.info("Wait for Home page to load.");
        driver.waitUntilElementVisible(baseElement(), 10);
        verifyPageTitle();
    }

    @Override
    public void verifyPageTitle() {
        logger.info("Validating Products Results page title");
        String currentTitle = driver.getTitle();
        Assertions.assertTrue(currentTitle.contains(productTitle),
                "Amazon Product details page browser title is incorrect.");
    }

    public String getAboutDetailsOfProduct() {
        logger.info("getAboutDetailsOfProduct()");
        ProductInfoComponent infoComponent = productInfoComponent();
        infoComponent.verifyItemTitle(productTitle);
        return infoComponent.getAboutItemDescription();
    }
}
