package models.menu.customer.menu;

public enum LogoutCustomerMenu {
    LOGIN("ログイン", "1"),
    SIGNUP("新規登録", "2"),
    BACK_PAGE("戻る", "3");

    private final String label;
    private final String number;
    private final String name;

    LogoutCustomerMenu(String label, String number) {
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
