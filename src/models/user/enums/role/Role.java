package models.user.enums.role;

public enum Role {
    CUSTOMER("一般ユーザー"),
    STAFF("スタッフ"),
    WELCOME("不明");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
