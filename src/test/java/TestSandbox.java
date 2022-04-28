import amazon.components.enums.AllHamburgerMenu;
import amazon.components.enums.Filter;
import amazon.components.enums.FilterOption;
import amazon.components.enums.HamburgerSubMenu;
import amazon.components.enums.SortBy;
import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.factories.PageFactory;
import amazon.pages.HomePage;
import amazon.pages.ProductDetailsPage;
import amazon.pages.ProductResultsPage;
import amazon.utils.AmazonDriver;
import com.typesafe.config.Config;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private AmazonDriver driver = new AmazonDriver(DriverFactory.getDriver());
    private Logger logger = Logger.getLogger(this.getClass());

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);
        HomePage homePage = PageFactory.homePage(driver);
        homePage.waitForPageLoad();
        homePage.closeGlowToasterModal();
        ProductResultsPage productResultsPage =
                homePage.clickHamburgerMenuLinksUnderAllNav(AllHamburgerMenu.COMPUTERS, HamburgerSubMenu.COMPUTER_COMPONENTS);
        productResultsPage.waitForPageLoad();
        productResultsPage.filterComponent().applyFilter(Filter.SELLER, FilterOption.SELLER_AMAZON);
        productResultsPage.sortComponent().productsSortBy(SortBy.HIGH_TO_LOW);

        ProductDetailsPage productDetailsPage = productResultsPage.clickOnProduct(5);
        productDetailsPage.waitForPageLoad();
        String aboutItem = productDetailsPage.getAboutDetailsOfProduct();
        Assertions.assertFalse(aboutItem.isBlank(), productDetailsPage.productTitle + " product about section is empty.");
        logger.info("About details of " + productDetailsPage.productTitle);
        logger.info(aboutItem);
        System.out.println(aboutItem);
    }
}
