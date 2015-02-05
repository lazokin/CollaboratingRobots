// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot;

public class RobotFactory {

    public RobotFactory() {
        super();
    }

    public Robot createRobot(String robotID, RobotType robotType,
            int positionX, int positionY, int positionZ) {

        switch (robotType) {
        case BASIC_ANDROID:
            return new DefaultAndroidRobot(robotID, positionX, positionY,
                    positionZ);
        case FAST_ANDROID:
            return new FastAndroidRobot(robotID, positionX, positionY,
                    positionZ);
        default:
            return null;
        }

    }

}
