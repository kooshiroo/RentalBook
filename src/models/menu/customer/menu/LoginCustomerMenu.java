package models.menu.customer.menu;

public enum LoginCustomerMenu {
    RENTAL_BOOK("本の貸出", "1"),
    RETURN_BOOK("本の返却", "2"),
    SEARCH_BOOK("本の検索", "3"),
    HISTORY("貸出履歴", "4"),
    LOGOUT("ログアウト", "5");

    private final String label;
    private final String number;
    private final String name;

    LoginCustomerMenu(String label, String number) {
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
