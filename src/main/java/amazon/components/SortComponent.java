package amazon.components;

import amazon.components.enums.SortBy;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

public class SortComponent extends BaseComponent {

    private final String baseElement = "s-result-sort-select";

    public SortComponent(AmazonDriver driver, BundleFile file) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public SortComponent(AmazonDriver driver) {
        this.driver = driver;
    }

    public By baseElement() {
        return By.id(baseElement);
    }

    public By selectedSortOption(SortBy sort) {
        return By.xpath("//select[@id='" + baseElement + "']/following-sibling::span[contains(normalize-space(), " +
                "'" + sort.getName() + "')]");
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("SortComponent - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        throw new RuntimeException("Method not implemented.");
    }

    public void productsSortBy(SortBy sortBy) {
        logger.info("productsSortBy(SortBy sortBy)");
        waitForComponentToLoad(10);
        driver.selectDropdownValue(baseElement(), sortBy.getValue());
        driver.waitUntilElementVisible(selectedSortOption(sortBy), 15);
    }

}
