package models.menu;

import models.menu.customer.menu.LoginCustomerMenu;
import models.menu.customer.menu.LogoutCustomerMenu;
import models.menu.staff.menu.LoginStaffMenu;
import models.menu.staff.menu.LogoutStaffMenu;
import models.menu.welcome.menu.WelcomeMenu;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private String name;
    private String number;
    private String label;

    public Menu(String name, String number, String label) {
        this.name = name;
        this.number = number;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getLabel() {
        return label;
    }
   }
