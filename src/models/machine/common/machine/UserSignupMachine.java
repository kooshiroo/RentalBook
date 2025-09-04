package models.machine.common.machine;

import file.operations.FileFieldSearcher;
import file.operations.FileWriter;
import files.enums.user.CustomerHeaders;
import files.enums.user.UsersFilePath;
import models.user.BaseUser;
import models.user.customer.Customer;
import models.user.enums.role.Role;
import models.user.staff.Staff;

import java.nio.file.Path;
import java.util.*;

public class UserSignupMachine {

    private Role role;
    private Path filePath;

    public UserSignupMachine(Role role) {
        this.role = role;
        try {
            this.filePath = initializeFilePath(role);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }

    // インスタンス変数filePathをroleによって初期化
    private Path initializeFilePath(Role role) throws IllegalAccessException {
        switch (role) {
            case Role.CUSTOMER -> { return Path.of(UsersFilePath.CUSTOMER_FILE_PATH.getLabel()); }
            case Role.STAFF -> { return Path.of(UsersFilePath.STAFF_FILE_PATH.getLabel()); }
            default -> throw new IllegalAccessException("Signupの初期化に失敗しました");
        }
    }

    // これを各マシーンで呼び出してユーザー登録する
    public BaseUser signup() {
        FileWriter writer = new FileWriter(filePath);
        Map<String, String> emailAndPassword = inputEmailAndPassword();  // メアドとパスワードの入力を要求
        if (emailAndPassword == null) {
            throw new NullPointerException("なんらかの原因で新規登録に失敗しました");
        } else {
            writer.appendMap(emailAndPassword);
            if (role == Role.CUSTOMER) {
                return new Customer(emailAndPassword.get("Email"), emailAndPassword.get("Password"));
            } else {
                return new Staff(emailAndPassword.get("Email"), emailAndPassword.get("Password"));
            }
        }

    }

    private Map<String, String> inputEmailAndPassword() {
        Map<String, String> emailAndPassword = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        FileFieldSearcher searcher = new FileFieldSearcher(filePath);

        boolean emailInputContinues = true;
        while (emailInputContinues) {
            System.out.println("メールアドレスを入力して下さい");
            System.out.print("> ");
            String email = sc.nextLine();
            if (!checkEmail(email)) {
                System.out.println("メールアドレスの形式が不正です");
                continue;
            }
            if (searcher.ifHeaderContainsItem(CustomerHeaders.EMAIL.getHeaderName(), email)) {
                System.out.println(email + "というメールアドレスは既に登録されています\n");
                continue;
            }
            emailAndPassword.put("Email", email);
            emailInputContinues = false;
        }

        boolean passwordInputContinues = true;
        while (passwordInputContinues) {
            System.out.println("パスワードを英数字8文字以上で入力して下さい");
            System.out.print("> ");
            String password = sc.nextLine();
            if (!checkPassword(password)) {
                System.out.println("パスワードの形式に不正があります\n");
                continue;
            }
            emailAndPassword.put("Password", password);
            passwordInputContinues = false;
        }
        return emailAndPassword;
    }

    private boolean checkPassword(String password) {
        return password.matches("^[A-Za-z0-9]{8,}$");
    }

    private boolean checkEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
