// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.states;

import simulator.SimulationManager;

public class SimStateRunning extends SimState {

    public SimStateRunning(SimulationManager simulationManager) {
        super(simulationManager);
        this.simState = SimStateType.RUNNING;
    }

    @Override
    public void runSimForward() {
     // No action taken in this state

    }

    @Override
    public void runSimBackward() {
        // No action taken in this state
    }

    @Override
    public void stopSim() {
        simulationManager.setSimStateToStopped();
        simulationManager.stop();
    }

    @Override
    public void resetSim() {
     // No action taken in this state
    }

    @Override
    public void stepSimForward() {
        // No action taken in this state
    }

    @Override
    public void stepSimBackward() {
        // No action taken in this state
    }

    @Override
    public void speedUpSim() {
        simulationManager.speedUp();
    }

    @Override
    public void slowDownSim() {
        simulationManager.slowDown();
    }

}
