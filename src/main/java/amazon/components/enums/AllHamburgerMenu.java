package amazon.components.enums;

public enum AllHamburgerMenu {
    COMPUTERS("Computers"),
    ELECTRONICS("Electronics");


    private String name;

    AllHamburgerMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
