// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator;

import simulator.exceptions.BotSimulatorException;
import simulator.interfaces.SimAutomator;
import simulator.interfaces.SimController;
import simulator.interfaces.SimProgrammer;
import simulator.items.Apple;
import simulator.items.Bin;
import simulator.items.ItemManager;
import simulator.items.ItemType;
import simulator.path.Path;
import simulator.path.PathManager;
import simulator.robot.RobotManager;
import simulator.robot.RobotType;
import simulator.robotcommands.RobotCommandType;

public class SimCoordinator implements SimController, SimProgrammer,
    SimAutomator {

    private static SimCoordinator instance = null;

    private SimulationManager simulationManager = new SimulationManager();
    private RobotManager robotManager = new RobotManager();
    private PathManager pathManager = new PathManager();
    private ItemManager itemManager = new ItemManager();

    private SimCoordinator() {
        super();
    }

    public static SimCoordinator getInstance() {
        if (instance == null) {
            instance = new SimCoordinator();
        }
        return instance;
    }

    // SimController interface methods

    @Override
    public void setGridSize(int sizeX, int sizeY, int sizeZ) {
        simulationManager.setGridSize(sizeX, sizeY, sizeZ);
    }

    @Override
    public void addPath(int positionX, int positionY, int positionZ) {
        pathManager.addPath(positionX, positionY, positionZ);
    }

    @Override
    public void removePath(int positionX, int positionY, int positionZ) {
        pathManager.removePath(positionX, positionY, positionZ);
    }

    @Override
    public void addRobot(String robotID, RobotType robotType, int positionX,
        int positionY, int positionZ) {
        robotManager.addRobot(robotID, robotType, positionX, positionY,
            positionZ);
    }

    @Override
    public void removeRobot(String robotID) {
        robotManager.removeRobot(robotID);
    }

    @Override
    public void addItem(String itemID, ItemType itemType, int positionX,
        int positionY, int positionZ) {
        itemManager.addItem(itemID, itemType, positionX, positionY, positionZ);
    }

    @Override
    public void removeItem(String itemID) {
        itemManager.removeItem(itemID);
    }

    @Override
    public LocationState queryLocationState(int positionX, int positionY,
        int positionZ) {
        return pathManager.queryLocationContents(positionX, positionY,
            positionZ);
    }

    @Override
    public void runSimForward() {
        simulationManager.runSimForward();
    }

    @Override
    public void runSimBackward() {
        simulationManager.runSimBackward();
    }

    @Override
    public void stopSim() {
        simulationManager.stopSim();
    }

    @Override
    public void resetSim() {
        simulationManager.resetSim();
    }

    @Override
    public void stepSimForward() {
        simulationManager.stepSimForward();
    }

    @Override
    public void stepSimBackward() {
        simulationManager.stepSimBackward();
    }

    @Override
    public void speedUpSim() {
        simulationManager.speedUpSim();
    }

    @Override
    public void slowDownSim() {
        simulationManager.slowDownSim();
    }

    @Override
    public void clearSim() {
        robotManager.clear();
        itemManager.clear();
        pathManager.clear();
    }

    // SimProgrammer interface methods

    @Override
    public void programRobot(String robotID,
        RobotCommandType[] robotCommandTypes) {
        robotManager.programRobot(robotID, robotCommandTypes);
        simulationManager.resetSim();
    }

    // SimCoordinator methods

    public boolean atLastCommand() {
        return robotManager.atLastCommand();
    }

    public boolean atFirstCommand() {
        return robotManager.atFirstCommand();
    }

    public void resetRobots() {
        robotManager.resetRobots();
    }
    
    public void resetPaths() {
        pathManager.resetPaths();
    }
    
    public void resetItems() {
        itemManager.resetItems();
    }

    public void stepRobotsForward(int simStepCounter)
        throws BotSimulatorException {
        robotManager.stepRobotsForward(simStepCounter);
    }

    public void stepRobotsBackward(int simStepCounter)
        throws BotSimulatorException {
        robotManager.stepRobotsBackward(simStepCounter);
    }

    public boolean locationWithinGrid(int positionX, int positionY,
        int positionZ) {
        return simulationManager.locationWithinGrid(positionX, positionY,
            positionZ);
    }

    public Path getPath(int positionX, int positionY, int positionZ) {
        return pathManager.getPath(positionX, positionY, positionZ);
    }

    public boolean pathExists(int positionX, int positionY, int positionZ) {
        return pathManager.pathExists(positionX, positionY, positionZ);
    }

    public Apple[] getAllApples() {
        return itemManager.getAllApples();
    }

    public Bin[] getAllBins() {
        return itemManager.getAllBins();
    }

}
