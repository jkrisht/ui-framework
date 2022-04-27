package amazon.components.enums;

public enum Filter {
    SELLER("Seller"),
    CONDITION("Condition");

    private String filterName;

    Filter(String name) {
        this.filterName = name;
    }

    public String getFilterName() {
        return this.filterName;
    }
}
