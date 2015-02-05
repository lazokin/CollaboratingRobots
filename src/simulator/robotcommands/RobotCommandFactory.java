// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.robot.Robot;

public class RobotCommandFactory {

    public RobotCommandFactory() {
        super();
    }

    public RobotCommand createCommand(RobotCommandType robotCommandType,
            Robot robot) {

        switch (robotCommandType) {
        case MOVE_NORTH:
            return new MoveNorthCommand(robot);
        case MOVE_SOUTH:
            return new MoveSouthCommand(robot);
        case MOVE_EAST:
            return new MoveEastCommand(robot);
        case MOVE_WEST:
            return new MoveWestCommand(robot);
        case MOVE_UP:
            return new MoveUpCommand(robot);
        case MOVE_DOWN:
            return new MoveDownCommand(robot);
        case PICK:
            return new PickCommand(robot);
        case DROP:
            return new DropCommand(robot);
        case WAIT:
            return new WaitCommand(robot);
        case MOVE_FORWARD:
            return new MoveForwardCommand(robot);
        case MOVE_BACKWARD:
            return new MoveBackwardCommand(robot);
        case TURN_LEFT:
            return new TurnLeftCommand(robot);
        case TURN_RIGHT:
            return new TurnRightCommand(robot);
        default:
            return null;
        }

    }

}
