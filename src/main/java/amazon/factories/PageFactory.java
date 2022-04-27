package amazon.factories;

import amazon.pages.HomePage;
import amazon.pages.ProductResultsPage;
import amazon.utils.AmazonDriver;

public class PageFactory {
    synchronized public static HomePage homePage(AmazonDriver driver) {
        return new HomePage(driver, BundleFile.HOME_PAGE);
    }

    synchronized public static ProductResultsPage productResultsPage(AmazonDriver driver) {
        return new ProductResultsPage(driver, BundleFile.PRODUCT_RESULTS_PAGE);
    }
}
