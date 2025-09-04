package models.machine.base.machine;

import models.menu.Menu;
import models.menu.customer.menu.LoginCustomerMenu;
import models.menu.customer.menu.LogoutCustomerMenu;
import models.menu.staff.menu.LoginStaffMenu;
import models.menu.staff.menu.LogoutStaffMenu;
import models.menu.welcome.menu.WelcomeMenu;
import models.user.enums.role.Role;
import models.user.enums.state.State;
import validation.menu.MenuValidationChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class BaseMachine {
    private List<Menu> menuList;
    private State userState;
    private Role userRole;

    public BaseMachine(State userState, Role userRole) {
        this.userState = userState;  // ログイン中かログアウト状態か
        this.userRole = userRole;  // 一般ユーザーかスタッフか
        this.menuList = initialize();  // インストールされたメニュー
    }

    private List<Menu> initialize() {
        List<Menu> menuList = new ArrayList<>();
        if (userRole == Role.WELCOME) {                                          // 初期画面
            for (WelcomeMenu menu : WelcomeMenu.values()) {
                menuList.add(new Menu(menu.getName(), menu.getNumber(), menu.getLabel()));
            }
        } else if (userState == State.LOGGED_IN && userRole == Role.CUSTOMER) {  // ログイン一般ユーザー
            for (LoginCustomerMenu menu : LoginCustomerMenu.values()) {
                menuList.add(new Menu(menu.getName(), menu.getNumber(), menu.getLabel()));
            }
        } else if (userState == State.LOGGED_OUT && userRole == Role.CUSTOMER) {  // ログアウト一般ユーザー
            for (LogoutCustomerMenu menu : LogoutCustomerMenu.values()) {
                menuList.add(new Menu(menu.getName(), menu.getNumber(), menu.getLabel()));
            }
        } else if (userState == State.LOGGED_IN && userRole == Role.STAFF) {  // ログインスタッフ
            for (LoginStaffMenu menu : LoginStaffMenu.values()) {
                menuList.add(new Menu(menu.getName(), menu.getNumber(), menu.getLabel()));
            }
        } else if (userState == State.LOGGED_OUT && userRole == Role.STAFF) {  // ログアウトスタッフ
            for (LogoutStaffMenu menu : LogoutStaffMenu.values()) {
                menuList.add(new Menu(menu.getName(), menu.getNumber(), menu.getLabel()));
            }
        }
        return menuList;
    }

    public void run() {}  // WelcomeMachineではvoidを返却するメソッド使わないので、抽象メソッドにしない/できない

    protected Menu runAndGetMenu() {
        // メニューを表示し、ユーザーに選択してもらい、選択されたメニューを返す
        System.out.println("メニューを選択してください");
        displayMenu();
        return inputMenuNumber();
    }

    private List<Menu> getMenuList() {
        return menuList;
    }

    // メニュー一覧を表示
    private void displayMenu() {
        for (Menu menu : menuList) {
            System.out.println(menu.getNumber() + ": " + menu.getLabel());
        }
    }

    // ユーザーにメニューの入力を要求
    private Menu inputMenuNumber() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String inputItem = sc.nextLine();
            // バリデーションチェック
            MenuValidationChecker checker = new MenuValidationChecker(menuList);  // Hint: ずっと持っといてほしいもの、使いまわすものを初期値に入れる
            if (checker.menuContainsItem(inputItem)) {
                try {
                    return searchMenuByNumber(inputItem);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(inputItem + "は不正な入力です");
            }
        }
    }
    // numberによるMenuの検索
    protected Menu searchMenuByNumber(String number) throws Exception {
        for (Menu menu : menuList) {
            if (number.equals(menu.getNumber())) {
                return menu;
            }
        }
        throw new Exception("指定されたnumberをもつMenuがありません");
    }

    public Role getUserRole() {
        return userRole;
    }

    public State getUserState() {
        return userState;
    }
}
