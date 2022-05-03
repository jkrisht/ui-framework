package amazon.components.enums;

public enum AllHamburgerMenu {
    TV_APPLIANCES_ELECTRONICS("TV, Appliances, Electronics", "tv, audio & cameras"),
    COMPUTERS("Computers", "computers"),
    ELECTRONICS("Electronics", "electronics");


    private String name;
    private String subMenuHeader;

    AllHamburgerMenu(String name, String subMenuHeader) {
        this.name = name;
        this.subMenuHeader = subMenuHeader;
    }

    public String getName() {
        return this.name;
    }

    public String getSubMenuHeader() {
        return this.subMenuHeader;
    }
}
