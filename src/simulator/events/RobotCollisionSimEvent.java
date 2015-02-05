// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class RobotCollisionSimEvent extends SimEvent {

    private String robotID_1;
    private String robotID_2;
    private int collisionX, collisionY, collisionZ;

    public RobotCollisionSimEvent(String robotID_1, String robotID_2,
        int collisionX, int collisionY, int collisionZ) {
        super();
        this.robotID_1 = robotID_1;
        this.robotID_2 = robotID_2;
        this.collisionX = collisionX;
        this.collisionY = collisionY;
        this.collisionZ = collisionZ;
    }

    public String getRobotID_1() {
        return robotID_1;
    }

    public String getRobotID_2() {
        return robotID_2;
    }

    public int getCollisionX() {
        return collisionX;
    }

    public int getCollisionY() {
        return collisionY;
    }

    public int getCollisionZ() {
        return collisionZ;
    }

}
