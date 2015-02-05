// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.interfaces;

import simulator.LocationState;
import simulator.items.ItemType;
import simulator.robot.RobotType;

public interface SimController {

    /*
     * Precondition: sizeX > 1
     * Precondition: sizeY > 1
     * Precondition: sizeZ > 1
     */
    void setGridSize(int sizeX, int sizeY, int sizeZ);

    /*
     * Precondition: positionX > 0
     * Precondition: positionY > 0
     * Precondition: positionZ > 0
     */
    void addPath(int positionX, int positionY, int positionZ);

    /*
     * Precondition: positionX > 0
     * Precondition: positionY > 0
     * Precondition: positionZ > 0
     */
    void removePath(int positionX, int positionY, int positionZ);

    /*
     * Precondition: robotID != null
     * Precondition: robotType != null
     * Precondition: positionX > 0
     * Precondition: positionY > 0
     * Precondition: positionZ > 0
     */
    void addRobot(String robotID, RobotType robotType, int positionX,
            int positionY, int positionZ);

    void removeRobot(String robotID);

    /*
     * Precondition: itemID != null
     * Precondition: itemType != null
     * Precondition: positionX > 0
     * Precondition: positionY > 0
     * Precondition: positionZ > 0
     */
    void addItem(String itemID, ItemType itemType, int positionX,
            int positionY, int positionZ);

    void removeItem(String itemID);

    /*
     * Precondition: positionX > 0
     * Precondition: positionY > 0
     * Precondition: positionZ > 0
     */
    LocationState queryLocationState(int positionX, int positionY,
            int positionZ);

    void runSimForward();

    void runSimBackward();

    void stopSim();

    void resetSim();

    void stepSimForward();

    void stepSimBackward();

    void speedUpSim();

    void slowDownSim();

    void clearSim();

}
