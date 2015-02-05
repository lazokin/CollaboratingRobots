// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot;

public class DefaultAndroidRobot extends Robot {

    public DefaultAndroidRobot(String robotID, int positionX, int positionY,
            int positionZ) {
        super(robotID, positionX, positionY, positionZ);
        super.setRobotType(RobotType.BASIC_ANDROID);
    }

}
