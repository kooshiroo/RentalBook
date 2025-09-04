package files.enums.user;

public enum UsersFilePath {
    CUSTOMER_FILE_PATH("./src/files/users/customers/customer.csv"),
    STAFF_FILE_PATH("./src/files/users/staffs/staff.csv");

    private final String label;

    UsersFilePath(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
