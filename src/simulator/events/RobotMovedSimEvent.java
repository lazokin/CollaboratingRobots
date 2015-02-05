// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class RobotMovedSimEvent extends SimEvent {

    private String robotID;
    private int fromPositionX, fromPositionY, fromPositionZ;
    private int toPositionX, toPositionY, toPositionZ;

    public RobotMovedSimEvent(String robotID, int fromPositionX,
            int fromPositionY, int fromPositionZ, int toPositionX,
            int toPositionY, int toPositionZ) {
        super();
        this.robotID = robotID;
        this.fromPositionX = fromPositionX;
        this.fromPositionY = fromPositionY;
        this.fromPositionZ = fromPositionZ;
        this.toPositionX = toPositionX;
        this.toPositionY = toPositionY;
        this.toPositionZ = toPositionZ;
    }

    public String getRobotID() {
        return robotID;
    }

    public int getFromPositionX() {
        return fromPositionX;
    }

    public int getFromPositionY() {
        return fromPositionY;
    }

    public int getFromPositionZ() {
        return fromPositionZ;
    }

    public int getToPositionX() {
        return toPositionX;
    }

    public int getToPositionY() {
        return toPositionY;
    }

    public int getToPositionZ() {
        return toPositionZ;
    }

}
