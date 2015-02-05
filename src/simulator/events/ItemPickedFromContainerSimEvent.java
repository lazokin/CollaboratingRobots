// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class ItemPickedFromContainerSimEvent extends SimEvent {

    private String robotID;
    private String carryableID;
    private String containerID;
    private int positionX, positionY, positionZ;

    public ItemPickedFromContainerSimEvent(String robotID, String carryableID,
            String containerID, int positionX, int positionY, int positionZ) {
        super();
        this.robotID = robotID;
        this.carryableID = carryableID;
        this.containerID = containerID;
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

    public String getContainerID() {
        return containerID;
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
