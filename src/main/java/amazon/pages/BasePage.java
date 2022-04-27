package amazon.pages;

import amazon.components.AllHamburgerMenuComponent;
import amazon.components.MainNavComponent;
import amazon.components.enums.AllHamburgerMenu;
import amazon.components.enums.HamburgerSubMenu;
import amazon.components.enums.MainNav;
import amazon.factories.BundleFile;
import amazon.factories.PageFactory;
import amazon.utils.AmazonDriver;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;


/***
 * We will declare / implement reusable methods and variables across multiple pages
 */
public abstract class BasePage implements IPage {
    final Logger logger = Logger.getLogger(this.getClass());
    AmazonDriver driver;
    ResourceBundle bundle;

    public MainNavComponent mainNavComponent() {
        return new MainNavComponent(driver, BundleFile.HOME_PAGE);
    }

    public AllHamburgerMenuComponent allHamburgerMenuComponent() {
        return new AllHamburgerMenuComponent(driver, BundleFile.HOME_PAGE);
    }

    // Click the given menu nav link
    public void clickMenuNav(MainNav nav) {
        logger.info("clickMenuNav(MainNav nav)");
        mainNavComponent().clickNavLink(nav);
    }

    // Click All menu option and select Hamburger menu and sub-menu links
    public ProductResultsPage clickHamburgerMenuLinksUnderAllNav(AllHamburgerMenu menu, HamburgerSubMenu subMenu) {
        logger.info("clickHamburgerMenuLinksUnderAllNav(): " + menu.getName() + ", " + subMenu.getName());
        clickMenuNav(MainNav.ALL);
        allHamburgerMenuComponent().navigateToResultsPage(menu, subMenu);
        return PageFactory.productResultsPage(driver);
    }
}
