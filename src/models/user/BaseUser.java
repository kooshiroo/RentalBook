package models.user;

import models.user.enums.gender.Gender;
import models.user.enums.state.State;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class BaseUser {
    private String email;
    private String password;
    private String firstName;
    private String familyName;
    private Gender gender;
    private LocalDate birthday;
    private LocalDateTime createdDate;

    public BaseUser(String email, String password, String firstName, String familyName,
                    Gender gender, LocalDate birthday, LocalDateTime createdDate) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.familyName = familyName;
        this.gender = gender;
        this.birthday = birthday;
        this.createdDate = createdDate;
    }

    public BaseUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public abstract int getUserId();
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getFamilyName() {
        return familyName;
    }
    public Gender getGender() {
        return gender;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
