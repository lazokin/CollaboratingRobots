// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot.heading;

import simulator.exceptions.SimObjectCollisionException;
import simulator.exceptions.SimObjectOutOfBoundsException;
import simulator.robot.Robot;

public class WestHeading extends RobotHeading {

    public WestHeading(Robot robot) {
        super(robot);
        super.setHeadingType(RobotHeadingType.WEST);
    }

    @Override
    public void moveForward() throws SimObjectOutOfBoundsException,
        SimObjectCollisionException {
        super.getRobot().moveBy(-1, 0, 0);
    }

    @Override
    public void moveBackward() throws SimObjectOutOfBoundsException,
        SimObjectCollisionException {
        super.getRobot().moveBy(1, 0, 0);
    }

    @Override
    public void turnLeft() {
        super.getRobot().setCurrentHeadingToSouth();
    }

    @Override
    public void turnRight() {
        super.getRobot().setCurrentHeadingToNorth();
    }

}
