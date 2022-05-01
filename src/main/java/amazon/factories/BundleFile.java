package amazon.factories;

public enum BundleFile {
    TEST("test"),
    HOME_PAGE("HomePage"),
    PRODUCT_RESULTS_PAGE("ProductResultsPage"),
    PRODUCT_DETAILS_PAGE("ProductDetailsPage");

    private String name;

    BundleFile(String fileName) {
        this.name = fileName;
    }

    public String getName() {
        return this.name;
    }
}
