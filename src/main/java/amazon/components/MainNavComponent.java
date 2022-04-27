package amazon.components;

import amazon.components.enums.MainNav;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

public class MainNavComponent extends BaseComponent {

    private final String baseElement = "nav-main";

    public MainNavComponent(AmazonDriver driver, BundleFile bundleFile) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(bundleFile);
    }

    public MainNavComponent(AmazonDriver driver) {
        this.driver = driver;
    }

    public By baseElement() {
        return By.id(baseElement);
    }

    public By navLink(MainNav nav) {
        return By.xpath("//div[@id='nav-main']//a[normalize-space()='" + nav.getNav() + "']");
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("MainNavComponent - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        logger.info("MainNavComponent - waitForComponentToDisappear");
        driver.waitUntilElementNotVisible(baseElement(), timeoutInSeconds);
    }

    // Click the given nav link
    public void clickNavLink(MainNav nav) {
        logger.info("clickNavLink(MainNav nav)");
        waitForComponentToLoad(10);
        driver.clickElement(navLink(nav));
    }
}
