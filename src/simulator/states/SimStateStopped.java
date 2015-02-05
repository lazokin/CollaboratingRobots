// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.states;

import simulator.SimulationManager;

public class SimStateStopped extends SimState {

    public SimStateStopped(SimulationManager simulationManager) {
        super(simulationManager);
        this.simState = SimStateType.STOPPED;
    }

    @Override
    public void runSimForward() {
        simulationManager.setSimStateToRunning();
        simulationManager.runForward();
    }

    @Override
    public void runSimBackward() {
        simulationManager.setSimStateToRunning();
        simulationManager.runBackward();
    }

    @Override
    public void stopSim() {
        // No action taken in this state
    }

    @Override
    public void resetSim() {
        simulationManager.reset();
    }

    @Override
    public void stepSimForward() {
        simulationManager.stepForward();
    }

    @Override
    public void stepSimBackward() {
        simulationManager.stepBackward();
    }

    @Override
    public void speedUpSim() {
        // No action taken in this state
    }

    @Override
    public void slowDownSim() {
        // No action taken in this state
    }

}
