package amazon.factories;

import amazon.pages.HomePage;
import amazon.utils.AmazonDriver;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    synchronized public static HomePage homePage(AmazonDriver driver) {
        return new HomePage(driver, BundleFile.HOMEPAGE);
    }
}
