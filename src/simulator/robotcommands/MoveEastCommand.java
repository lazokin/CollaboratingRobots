// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.events.SimEventDispatcher;
import simulator.exceptions.BotSimulatorException;
import simulator.exceptions.RobotCollisionException;
import simulator.exceptions.RobotOutOfBoundsException;
import simulator.exceptions.SimObjectCollisionException;
import simulator.exceptions.SimObjectOutOfBoundsException;
import simulator.robot.Robot;

public class MoveEastCommand extends RobotCommand {

    public MoveEastCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() throws BotSimulatorException {
        try {
            robot.moveBy(1, 0, 0);
        } catch (SimObjectOutOfBoundsException e) {
            SimEventDispatcher.getInstance().notifyRobotOutOfBounds(robot,
                e.getOutOfBoundsX(), e.getOutOfBoundsY(), e.getOutOfBoundsZ());
            throw new RobotOutOfBoundsException(robot.getID(), e
                .getOutOfBoundsX(), e.getOutOfBoundsY(), e.getOutOfBoundsZ());
        } catch (SimObjectCollisionException e) {
            SimEventDispatcher.getInstance().notifyRobotCollision(robot,
                e.getRobot(), e.getCollisionX(), e.getCollisionY(),
                e.getCollisionZ());
            throw new RobotCollisionException(robot.getID(), e.getRobot(), e
                .getCollisionX(), e.getCollisionY(), e.getCollisionZ());
        }
        SimEventDispatcher.getInstance().notifyRobotMoved(robot);
    }

    @Override
    public void reverse() throws BotSimulatorException {
        try {
            robot.moveBy(-1, 0, 0);
        } catch (SimObjectOutOfBoundsException e) {
            SimEventDispatcher.getInstance().notifyRobotOutOfBounds(robot,
                e.getOutOfBoundsX(), e.getOutOfBoundsY(), e.getOutOfBoundsZ());
            throw new RobotOutOfBoundsException(robot.getID(), e
                .getOutOfBoundsX(), e.getOutOfBoundsY(), e.getOutOfBoundsZ());
        } catch (SimObjectCollisionException e) {
            SimEventDispatcher.getInstance().notifyRobotCollision(robot,
                e.getRobot(), e.getCollisionX(), e.getCollisionY(),
                e.getCollisionZ());
            throw new RobotCollisionException(robot.getID(), e.getRobot(), e
                .getCollisionX(), e.getCollisionY(), e.getCollisionZ());
        }
        SimEventDispatcher.getInstance().notifyRobotMoved(robot);
    }

}
