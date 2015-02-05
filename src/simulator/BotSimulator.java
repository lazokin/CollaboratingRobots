// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator;

import simulator.events.SimEventDispatcher;
import simulator.events.SimEventListener;
import simulator.interfaces.SimAutomator;
import simulator.interfaces.SimController;
import simulator.interfaces.SimProgrammer;
import simulator.items.ItemType;
import simulator.robot.RobotType;
import simulator.robotcommands.RobotCommandType;

public class BotSimulator implements SimController, SimProgrammer, SimAutomator {

    private static BotSimulator instance = null;

    private SimCoordinator simCoordinator;
    private SimEventDispatcher simEventDispatcher;

    private BotSimulator() {
        super();
        this.simCoordinator = SimCoordinator.getInstance();
        this.simEventDispatcher = SimEventDispatcher.getInstance();
    }

    public static BotSimulator getInstance() {
        if (instance == null) {
            instance = new BotSimulator();
        }
        return instance;
    }

    // BotSimulator Methods

    public boolean registerSimEventListener(SimEventListener listener) {
        return simEventDispatcher.registerSimEventListener(listener);
    }

    public boolean unregisterSimEventListener(SimEventListener listneer) {
        return simEventDispatcher.unregisterSimEventListener(listneer);
    }

    // SimController interface methods

    @Override
    public void setGridSize(int sizeX, int sizeY, int sizeZ) {
        simCoordinator.setGridSize(sizeX, sizeY, sizeZ);
        this.clearSim();
    }

    @Override
    public void addPath(int positionX, int positionY, int positionZ) {
        simCoordinator.addPath(positionX, positionY, positionZ);
    }

    @Override
    public void removePath(int positionX, int positionY, int positionZ) {
        simCoordinator.removePath(positionX, positionY, positionZ);
    }

    @Override
    public void addRobot(String robotID, RobotType robotType, int positionX,
            int positionY, int positionZ) {
        simCoordinator.addRobot(robotID, robotType, positionX, positionY,
                positionZ);
    }

    @Override
    public void removeRobot(String robotID) {
        simCoordinator.removeRobot(robotID);
    }

    @Override
    public void addItem(String itemID, ItemType itemType, int positionX,
            int positionY, int positionZ) {
        simCoordinator.addItem(itemID, itemType, positionX, positionY,
                positionZ);
    }

    @Override
    public void removeItem(String itemID) {
        simCoordinator.removeItem(itemID);
    }

    @Override
    public LocationState queryLocationState(int positionX, int positionY,
            int positionZ) {
        return simCoordinator.queryLocationState(positionX, positionY,
                positionZ);
    }

    @Override
    public void runSimForward() {
        simCoordinator.runSimForward();
    }

    @Override
    public void runSimBackward() {
        simCoordinator.runSimBackward();
    }

    @Override
    public void stopSim() {
        simCoordinator.stopSim();
    }

    @Override
    public void resetSim() {
        simCoordinator.resetSim();
    }

    @Override
    public void stepSimForward() {
        simCoordinator.stepSimForward();
    }

    @Override
    public void stepSimBackward() {
        simCoordinator.stepSimBackward();
    }

    @Override
    public void speedUpSim() {
        simCoordinator.speedUpSim();
    }

    @Override
    public void slowDownSim() {
        simCoordinator.slowDownSim();
    }

    @Override
    public void clearSim() {
        simCoordinator.clearSim();
    }

    // SimProgrammer interface methods

    @Override
    public void programRobot(String robotID,
            RobotCommandType[] robotCommandTypes) {
        simCoordinator.programRobot(robotID, robotCommandTypes);
    }

}
