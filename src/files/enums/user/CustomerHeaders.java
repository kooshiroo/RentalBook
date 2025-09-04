package files.enums.user;

public enum CustomerHeaders {
    ID("ID", "ID"),
    EMAIL("メールアドレス", "Email"),
    PASSWORD("パスワード", "Password"),
    FIRST_NAME("名", "First Name"),
    FAMILY_NAME("姓", "Family Name"),
    GENDER("性別", "Gender"),
    BIRTHDAY("誕生日", "Birthday"),
    CREATED_DATE("登録日", "Created Date");

    private final String label;
    private final String headerName;

    CustomerHeaders(String label, String headerName) {
        this.label = label;
        this.headerName = headerName;
    }

    public String getLabel() {
        return label;
    }

    public String getHeaderName() {
        return headerName;
    }
}

