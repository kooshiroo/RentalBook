package models.machine.common.machine;

import models.user.BaseUser;
import models.user.enums.gender.Gender;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserSettingMachine {
    private BaseUser user;
    private final Scanner sc = new Scanner(System.in);

    public UserSettingMachine(BaseUser user) {
        this.user = user;
    }

    public BaseUser setup() throws Exception {
        try {
            String familyName = inputFamilyName();
            String firstName = inputFirstName();
            Gender gender = inputGender();
            LocalDate birthday = inputBirthday();
            user.setFamilyName(familyName);
            user.setFirstName(firstName);
            user.setGender(gender);
            user.setBirthday(birthday);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new Exception("設定に失敗しました");
    }

    private String inputFirstName() throws Exception {
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("名を入力してください");
            System.out.print("> ");
            String firstName = sc.nextLine();
            if (!firstName.isEmpty()) {
                isRunning = false;
                return firstName;
            }
        }
        throw new Exception("エラーが発生しました");
    }

    private String inputFamilyName() throws Exception {
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("姓を入力してください");
            System.out.print("> ");
            String familyName = sc.nextLine();
            if (!familyName.isEmpty()) {
                isRunning = false;
                return familyName;
            }
        }
        throw new Exception("エラーが発生しました");
    }

    private Gender inputGender() throws Exception {
        boolean isRunning = true;
        Gender[] genderArray= Gender.values();

        while(isRunning) {
            System.out.println("性別を選択してください");
            System.out.print("> ");

            // 性別メニューを表示
            for (int i = 0; i < genderArray.length; i++) {
                System.out.println((i + 1) + ": " + genderArray[i].getLabel());
            }

            String genderStr = sc.nextLine();
            try {
                int genderInt = Integer.parseInt(genderStr);
                if (1 <= genderInt && genderInt <= genderArray.length) {
                    isRunning = false;
                    return genderArray[genderInt - 1];
                } else {
                    System.out.println("不正な入力です");
                }
            } catch (NumberFormatException e) {
                System.out.println("不正な入力です");
            }
        }
        throw new Exception("エラーが発生しました");
    }

    private LocalDate inputBirthday() throws Exception {
        boolean isRunning = true;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        while(isRunning) {
            System.out.println("誕生日を入力してください。例：2025/01/01");
            System.out.print("> ");
            String birthdayStr = sc.nextLine();
            if (!birthdayStr.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
                System.out.println("日付の形式が不正です");
                continue;
            }
            try {
                isRunning = false;
                return LocalDate.parse(birthdayStr, fmt);
            } catch(DateTimeException e) {
                isRunning = true;
                System.out.println("不正な日付です");
            }
        }
        throw new Exception("エラーが発生しました");
    }
}
