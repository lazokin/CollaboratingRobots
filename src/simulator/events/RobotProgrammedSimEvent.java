// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

import simulator.robotcommands.RobotCommandType;

public class RobotProgrammedSimEvent extends SimEvent {

    private String robotID;
    private RobotCommandType[] robotCommands;

    public RobotProgrammedSimEvent(String robotID,
            RobotCommandType[] robotCommands) {
        super();
        this.robotID = robotID;
        this.robotCommands = robotCommands;
    }

    public String getRobotID() {
        return robotID;
    }

    public RobotCommandType[] getRobotCommands() {
        return robotCommands;
    }

}
