package models.machine.staff.machine;

import models.user.enums.role.Role;
import models.user.enums.state.State;
import models.machine.base.machine.BaseMachine;
import models.menu.Menu;

public class StaffMachine extends BaseMachine{

    public StaffMachine(State state) {
        super(state, Role.STAFF);
    }
}
