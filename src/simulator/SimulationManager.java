// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator;

import simulator.events.SimEventDispatcher;
import simulator.exceptions.BotSimulatorException;
import simulator.items.Apple;
import simulator.items.Bin;
import simulator.states.SimState;
import simulator.states.SimStateLosing;
import simulator.states.SimStateRunning;
import simulator.states.SimStateStopped;
import simulator.states.SimStateWinning;

public class SimulationManager {

    private int gridSizeX, gridSizeY, gridSizeZ;

    private int simStepCounter = 0;
    private volatile boolean running = false;
    private boolean atLastCommand = false;
    private boolean atFirstCommand = true;
    private int delay = 250;

    private SimStateRunning simStateRunning = new SimStateRunning(this);
    private SimStateStopped simStateStopped = new SimStateStopped(this);
    private SimStateWinning simStateWinning = new SimStateWinning(this);
    private SimStateLosing simStateLosing = new SimStateLosing(this);;
    private SimState simState;

    public SimulationManager() {
        super();
        this.setSimStateToStopped();
    }

    // Grid management methods

    public void setGridSize(int sizeX, int sizeY, int sizeZ) {
        setGridSizeX(sizeX);
        setGridSizeY(sizeY);
        setGridSizeZ(sizeZ);
        SimEventDispatcher.getInstance().notifyGridSizeChanged(sizeX, sizeY,
            sizeZ);
    }

    public int getGridSizeX() {
        return gridSizeX;
    }

    private void setGridSizeX(int gridSizeX) {
        if (gridSizeX <= 0) {
            throw new IllegalArgumentException(
                "Grid size must be greater than 0.");
        }
        this.gridSizeX = gridSizeX;
    }

    public int getGridSizeY() {
        return gridSizeY;
    }

    private void setGridSizeY(int gridSizeY) {
        if (gridSizeY <= 0) {
            throw new IllegalArgumentException(
                "Grid size must be greater than 0.");
        }
        this.gridSizeY = gridSizeY;
    }

    public int getGridSizeZ() {
        return gridSizeZ;
    }

    private void setGridSizeZ(int gridSizeZ) {
        if (gridSizeZ <= 0) {
            throw new IllegalArgumentException(
                "Grid size must be greater than 0.");
        }
        this.gridSizeZ = gridSizeZ;
    }

    public int getSimStepCounter() {
        return simStepCounter;
    }

    public boolean locationWithinGrid(int positionX, int positionY,
        int positionZ) {
        boolean validPositionX = (positionX >= 0 && positionX < gridSizeX);
        boolean validPositionY = (positionY >= 0 && positionY < gridSizeY);
        boolean validPositionZ = (positionZ >= 0 && positionZ < gridSizeZ);
        return (validPositionX && validPositionY && validPositionZ);
    }

    // State management methods

    public void setSimStateToRunning() {
        this.simState = simStateRunning;
        SimEventDispatcher.getInstance().notifySimStateChanged(simState);
    }

    public void setSimStateToStopped() {
        this.simState = simStateStopped;
        SimEventDispatcher.getInstance().notifySimStateChanged(simState);
    }

    public void setSimStateToWinning() {
        this.simState = simStateWinning;
        SimEventDispatcher.getInstance().notifySimStateChanged(simState);
    }

    public void setSimStateToLosing() {
        this.simState = simStateLosing;
        SimEventDispatcher.getInstance().notifySimStateChanged(simState);
    }

    // State control methods

    public void runSimForward() {
        simState.runSimForward();
    }

    public void runSimBackward() {
        simState.runSimBackward();
    }

    public void stopSim() {
        simState.stopSim();
    }

    public void resetSim() {
        simState.resetSim();
    }

    public void stepSimForward() {
        simState.stepSimForward();
    }

    public void stepSimBackward() {
        simState.stepSimBackward();
    }

    public void speedUpSim() {
        simState.speedUpSim();
    }

    public void slowDownSim() {
        simState.slowDownSim();
    }

    // Simulation control methods

    public void runForward() {
        running = true;
        atLastCommand = SimCoordinator.getInstance().atLastCommand();
        while (running && !atLastCommand) {
            stepForward();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (running && atLastCommand) {
            setSimStateToStopped();
        }
    }

    public void runBackward() {
        running = true;
        atFirstCommand = SimCoordinator.getInstance().atFirstCommand();
        while (running && !atFirstCommand) {
            stepBackward();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (running && atFirstCommand) {
            setSimStateToStopped();
        }
    }

    public void stop() {
        running = false;
    }

    public void reset() {
        stop();
        simStepCounter = 0;
        delay = 250;
        SimEventDispatcher.getInstance().notifySimStepChanged(simStepCounter);
        SimCoordinator.getInstance().resetPaths();
        SimCoordinator.getInstance().resetRobots();
        SimCoordinator.getInstance().resetItems();
        SimEventDispatcher.getInstance().notifySimReset();
    }

    public void stepForward() {
        try {
            SimCoordinator.getInstance().stepRobotsForward(simStepCounter++);
            SimEventDispatcher.getInstance().notifySimStepChanged(
                simStepCounter);
            atLastCommand = SimCoordinator.getInstance().atLastCommand();
            if (atLastCommand) {
                checkForWin();
            }
        } catch (BotSimulatorException e) {
            stop();
            setSimStateToLosing();
        }
    }

    public void stepBackward() {
        try {
            SimCoordinator.getInstance().stepRobotsBackward(simStepCounter--);
            SimEventDispatcher.getInstance().notifySimStepChanged(
                simStepCounter);
            atFirstCommand = SimCoordinator.getInstance().atFirstCommand();
        } catch (BotSimulatorException e) {
            stop();
            setSimStateToLosing();
        }
    }

    public void speedUp() {
        delay /= 2;
    }

    public void slowDown() {
        delay *= 2;

    }

    private void checkForWin() {

        boolean win = true;

        Apple[] apples = SimCoordinator.getInstance().getAllApples();
        Bin[] bins = SimCoordinator.getInstance().getAllBins();

        int numberOfApples = apples.length;
        int numberOfBins = bins.length;

        String winMessage = null;

        if (numberOfApples == 0 && numberOfBins == 0) {
            win = false;
        } else {
            if (numberOfApples < numberOfBins) {
                for (Apple apple : apples) {
                    if (!apple.hasContainer()) {
                        win = false;
                    } else {
                        winMessage = "Every apple in a bin";
                    }
                }
            }
            if (numberOfBins < numberOfApples) {
                for (Bin bin : bins) {
                    if (!bin.hasCarryableItem()) {
                        win = false;
                    } else {
                        winMessage = "Every bin has an apple";
                    }
                }
            }
            if (numberOfApples == numberOfBins) {
                for (Apple apple : apples) {
                    if (!apple.hasContainer()) {
                        win = false;
                    } else {
                        winMessage = "Every apple in a bin";
                    }
                }
            }
        }

        if (win) {
            SimEventDispatcher.getInstance().notifyApplesInBins(winMessage);
            stop();
            setSimStateToWinning();
        }
    }

}
