// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

import simulator.robot.heading.RobotHeadingType;

public class RobotTurnedSimEvent extends SimEvent {

    private String robotID;
    private RobotHeadingType robotHeadingType;
    private int positionX, positionY, positionZ;

    public RobotTurnedSimEvent(String robotID,
            RobotHeadingType robotHeadingType, int positionX, int positionY,
            int positionZ) {
        super();
        this.robotID = robotID;
        this.robotHeadingType = robotHeadingType;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public String getRobotID() {
        return robotID;
    }

    public RobotHeadingType getRobotHeadingType() {
        return robotHeadingType;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionZ() {
        return positionZ;
    }

}
