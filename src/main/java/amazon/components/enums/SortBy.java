package amazon.components.enums;

public enum SortBy {
    LOW_TO_HIGH("Price: Low to High", "price-asc-rank"),
    HIGH_TO_LOW("Price: High to Low", "price-desc-rank");

    private String name;
    private String value;

    SortBy(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
