package models.machine.common.machine;

import models.machine.customer.machine.CustomerMachine;
import models.machine.staff.machine.StaffMachine;
import models.menu.welcome.menu.WelcomeMenu;
import models.user.enums.role.Role;
import models.user.enums.state.State;
import models.machine.base.machine.BaseMachine;
import models.menu.Menu;
import validation.menu.MenuValidationChecker;


public class WelcomeMachine extends BaseMachine {

    public WelcomeMachine() {
        super(State.LOGGED_OUT, Role.WELCOME);
    }

    public BaseMachine runAndStartUserMachine() {
        System.out.println("ようこそ");
        Menu inputMenu = runAndGetMenu();
        return runMenuAndStartUserMachine(inputMenu);
    }

    private BaseMachine runMenuAndStartUserMachine(Menu menu) {
        if (menu.getNumber().equals(WelcomeMenu.CUSTOMER.getNumber())) {  // 一般ユーザーの時
            return new CustomerMachine(State.LOGGED_OUT);
        } else if (menu.getNumber().equals(WelcomeMenu.STAFF.getNumber())) {  // スタッフの時
            return new StaffMachine(State.LOGGED_OUT);
        } else {
            throw new IllegalArgumentException("メニューが不正です");
        }
    }
}
