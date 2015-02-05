// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class ItemPickedFromPathSimEvent extends SimEvent {

    private String robotID;
    private String carryableID;
    private int positionX, positionY, positionZ;

    public ItemPickedFromPathSimEvent(String robotID, String carryableID,
            int positionX, int positionY, int positionZ) {
        super();
        this.robotID = robotID;
        this.carryableID = carryableID;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public String getRobotID() {
        return robotID;
    }

    public String getCarryableID() {
        return carryableID;
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
