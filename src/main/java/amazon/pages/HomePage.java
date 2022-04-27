package amazon.pages;

import amazon.components.GlowToasterModal;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    public HomePage(AmazonDriver driver, BundleFile bundleFile) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(bundleFile);
    }

    public GlowToasterModal glowToasterModal() {
        return new GlowToasterModal(driver, BundleFile.HOME_PAGE);
    }

    public By searchBox() {
        return By.id("twotabsearchtextbox");
    }

    @Override
    public void waitForPageLoad() {
        logger.info("Wait for Home page to load.");
        driver.waitUntilElementVisible(searchBox(), 10);
        verifyPageTitle();
    }

    @Override
    public void verifyPageTitle() {
        logger.info("Validating home page title");
        String currentTitle = driver.getTitle();
        String expectedTitle = bundle.getString("pageTitle");
        assertEquals(currentTitle, expectedTitle, "Amazon home page browser title is incorrect.");
    }

    // Close Glow Toaster modal by clicking on Don't Change button
    public void closeGlowToasterModal() {
        logger.info("closeGlowToasterModal()");
        GlowToasterModal modal = glowToasterModal();
        modal.clickDoNotChangeButton();
    }
}
