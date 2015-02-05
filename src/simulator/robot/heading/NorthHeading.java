// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot.heading;

import simulator.exceptions.SimObjectCollisionException;
import simulator.exceptions.SimObjectOutOfBoundsException;
import simulator.robot.Robot;

public class NorthHeading extends RobotHeading {

    public NorthHeading(Robot robot) {
        super(robot);
        super.setHeadingType(RobotHeadingType.NORTH);
    }

    @Override
    public void moveForward() throws SimObjectOutOfBoundsException,
        SimObjectCollisionException {
        super.getRobot().moveBy(0, 1, 0);
    }

    @Override
    public void moveBackward() throws SimObjectOutOfBoundsException,
        SimObjectCollisionException {
        super.getRobot().moveBy(0, -1, 0);
    }

    @Override
    public void turnLeft() {
        super.getRobot().setCurrentHeadingToWest();
    }

    @Override
    public void turnRight() {
        super.getRobot().setCurrentHeadingToEast();
    }

}
