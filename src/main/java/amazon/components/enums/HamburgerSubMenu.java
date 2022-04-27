package amazon.components.enums;

public enum HamburgerSubMenu {
    COMPUTER_ACCESSORIES("Computer Accessories & Peripherals"),
    COMPUTER_COMPONENTS("Computer Components");

    private String name;

    HamburgerSubMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
