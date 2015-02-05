// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

import simulator.states.SimStateType;

public class SimStateChangedSimEvent extends SimEvent {

    private SimStateType simState;

    public SimStateChangedSimEvent(SimStateType simState) {
        super();
        this.simState = simState;
    }

    public SimStateType getSimState() {
        return simState;
    }

}
