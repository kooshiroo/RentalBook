import models.machine.base.machine.BaseMachine;
import models.user.enums.state.State;
import models.machine.common.machine.WelcomeMachine;
import models.machine.customer.machine.CustomerMachine;
import models.machine.staff.machine.StaffMachine;
import models.menu.Menu;
import models.menu.welcome.menu.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WelcomeMachine welcomeMachine = new WelcomeMachine();  // welcome machineの起動
        BaseMachine machine = welcomeMachine.runAndStartUserMachine();  // いずれかの権限のユーザーのマシーン起動
        machine.run();  // ユーザーのマシーン実行

    }
}