// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

import simulator.robot.RobotType;

public class RobotAddedSimEvent extends SimEvent {

    private String robotID;
    private RobotType robotType;
    private int positionX, positionY, positionZ;

    public RobotAddedSimEvent(String robotID, RobotType robotType,
            int positionX, int positionY, int positionZ) {
        super();
        this.robotID = robotID;
        this.robotType = robotType;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public String getRobotID() {
        return robotID;
    }

    public RobotType getRobotType() {
        return robotType;
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
