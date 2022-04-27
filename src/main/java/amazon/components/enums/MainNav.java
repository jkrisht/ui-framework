package amazon.components.enums;

public enum MainNav {
    ALL("All"),
    TODAY_DEALS("Today's Deals");


    private String nav;

    MainNav(String nav) {
        this.nav = nav;
    }

    public String getNav() {
        return nav;
    }
}
