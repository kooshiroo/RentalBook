package models.user.enums.state;

public enum State {
    LOGGED_IN("ログイン"),
    LOGGED_OUT("ログアウト");

    private final String label;

    State(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
