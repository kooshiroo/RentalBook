package models.menu.welcome.menu;

public enum WelcomeMenu {
    CUSTOMER("一般ユーザー", "1"),
    STAFF("スタッフ", "2");

    private final String label;
    private final String number;
    private final String name;

    WelcomeMenu(String label, String number) {
        this.label = label;
        this.number = number;
        this.name = this.name();
    }

    public String getLabel() {
        return label;
    }
    public String getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
}
