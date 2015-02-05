// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.exceptions;

import simulator.robot.Robot;

@SuppressWarnings("serial")
public class SimObjectCollisionException extends BotSimulatorException {

    Robot robot;
    int collisionX;
    int collisionY;
    int collisionZ;

    public SimObjectCollisionException(Robot robot, int collisionX,
        int collisionY, int collisionZ) {
        super();
        this.robot = robot;
        this.collisionX = collisionX;
        this.collisionY = collisionY;
        this.collisionZ = collisionZ;
    }

    public Robot getRobot() {
        return robot;
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
