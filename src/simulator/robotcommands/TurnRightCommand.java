// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.events.SimEventDispatcher;
import simulator.robot.Robot;

public class TurnRightCommand extends RobotCommand {

    public TurnRightCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        robot.getHeadingState().turnRight();
        SimEventDispatcher.getInstance().notifyRobotTurned(robot);
    }

    @Override
    public void reverse() {
        robot.getHeadingState().turnLeft();
        SimEventDispatcher.getInstance().notifyRobotTurned(robot);
    }

}
