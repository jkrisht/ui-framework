package amazon.components.enums;

public enum FilterOption {
    BRAND_SAMSUNG("Samsung"),
    SELLER_AMAZON("Amazon.com"),
    SELLER_CWP_ONLINE("CWP Online");

    private String name;

    FilterOption(String name) {
        this.name = name;
    }

    public String getFilterOptionName() {
        return this.name;
    }
}
