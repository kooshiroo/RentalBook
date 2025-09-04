package validation.menu;

import models.menu.Menu;

import java.util.List;
import java.util.Map;

public class MenuValidationChecker {
    private final List<Menu> menuList;  // メニュー一覧

    public MenuValidationChecker(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public boolean menuContainsItem(String inputItem) {
        for (Menu menu : menuList) {
            if (inputItem.equals((menu.getNumber()))) {
                return true;
            }
        }
        return false;
    }
}
