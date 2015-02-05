// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot;

import java.util.TreeMap;

import simulator.SimCoordinator;
import simulator.events.SimEventDispatcher;
import simulator.exceptions.BotSimulatorException;
import simulator.robotcommands.RobotCommand;
import simulator.robotcommands.RobotCommandFactory;
import simulator.robotcommands.RobotCommandType;

public class RobotManager {

    private TreeMap<String, Robot> robots = new TreeMap<String, Robot>();
    private RobotFactory robotFactory = new RobotFactory();
    private RobotCommandFactory robotCommandFactory = new RobotCommandFactory();

    public RobotManager() {
        super();
    }

    /*
     * Postcondition: robots.size() > 0
     * Postcondition: robots.size() == (old(robots.size()) + 1)
     */
    public void addRobot(String robotID, RobotType robotType, int positionX,
            int positionY, int positionZ) {
        if (!robotExists(robotID)) {
            boolean validPosition = SimCoordinator.getInstance().pathExists(
                    positionX, positionY, positionZ);
            if (validPosition) {
                Robot robot = robotFactory.createRobot(robotID, robotType,
                        positionX, positionY, positionZ);
                robots.put(robotID, robot);
                SimCoordinator.getInstance()
                        .getPath(positionX, positionY, positionZ)
                        .setRobot(robot);
                SimEventDispatcher.getInstance().notifyRobotAdded(robot);
            }
        }
    }

    /*
     * Postcondition: robots.size() == (old(robots.size()) - 1)
     */
    public void removeRobot(String robotID) {
        if (robotExists(robotID)) {
            Robot robot = robots.remove(robotID);
            SimCoordinator
                    .getInstance()
                    .getPath(robot.getPositionX(), robot.getPositionY(),
                            robot.getPositionZ()).setRobot(null);
            SimEventDispatcher.getInstance().notifyRobotRemoved(robot);
        }
    }

    /*
     * Precondition: robotID != null
     * Precondition: !robotID.isEmpty()
     */
    public void programRobot(String robotID,
            RobotCommandType[] robotCommandTypes) {

        try {
            Robot robot = getRobot(robotID);
            this.clearRobotCommands(robotID);
            for (RobotCommandType robotCommandType : robotCommandTypes) {
                RobotCommand robotCommand = robotCommandFactory.createCommand(
                        robotCommandType, robot);
                robot.addRobotCommand(robotCommand);
            }
            SimEventDispatcher.getInstance().notifyRobotProgrammed(robot,
                    robotCommandTypes);
        } catch (IllegalArgumentException e) {
            // No robot found. Commands not added.
        }
    }

    public void clearRobotCommands(String robotID) {
        Robot robot = getRobot(robotID);
        robot.clearCommands();
    }

    public void resetRobots() {
        for (Robot robot : robots.values()) {
            robot.reset();
            SimCoordinator
                    .getInstance()
                    .getPath(robot.getPositionX(), robot.getPositionY(),
                            robot.getPositionZ()).setRobot(robot);
        }
    }

    /*
     * Precondition: simStepCounter >= 0
     */
    public void stepRobotsForward(int simStepCounter)
            throws BotSimulatorException {
        for (Robot robot : robots.values()) {
            robot.executeNextCommand(simStepCounter);
        }
    }

    /*
     * Precondition: simStepCounter >= 0
     */
    public void stepRobotsBackward(int simStepCounter)
            throws BotSimulatorException {
        for (Robot robot : robots.values()) {
            robot.reversePreviousCommand(simStepCounter);
        }
    }

    /*
     * Precondition: robotID != null
     * Precondition: !robotID.isEmpty()
     */
    public Robot getRobot(String robotID) {
        if (robots.containsKey(robotID)) {
            return robots.get(robotID);
        } else {
            throw new IllegalArgumentException("Invalid RobotID");
        }
    }

    /*
     * Precondition: robotID != null
     * Precondition: !robotID.isEmpty()
     */
    public boolean robotExists(String robotID) {
        return robots.containsKey(robotID) ? true : false;
    }

    public boolean atLastCommand() {
        boolean result = true;
        if (robots.isEmpty()) {
            return result;
        }
        for (Robot robot : robots.values()) {
            if (robot.hasNextCommand()) {
                return false;
            }
        }
        return result;
    }

    public boolean atFirstCommand() {
        boolean result = true;
        if (robots.isEmpty()) {
            return result;
        }
        for (Robot robot : robots.values()) {
            if (robot.hasPreviousCommand()) {
                return false;
            }
        }
        return result;
    }

    /*
     * Postcondition: robots.size() == 0
     */
    public void clear() {
        String copyOfRobotIDs[] = new String[robots.size()];
        robots.keySet().toArray(copyOfRobotIDs);
        for (String robotID : copyOfRobotIDs) {
            this.removeRobot(robotID);
        }
    }

}
