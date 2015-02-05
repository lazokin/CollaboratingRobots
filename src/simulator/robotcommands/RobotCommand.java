// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.exceptions.BotSimulatorException;
import simulator.robot.Robot;

public abstract class RobotCommand {

    protected Robot robot;

    public RobotCommand(Robot robot) {
        super();
        this.robot = robot;
    }

    public abstract void execute() throws BotSimulatorException;

    public abstract void reverse() throws BotSimulatorException;

}
