package amazon.factories;

public enum BundleFile {
    HOMEPAGE("HomePage");

    private String name;

    BundleFile(String fileName) {
        this.name = fileName;
    }

    public String getName() {
        return this.name;
    }
}
