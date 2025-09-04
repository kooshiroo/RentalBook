package models.menu.staff.menu;

public enum LoginStaffMenu {
    BOOK_LIST("本一覧", "1"),
    BOOK_REGISTER("本登録", "2"),
    CUSTOMER_LIST("顧客一覧", "3"),
    HISTORY("貸出履歴", "4"),
    STAFF_REGISTER("スタッフ登録", "5"),
    LOGOUT("ログアウト", "6");

    private final String label;
    private final String number;
    private final String name;

    LoginStaffMenu(String label, String number) {
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
