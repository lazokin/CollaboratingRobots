// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class SimStepChangedSimEvent extends SimEvent {

    private int simStep;

    public SimStepChangedSimEvent(int simStep) {
        super();
        this.simStep = simStep;
    }

    public int getSimStep() {
        return simStep;
    }

}
