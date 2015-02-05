// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot;

import simulator.exceptions.BotSimulatorException;

public class FastAndroidRobot extends Robot {

    public FastAndroidRobot(String robotID, int positionX, int positionY,
            int positionZ) {
        super(robotID, positionX, positionY, positionZ);
        super.setRobotType(RobotType.FAST_ANDROID);
    }

    @Override
    public boolean executeNextCommand(int simStepCounter)
            throws BotSimulatorException {
        boolean move1, move2;
        move1 = super.executeNextCommand(simStepCounter);
        move2 = super.executeNextCommand(simStepCounter);
        return (move1 || move2);
    }

    @Override
    public boolean reversePreviousCommand(int simStepCounter)
            throws BotSimulatorException {
        boolean move1, move2;
        move1 = super.reversePreviousCommand(simStepCounter);
        move2 = super.reversePreviousCommand(simStepCounter);
        return (move1 || move2);
    }

}
