// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.exceptions;

import simulator.robot.Robot;

@SuppressWarnings("serial")
public class RobotCollisionException extends SimObjectCollisionException {

    String robotID_1;
    String robotID_2;

    public RobotCollisionException(String robotID, Robot robot,
        int outOfBoundsX, int outOfBoundsY, int outOfBoundsZ) {
        super(robot, outOfBoundsX, outOfBoundsY, outOfBoundsZ);
        this.robotID_1 = robotID;
        this.robotID_2 = robot.getID();
    }

    public String getRobotID_1() {
        return robotID_1;
    }

    public String getRobotID_2() {
        return robotID_2;
    }

}
