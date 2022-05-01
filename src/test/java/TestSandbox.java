import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        AmazonDriver driver = AmazonDriver.getAmazonDriver();
        driver.navigateToHomePage();
        assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());
        driver.quitDriver();
    }

    @Test
    void assertPropertyUtils() {
        ResourceBundle bundle = PropertiesUtil.getBundle(BundleFile.TEST);
        assertEquals("test1", bundle.getString("test1"), "PropertiesUtil functionality is broken");
        assertEquals("true", bundle.getString("test2"), "PropertiesUtil functionality is broken");
        assertEquals("3", bundle.getString("test3"), "PropertiesUtil functionality is broken");
    }
}
