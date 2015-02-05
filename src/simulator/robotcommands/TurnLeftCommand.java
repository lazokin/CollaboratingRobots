// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.events.SimEventDispatcher;
import simulator.robot.Robot;

public class TurnLeftCommand extends RobotCommand {

    public TurnLeftCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        robot.getHeadingState().turnLeft();
        SimEventDispatcher.getInstance().notifyRobotTurned(robot);
    }

    @Override
    public void reverse() {
        robot.getHeadingState().turnRight();
        SimEventDispatcher.getInstance().notifyRobotTurned(robot);
    }

}
