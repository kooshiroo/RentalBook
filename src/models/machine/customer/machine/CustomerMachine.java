package models.machine.customer.machine;

import models.machine.common.machine.UserSettingMachine;
import models.machine.common.machine.UserSignupMachine;
import models.menu.customer.menu.LoginCustomerMenu;
import models.menu.customer.menu.LogoutCustomerMenu;
import models.user.BaseUser;
import models.user.customer.Customer;
import models.user.enums.role.Role;
import models.user.enums.state.State;
import models.machine.base.machine.BaseMachine;
import models.menu.Menu;

public class CustomerMachine extends BaseMachine {

    public CustomerMachine(State state) {
        super(state, Role.CUSTOMER);
    }

    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Menu inputMenu = runAndGetMenu();
            isRunning = runMenuAndIfContinues(inputMenu);  // ここでメニューの実行も行う
        }
    }

    private boolean runMenuAndIfContinues(Menu menu) {  // メニューを実行。本機械のループを抜けるかどうかも返す。
        if (this.getUserState() == State.LOGGED_IN) {    // ログイン時
            if (menu.getNumber().equals((LoginCustomerMenu.RENTAL_BOOK.getNumber()))) {
                System.out.println("本の貸出をします\n");
                return true;
            } else if (menu.getNumber().equals((LoginCustomerMenu.RETURN_BOOK.getNumber()))) {
                System.out.println("本の返却をします\n");
                return true;
            } else if (menu.getNumber().equals((LoginCustomerMenu.SEARCH_BOOK.getNumber()))) {
                System.out.println("本の検索をします\n");
                return true;
            } else if (menu.getNumber().equals((LoginCustomerMenu.HISTORY.getNumber()))) {
                System.out.println("貸出履歴を表示します\n");
                return true;
            } else if (menu.getNumber().equals((LoginCustomerMenu.LOGOUT.getNumber()))) {
                System.out.println("ログアウトします\n");
                return false;
            }
        }

        else if (this.getUserState() == State.LOGGED_OUT) {    // ログアウト状態の時
            if (menu.getNumber().equals((LogoutCustomerMenu.LOGIN.getNumber()))) {
                System.out.println("ログインします\n");
                return true;
            } else if (menu.getNumber().equals((LogoutCustomerMenu.SIGNUP.getNumber()))) {
                System.out.println("新規登録します\n");
                UserSignupMachine signupMachine = new UserSignupMachine(Role.CUSTOMER);
                BaseUser customer = signupMachine.signup();
                UserSettingMachine settingMachine = new UserSettingMachine(customer);
                try {
                    settingMachine.setup();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return true;
            } else if (menu.getNumber().equals((LogoutCustomerMenu.BACK_PAGE.getNumber()))) {
                System.out.println("戻ります\n");
                return false;
            }
        }
        System.out.println("不正なメニューです");
        return false;
    }
}
