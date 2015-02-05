// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class RobotWaitedSimEvent extends SimEvent {

    private String robotID;

    public RobotWaitedSimEvent(String robotID) {
        super();
        this.robotID = robotID;
    }

    public String getRobotID() {
        return robotID;
    }

}
