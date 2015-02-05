// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robot;

import java.util.ArrayList;
import java.util.ListIterator;

import simulator.SimCoordinator;
import simulator.SimObject;
import simulator.exceptions.BotSimulatorException;
import simulator.exceptions.SimObjectCollisionException;
import simulator.exceptions.SimObjectOutOfBoundsException;
import simulator.items.CarryableItem;
import simulator.robot.heading.EastHeading;
import simulator.robot.heading.NorthHeading;
import simulator.robot.heading.RobotHeading;
import simulator.robot.heading.SouthHeading;
import simulator.robot.heading.WestHeading;
import simulator.robotcommands.RobotCommand;

public abstract class Robot extends SimObject {
    
    /*
     * Invariant: commandStepCounter > 0
     */

    private int commandStepCounter = 0;
    private RobotType robotType;

    private NorthHeading northHeading = new NorthHeading(this);
    private SouthHeading southHeading = new SouthHeading(this);
    private EastHeading eastHeading = new EastHeading(this);
    private WestHeading westHeading = new WestHeading(this);
    private RobotHeading headingState = northHeading;

    private ArrayList<RobotCommand> commands = new ArrayList<RobotCommand>();
    private ListIterator<RobotCommand> iterator = commands.listIterator(0);
    private CarryableItem carryableItem = null;

    public Robot(String robotID, int positionX, int positionY, int positionZ) {
        super(robotID, positionX, positionY, positionZ);
    }

    public RobotType getRobotType() {
        return robotType;
    }

    public CarryableItem getCarryableItem() {
        return carryableItem;
    }

    public RobotHeading getHeadingState() {
        return headingState;
    }

    public void setRobotType(RobotType robotType) {
        this.robotType = robotType;
    }

    public void setCurrentHeadingToNorth() {
        this.headingState = this.northHeading;
    }

    public void setCurrentHeadingToSouth() {
        this.headingState = this.southHeading;
    }

    public void setCurrentHeadingToEast() {
        this.headingState = this.eastHeading;
    }

    public void setCurrentHeadingToWest() {
        this.headingState = this.westHeading;
    }

    /*
     * Postcondition: carryableItem != null
     */
    public boolean pickUpCarryableItem(CarryableItem carryableItem) {
        boolean result = false;
        if (this.carryableItem == null) {
            this.carryableItem = carryableItem;
            this.carryableItem.setCarrier(this);
            result = true;
        }
        return result;
    }

    /*
     * Postcondition: carryableItem == null
     */
    public boolean dropCarryableItem() {
        boolean result = false;
        if (this.carryableItem != null) {
            this.carryableItem.setContainer(null);
            this.carryableItem = null;
            result = true;
        }
        return result;
    }

    public boolean hasCarryableItem() {
        return (carryableItem != null) ? true : false;
    }

    @Override
    public void moveBy(int distanceX, int distanceY, int distanceZ)
        throws SimObjectOutOfBoundsException, SimObjectCollisionException {
        
        super.moveBy(distanceX, distanceY, distanceZ);
        
        if (carryableItem != null) {
            carryableItem.moveBy(distanceX, distanceY, distanceZ);
        }

        removeRobotFromOldPath();
        addRobotToNewPath();

    }

    @Override
    public void moveTo(int positionX, int positionY, int positionZ)
        throws SimObjectOutOfBoundsException, SimObjectCollisionException {
        
        super.moveTo(positionX, positionY, positionZ);
        
        if (carryableItem != null) {
            carryableItem.moveTo(positionX, positionY, positionZ);
        }

        removeRobotFromOldPath();
        addRobotToNewPath();

    }

    /*
     * Postcondition: commands.size() > 0
     */
    public boolean addRobotCommand(RobotCommand robotCommand) {
        boolean result = false;
        if (commands.add(robotCommand)) {
            iterator = commands.listIterator(0);
            result = true;
        }
        return result;
    }

    public boolean hasNextCommand() {
        return iterator.hasNext();
    }

    public boolean hasPreviousCommand() {
        return iterator.hasPrevious();
    }

    /*
     * Postcondition: cammands.size() == 0
     */
    public void clearCommands() {
        commands.clear();
        iterator = commands.listIterator(0);
    }

    /*
     * Postcondition: commandStepCounter == 0
     * Postcondition: carryableItem == null
     */
    public void reset() {
        super.reset();
        iterator = commands.listIterator(0);
        commandStepCounter = 0;
        carryableItem = null;
        headingState = northHeading;
    }

    /*
     * Precondition: simStepCounter >= 0
     */
    public boolean executeNextCommand(int simStepCounter)
        throws BotSimulatorException {
        boolean result = false;
        if (commandStepCounter == simStepCounter) {
            executeNextCommand();
            commandStepCounter++;
        }
        return result;
    }

    /*
     * Precondition: simStepCounter >= 0
     */
    public boolean reversePreviousCommand(int simStepCounter)
        throws BotSimulatorException {
        boolean result = false;
        if (commandStepCounter == simStepCounter) {
            executePreviousCommand();
            commandStepCounter--;
        }
        return result;
    }

    public boolean executeNextCommand() throws BotSimulatorException {
        boolean result = false;
        if (iterator.hasNext()) {
            RobotCommand nextCommand = iterator.next();
            nextCommand.execute();
            result = true;
        }
        return result;
    }

    public boolean executePreviousCommand() throws BotSimulatorException {
        boolean result = false;
        if (iterator.hasPrevious()) {
            RobotCommand previousCommand = iterator.previous();
            previousCommand.reverse();
            result = true;
        }
        return result;
    }
    
    private void addRobotToNewPath() {
        boolean currentPositionHasPath = SimCoordinator.getInstance()
            .pathExists(super.getPositionX(), super.getPositionY(),
                super.getPositionZ());
        if (currentPositionHasPath) {
            SimCoordinator.getInstance().getPath(super.getPositionX(),
                super.getPositionY(), super.getPositionZ()).setRobot(this);
        }
    }

    private void removeRobotFromOldPath() {
        boolean previousPositionHasPath = SimCoordinator.getInstance()
            .pathExists(super.getPreviousPositionX(),
                super.getPreviousPositionY(), super.getPreviousPositionZ());
        if (previousPositionHasPath) {
            SimCoordinator.getInstance().getPath(super.getPreviousPositionX(),
                super.getPreviousPositionY(), super.getPreviousPositionZ())
                .setRobot(null);
        }
    }

}
