// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.interfaces;

import simulator.robotcommands.RobotCommandType;

public interface SimProgrammer {

    /*
     * Precondition: robotId != null
     * Precondition: robotCommandTypes.length > 0
     */
    public abstract void programRobot(String robotID,
            RobotCommandType[] robotCommandTypes);

}
