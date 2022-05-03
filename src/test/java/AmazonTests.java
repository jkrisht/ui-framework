import amazon.components.enums.AllHamburgerMenu;
import amazon.components.enums.Filter;
import amazon.components.enums.FilterOption;
import amazon.components.enums.HamburgerSubMenu;
import amazon.components.enums.SortBy;
import amazon.factories.PageFactory;
import amazon.pages.HomePage;
import amazon.pages.ProductDetailsPage;
import amazon.pages.ProductResultsPage;
import amazon.utils.AmazonDriver;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AmazonTests {

    private AmazonDriver driver;
    private final Logger logger = Logger.getLogger(this.getClass());

    @BeforeEach
    public void setupDriver() {
        driver = AmazonDriver.getAmazonDriver();
    }

    @Tag("aboutItemTest")
    @DisplayName("Navigate to Product details page and print the about product details section")
    @Test
    public void verifyAboutProductDetailsSection() {
        driver.navigateToHomePage();
        HomePage homePage = PageFactory.homePage(driver);
        homePage.waitForPageLoad();
        homePage.closeGlowToasterModal();
        ProductResultsPage productResultsPage =
                homePage.clickHamburgerMenuLinksUnderAllNav(
                        AllHamburgerMenu.TV_APPLIANCES_ELECTRONICS, HamburgerSubMenu.TELEVISIONS);
        productResultsPage.waitForPageLoad();
        productResultsPage.filterComponent().applyFilter(Filter.BRANDS, FilterOption.BRAND_SAMSUNG);
        productResultsPage.sortComponent().productsSortBy(SortBy.HIGH_TO_LOW);

        ProductDetailsPage productDetailsPage = productResultsPage.clickOnProduct(5);
        driver.switchToWindow(2);
        productDetailsPage.waitForPageLoad();
        String aboutItem = productDetailsPage.getAboutDetailsOfProduct();
        Assertions.assertFalse(aboutItem.isBlank(), productDetailsPage.productTitle + " product about section is empty.");
        logger.info("About details of " + productDetailsPage.productTitle);
        logger.info("\n" + aboutItem);
    }

    @AfterEach
    public void quitDriver() {
        driver.quitDriver();
    }
}
