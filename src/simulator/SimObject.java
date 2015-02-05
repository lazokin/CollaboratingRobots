// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator;

import simulator.exceptions.SimObjectCollisionException;
import simulator.exceptions.SimObjectOutOfBoundsException;
import simulator.robot.Robot;

public class SimObject {

    private String ID;
    private int positionX, positionY, positionZ;
    private int previousPositionX, previousPositionY, previousPositionZ;
    private int startPositionX, startPositionY, startPositionZ;;

    public SimObject(String ID, int positionX, int positionY, int positionZ) {
        super();
        this.ID = ID;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.previousPositionX = positionX;
        this.previousPositionY = positionY;
        this.previousPositionZ = positionZ;
        this.startPositionX = positionX;
        this.startPositionY = positionY;
        this.startPositionZ = positionZ;
    }

    public String getID() {
        return ID;
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

    private void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    private void setPositionZ(int positionZ) {
        this.positionZ = positionZ;
    }

    public int getPreviousPositionX() {
        return previousPositionX;
    }

    public int getPreviousPositionY() {
        return previousPositionY;
    }

    public int getPreviousPositionZ() {
        return previousPositionZ;
    }

    private void setPreviousPositionX(int previousPositionX) {
        this.previousPositionX = previousPositionX;
    }

    private void setPreviousPositionY(int previousPositionY) {
        this.previousPositionY = previousPositionY;
    }

    private void setPreviousPositionZ(int previousPositionZ) {
        this.previousPositionZ = previousPositionZ;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public int getStartPositionZ() {
        return startPositionZ;
    }

    public void moveBy(int distanceX, int distanceY, int distanceZ)
        throws SimObjectOutOfBoundsException, SimObjectCollisionException {
        int newPositionX = getPositionX() + distanceX;
        int newPositionY = getPositionY() + distanceY;
        int newPositionZ = getPositionZ() + distanceZ;

        boolean inBoundsMove = SimCoordinator.getInstance().pathExists(
            newPositionX, newPositionY, newPositionZ);
        if (!inBoundsMove) {
            throw new SimObjectOutOfBoundsException(newPositionX, newPositionY,
                newPositionZ);
        }
        boolean destinationHasRobot = SimCoordinator.getInstance().getPath(
            newPositionX, newPositionY, newPositionZ).hasRobot();
        Robot robot = SimCoordinator.getInstance().getPath(newPositionX,
            newPositionY, newPositionZ).getRobot();
        if (destinationHasRobot) {
            throw new SimObjectCollisionException(robot, newPositionX,
                newPositionY, newPositionZ);
        }

        setPreviousPositionX(getPositionX());
        setPreviousPositionY(getPositionY());
        setPreviousPositionZ(getPositionZ());
        setPositionX(newPositionX);
        setPositionY(newPositionY);
        setPositionZ(newPositionZ);
    }

    public void moveTo(int newPositionX, int newPositionY, int newPositionZ)
        throws SimObjectOutOfBoundsException, SimObjectCollisionException {

        boolean inBoundsMove = SimCoordinator.getInstance().pathExists(
            newPositionX, newPositionY, newPositionZ);
        if (!inBoundsMove) {
            throw new SimObjectOutOfBoundsException(newPositionX, newPositionY,
                newPositionZ);
        }
        boolean destinationHasRobot = SimCoordinator.getInstance().getPath(
            newPositionX, newPositionY, newPositionZ).hasRobot();
        Robot robot = SimCoordinator.getInstance().getPath(newPositionX,
            newPositionY, newPositionZ).getRobot();
        if (destinationHasRobot) {
            throw new SimObjectCollisionException(robot, newPositionX,
                newPositionY, newPositionZ);
        }

        setPreviousPositionX(getPositionX());
        setPreviousPositionY(getPositionY());
        setPreviousPositionZ(getPositionZ());
        setPositionX(newPositionX);
        setPositionY(newPositionY);
        setPositionZ(newPositionZ);
    }

    public void reset() {
        setPositionX(getStartPositionX());
        setPositionY(getStartPositionY());
        setPositionZ(getStartPositionZ());
        setPreviousPositionX(getStartPositionX());
        setPreviousPositionY(getStartPositionY());
        setPreviousPositionZ(getStartPositionZ());
    }

}
