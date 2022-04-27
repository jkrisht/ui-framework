package amazon.factories;

public enum BundleFile {
    HOME_PAGE("HomePage"),
    PRODUCT_RESULTS_PAGE("ProductResultsPage");

    private String name;

    BundleFile(String fileName) {
        this.name = fileName;
    }

    public String getName() {
        return this.name;
    }
}
