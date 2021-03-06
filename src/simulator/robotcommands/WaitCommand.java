// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.events.SimEventDispatcher;
import simulator.robot.Robot;

public class WaitCommand extends RobotCommand {

    public WaitCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        SimEventDispatcher.getInstance().notifyRobotWaited(robot);
    }

    @Override
    public void reverse() {
        SimEventDispatcher.getInstance().notifyRobotWaited(robot);
    }
}
