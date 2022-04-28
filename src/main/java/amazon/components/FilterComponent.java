package amazon.components;

import amazon.components.enums.Filter;
import amazon.components.enums.FilterOption;
import amazon.factories.BundleFile;
import amazon.utils.AmazonDriver;
import amazon.utils.PropertiesUtil;
import org.openqa.selenium.By;

public class FilterComponent extends BaseComponent {

    private final String baseElement = "filters";

    public FilterComponent(AmazonDriver driver, BundleFile file) {
        this.driver = driver;
        this.bundle = PropertiesUtil.getBundle(file);
    }

    public FilterComponent(AmazonDriver driver) {
        this.driver = driver;
    }

    public By baseElement() {
        return By.id(baseElement);
    }

    public By selectFilter(Filter filter, FilterOption option) {
        return By.xpath("//div[@id='" + baseElement + "']//div[normalize-space()='" + filter.getFilterName() + "']" +
                "/following-sibling::ul//a[normalize-space()='" + option.getFilterOptionName() + "']");
    }

    public By selectedFilter(Filter filter, FilterOption option) {
        return By.xpath("//div[@id='" + baseElement + "']//div[normalize-space()='" + filter.getFilterName() + "']" +
                "/following-sibling::ul//a[normalize-space()='" + option.getFilterOptionName() + "']" +
                "//span[contains(@class, 'bold')]");
    }

    @Override
    public boolean isPresent() {
        return driver.isDisplayed(baseElement());
    }

    @Override
    public void waitForComponentToLoad(int timeoutInSeconds) {
        logger.info("FilterComponent - waitForComponentToLoad");
        driver.waitUntilElementVisible(baseElement(), timeoutInSeconds);
    }

    @Override
    public void waitForComponentToDisappear(int timeoutInSeconds) {
        throw new RuntimeException("Method nor implemented.");
    }

    /**
     * Apply filter with given option
     *
     * @param filter
     * @param option
     */
    public void applyFilter(Filter filter, FilterOption option) {
        logger.info("applyFilter(Filter filter, FilterOption option): " + filter.getFilterName() + ", " + option.getFilterOptionName());
        waitForComponentToLoad(10);
        driver.scrollToElement(selectFilter(filter, option));
        driver.clickElement(selectFilter(filter, option));
        driver.waitUntilElementVisible(selectedFilter(filter, option), 15);
    }
}
