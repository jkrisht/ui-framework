package amazon.components;

import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

public class GlowToasterModal extends BaseComponent {

    private final String baseElement = "glow-toaster-body";

    public GlowToasterModal(AmazonDriver driver, BundleFile bundleFile) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(bundleFile);
    }

    public GlowToasterModal(AmazonDriver driver) {
        this.driver = driver;
    }

    public By baseElement() {
        return By.id("glow-toaster-body");
    }

    public By doNotChangeButton() {
        return By.xpath("//span/span[normalize-space()=\"" + bundle.getString("glowToasterDonNotChangeButton") + "\"]");
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("GlowToasterModal - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        logger.info("GlowToasterModal - waitForComponentToDisappear");
        driver.waitUntilElementNotVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    /**
     * Click on Don't Change button in the modal
     */
    public void clickDoNotChangeButton() {
        logger.info("clickDoNotChangeButton()");
        if (driver.isDisplayed(baseElement())) {
            waitForComponentToLoad(10);
            driver.clickElement(doNotChangeButton());
            waitForComponentToDisappear(10);
        }
    }
}
