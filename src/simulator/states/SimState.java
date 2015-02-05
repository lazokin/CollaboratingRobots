// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.states;

import simulator.SimulationManager;

public abstract class SimState {

    protected SimStateType simState;
    protected SimulationManager simulationManager;

    public SimState(SimulationManager simulationManager) {
        super();
        this.simulationManager = simulationManager;
    }

    public SimStateType getSimState() {
        return simState;
    }

    public abstract void runSimForward();

    public abstract void runSimBackward();

    public abstract void stopSim();

    public abstract void resetSim();

    public abstract void stepSimForward();

    public abstract void stepSimBackward();

    public abstract void speedUpSim();

    public abstract void slowDownSim();

}
