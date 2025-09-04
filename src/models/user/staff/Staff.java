package models.user.staff;

import models.user.BaseUser;
import models.user.enums.gender.Gender;
import models.user.enums.state.State;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Staff extends BaseUser {
    private final int userId;

    private static int idCounter = 1;
    public Staff(String email, String password, String firstName, String familyName, Gender gender,
                 LocalDate birthday, State state, LocalDateTime createdDate) {
        super(email, password, firstName, familyName, gender, birthday, createdDate);
        userId = idCounter++;
    }
    public Staff(String email, String password) {
        super(email, password);
        userId = idCounter++;
    }
    public int getUserId() {
        return userId;
    }
}
