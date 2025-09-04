package models.menu.staff.menu;

public enum LogoutStaffMenu {
    LOGIN("ログイン", "1"),
    SIGNUP("新規登録", "2"),
    BACK_PAGE("戻る", "3");

    private final String label;
    private final String number;
    private final String name;

    LogoutStaffMenu(String label, String number) {
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
