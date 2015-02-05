package application.test;

import simulator.BotSimulator;
import simulator.events.ApplesInBinsSimEvent;
import simulator.events.GridSizeChangedSimEvent;
import simulator.events.ItemAddedSimEvent;
import simulator.events.ItemDroppedInContainerSimEvent;
import simulator.events.ItemDroppedOnPathSimEvent;
import simulator.events.ItemPickedFromContainerSimEvent;
import simulator.events.ItemPickedFromPathSimEvent;
import simulator.events.ItemRemovedSimEvent;
import simulator.events.PathAddedSimEvent;
import simulator.events.PathRemovedSimEvent;
import simulator.events.RobotAddedSimEvent;
import simulator.events.RobotCollisionSimEvent;
import simulator.events.RobotMovedSimEvent;
import simulator.events.RobotOutOfBoundsSimEvent;
import simulator.events.RobotProgrammedSimEvent;
import simulator.events.RobotRemovedSimEvent;
import simulator.events.RobotTurnedSimEvent;
import simulator.events.RobotWaitedSimEvent;
import simulator.events.SimEventListener;
import simulator.events.SimStateChangedSimEvent;
import simulator.events.SimStepChangedSimEvent;
import simulator.items.ItemType;
import simulator.robot.RobotType;
import simulator.robotcommands.RobotCommandType;

public class SimulatorTest implements SimEventListener {

    public SimulatorTest(BotSimulator sim) {
        sim.registerSimEventListener(this);
    }

    public static void main(String[] args) {

        BotSimulator sim = BotSimulator.getInstance();
        SimulatorTest simTest = new SimulatorTest(sim);

        sim.setGridSize(10, 10, 10);

        sim.addPath(0, 0, 0);
        sim.addPath(1, 0, 0);
        sim.addPath(2, 0, 0);
        sim.addPath(3, 0, 0);
        sim.addPath(4, 0, 0);
        sim.addPath(5, 0, 0);
        sim.addPath(6, 0, 0);
        sim.addPath(7, 0, 0);
        sim.addPath(8, 0, 0);
        sim.addPath(9, 0, 0);

        sim.addRobot("R1", RobotType.BASIC_ANDROID, 0, 0, 0);
        sim.addItem("A1", ItemType.APPLE, 1, 0, 0);
        sim.addItem("B1", ItemType.BIN, 2, 0, 0);

        RobotCommandType[] robotCommands1 = new RobotCommandType[] {
            RobotCommandType.MOVE_EAST, RobotCommandType.PICK,
            RobotCommandType.MOVE_EAST, RobotCommandType.DROP,
            RobotCommandType.MOVE_EAST };

        sim.programRobot("R1", robotCommands1);

        sim.runSimForward();

    }

    @Override
    public void notifyGridSizeChanged(GridSizeChangedSimEvent event) {
        System.out.println("-> Grid size set to (" + event.getSizeX() + ", "
            + event.getSizeY() + ", " + event.getSizeZ() + ")");

    }

    @Override
    public void notifyPathAdded(PathAddedSimEvent event) {
        System.out.println("-> Path added at (" + event.getPositionX() + ", "
            + event.getPositionY() + ", " + event.getPositionZ() + ")");
    }

    @Override
    public void notifyPathRemoved(PathRemovedSimEvent event) {
        System.out.println("-> Path removed at (" + event.getPositionX() + ", "
            + event.getPositionY() + ", " + event.getPositionZ() + ")");
    }

    @Override
    public void notifyRobotAdded(RobotAddedSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID() + " of type "
            + event.getRobotType() + " added at (" + event.getPositionX()
            + ", " + event.getPositionY() + ", " + event.getPositionZ() + ")");

    }

    @Override
    public void notifyRobotRemoved(RobotRemovedSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID() + " of type "
            + event.getRobotType() + " removed from (" + event.getPositionX()
            + ", " + event.getPositionY() + ", " + event.getPositionZ() + ")");

    }

    @Override
    public void notifyItemAdded(ItemAddedSimEvent event) {
        System.out.println("-> Item " + event.getItemID() + " of type "
            + event.getItemType() + " added at (" + event.getPositionX() + ", "
            + event.getPositionY() + ", " + event.getPositionZ() + ")");
    }

    @Override
    public void notifyItemRemoved(ItemRemovedSimEvent event) {
        System.out.println("-> Item " + event.getItemID() + " of type "
            + event.getItemType() + " removed from (" + event.getPositionX()
            + ", " + event.getPositionY() + ", " + event.getPositionZ() + ")");
    }

    @Override
    public void notifyRobotMoved(RobotMovedSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID() + " moved from ("
            + event.getFromPositionX() + ", " + event.getFromPositionY() + ", "
            + event.getFromPositionZ() + ") to (" + +event.getToPositionX()
            + ", " + event.getToPositionY() + ", " + event.getToPositionZ()
            + ")");

    }

    @Override
    public void notifyRobotWaited(RobotWaitedSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID() + " waited");
    }

    @Override
    public void notifyRobotProgrammed(RobotProgrammedSimEvent event) {
        System.out
            .println("-> Robot " + event.getRobotID() + " programmed to ");
        for (RobotCommandType cmd : event.getRobotCommands()) {
            System.out.println("  -> " + cmd);
        }

    }

    @Override
    public void notifySimStateChanged(SimStateChangedSimEvent event) {
        System.out.println("-> Sim State changed to " + event.getSimState());

    }

    @Override
    public void notifyItemPickedFromPath(ItemPickedFromPathSimEvent event) {
        System.out.println("-> Item " + event.getCarryableID()
            + " picked from path by " + event.getRobotID() + " at position ("
            + event.getPositionX() + ", " + event.getPositionY() + ", "
            + event.getPositionZ() + ")");
    }

    @Override
    public void notifyItemDroppedOnPath(ItemDroppedOnPathSimEvent event) {
        System.out.println("-> Item " + event.getCarryableID()
            + " dropped on path by " + event.getRobotID() + " at position ("
            + event.getPositionX() + ", " + event.getPositionY() + ", "
            + event.getPositionZ() + ")");
    }

    @Override
    public void notifyItemPickedFromContainer(
        ItemPickedFromContainerSimEvent event) {
        System.out.println("-> Item " + event.getCarryableID()
            + " picked from container " + event.getContainerID() + " by "
            + event.getRobotID() + " at position (" + event.getPositionX()
            + ", " + event.getPositionY() + ", " + event.getPositionZ() + ")");
    }

    @Override
    public void notifyItemDroppedInContainer(
        ItemDroppedInContainerSimEvent event) {
        System.out.println("-> Item " + event.getCarryableID()
            + " dropped into container " + event.getContainerID() + " by "
            + event.getRobotID() + " at position (" + event.getPositionX()
            + ", " + event.getPositionY() + ", " + event.getPositionZ() + ")");
    }

    @Override
    public void notifyRobotTurned(RobotTurnedSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID() + " turned to the "
            + event.getRobotHeadingType());
    }

    @Override
    public void notifyRobotOutOfBounds(RobotOutOfBoundsSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID()
            + " moved out of bounds from (" + event.getFromPositionX() + ", "
            + event.getFromPositionY() + ", " + event.getFromPositionZ()
            + ") to (" + +event.getToPositionX() + ", "
            + event.getToPositionY() + ", " + event.getToPositionZ() + ")");
    }

    @Override
    public void notifyRobotCollision(RobotCollisionSimEvent event) {
        System.out.println("-> Robot " + event.getRobotID_1()
            + " collided with Robot " + event.getRobotID_2() + " at ("
            + event.getCollisionX() + ", " + event.getCollisionY() + ", "
            + event.getCollisionZ() + ")");
    }

    @Override
    public void notifyApplesInBins(ApplesInBinsSimEvent event) {
        System.out.println("-> " + event.getWinningMessage());
    }

    @Override
    public void notifySimStepChanged(SimStepChangedSimEvent event) {
        // System.out.println("-> " + event.getSimStep());
    }

    @Override
    public void notifySimReset() {
        System.out.println("-> Sim reset");
    }

}
