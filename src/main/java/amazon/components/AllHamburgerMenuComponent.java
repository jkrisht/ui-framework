package amazon.components;

import amazon.components.enums.AllHamburgerMenu;
import amazon.components.enums.HamburgerSubMenu;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

public class AllHamburgerMenuComponent extends BaseComponent {

    private final String baseElement = "hmenu-canvas";

    public AllHamburgerMenuComponent(AmazonDriver driver, BundleFile bundleFile) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(bundleFile);
    }

    public By baseElement() {
        return By.id(baseElement);
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    public By hamburgerMenuLink(String menu) {
        return By.xpath("//div[@id='hmenu-canvas']//a[normalize-space()=\"" + menu + "\"]");
    }

    public By hamburgerSubMenuHeader(String menuName) {
        return By.xpath("//div[@id='hmenu-content']//div[contains(@class, 'hmenu-title')]" +
                "[normalize-space()='" + menuName + "']");
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("AllHamburgerMenuComponent - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        logger.info("AllHamburgerMenuComponent - waitForComponentToDisappear");
        driver.waitUntilElementNotVisible(baseElement(), timeoutInSeconds);
    }

    // Click Main hamburger menu link
    public void clickHamburgerLink(AllHamburgerMenu menu) {
        logger.info("clickHamburgerLink(AllHamburgerMenu menu): " + menu.getName());
        waitForComponentToLoad(10);
        driver.clickElement(hamburgerMenuLink(menu.getName()));
        driver.waitUntilElementVisible(hamburgerSubMenuHeader(menu.getSubMenuHeader()), 10);
    }

    // Click hamburger submenu link
    public void clickSubMenuLink(HamburgerSubMenu subMenu) {
        logger.info("clickSubMenuLink(AllHamburgerMenu menu): " + subMenu.getName());
        waitForComponentToLoad(10);
        driver.clickElementUsingJS(hamburgerMenuLink(subMenu.getName()));
        waitForComponentToDisappear(10);
    }

    // Navigate to Category page by selecting both menu and submenu
    public void navigateToResultsPage(AllHamburgerMenu menu, HamburgerSubMenu subMenu) {
        logger.info("navigateToResultsPage(AllHamburgerMenu menu, HamburgerSubMenu subMenu): " + menu + ", " + subMenu);
        clickHamburgerLink(menu);
        clickSubMenuLink(subMenu);
    }
}
