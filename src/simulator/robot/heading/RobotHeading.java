// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot.heading;

import simulator.exceptions.SimObjectCollisionException;
import simulator.exceptions.SimObjectOutOfBoundsException;
import simulator.robot.Robot;

public abstract class RobotHeading {

    private RobotHeadingType robotHeading;
    private Robot robot;

    public RobotHeading(Robot robot) {
        super();
        this.robot = robot;
    }

    public RobotHeadingType getRobotHeading() {
        return robotHeading;
    }

    public void setHeadingType(RobotHeadingType robotHeading) {
        this.robotHeading = robotHeading;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public abstract void moveForward() throws SimObjectOutOfBoundsException,
        SimObjectCollisionException;

    public abstract void moveBackward() throws SimObjectOutOfBoundsException,
        SimObjectCollisionException;

    public abstract void turnLeft();

    public abstract void turnRight();

}
