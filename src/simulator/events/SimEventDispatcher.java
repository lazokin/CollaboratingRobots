// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

import java.util.ArrayList;

import simulator.items.CarryableItem;
import simulator.items.Item;
import simulator.items.ItemContainer;
import simulator.path.Path;
import simulator.robot.Robot;
import simulator.robotcommands.RobotCommandType;
import simulator.states.SimState;

public class SimEventDispatcher {

    private static SimEventDispatcher instance = null;
    private ArrayList<SimEventListener> simEventListeners;

    private SimEventDispatcher() {
        super();
        this.simEventListeners = new ArrayList<SimEventListener>();
    }

    public static SimEventDispatcher getInstance() {
        if (instance == null) {
            instance = new SimEventDispatcher();
        }
        return instance;
    }

    public boolean registerSimEventListener(SimEventListener listener) {
        return simEventListeners.add(listener);
    }

    public boolean unregisterSimEventListener(SimEventListener listneer) {
        return simEventListeners.remove(listneer);
    }

    public void notifyPathAdded(Path path) {
        PathAddedSimEvent event = new PathAddedSimEvent(path.getPositionX(),
            path.getPositionY(), path.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyPathAdded(event);
        }
    }

    public void notifyPathRemoved(Path path) {
        PathRemovedSimEvent event = new PathRemovedSimEvent(
            path.getPositionX(), path.getPositionY(), path.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyPathRemoved(event);
        }
    }

    public void notifyRobotAdded(Robot robot) {
        RobotAddedSimEvent event = new RobotAddedSimEvent(robot.getID(), robot
            .getRobotType(), robot.getPositionX(), robot.getPositionY(), robot
            .getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotAdded(event);
        }
    }

    public void notifyRobotRemoved(Robot robot) {
        RobotRemovedSimEvent event = new RobotRemovedSimEvent(robot.getID(),
            robot.getRobotType(), robot.getPositionX(), robot.getPositionY(),
            robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotRemoved(event);
        }
    }

    public void notifyItemAdded(Item item) {
        ItemAddedSimEvent event = new ItemAddedSimEvent(item.getID(), item
            .getItemType(), item.getPositionX(), item.getPositionY(), item
            .getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyItemAdded(event);
        }
    }

    public void notifyItemRemoved(Item item) {
        ItemRemovedSimEvent event = new ItemRemovedSimEvent(item.getID(), item
            .getItemType(), item.getPositionX(), item.getPositionY(), item
            .getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyItemRemoved(event);
        }
    }

    public void notifyRobotMoved(Robot robot) {
        RobotMovedSimEvent event = new RobotMovedSimEvent(robot.getID(), robot
            .getPreviousPositionX(), robot.getPreviousPositionY(), robot
            .getPreviousPositionZ(), robot.getPositionX(),
            robot.getPositionY(), robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotMoved(event);
        }
    }

    public void notifyRobotWaited(Robot robot) {
        RobotWaitedSimEvent event = new RobotWaitedSimEvent(robot.getID());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotWaited(event);
        }
    }

    public void notifyGridSizeChanged(int sizeX, int sizeY, int sizeZ) {
        GridSizeChangedSimEvent event = new GridSizeChangedSimEvent(sizeX,
            sizeY, sizeZ);
        for (SimEventListener listener : simEventListeners) {
            listener.notifyGridSizeChanged(event);
        }
    }

    public void notifyRobotProgrammed(Robot robot,
        RobotCommandType[] robotCommandTypes) {
        RobotProgrammedSimEvent event = new RobotProgrammedSimEvent(robot
            .getID(), robotCommandTypes);
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotProgrammed(event);
        }
    }

    public void notifySimStateChanged(SimState simState) {
        SimStateChangedSimEvent event = new SimStateChangedSimEvent(simState
            .getSimState());
        for (SimEventListener listener : simEventListeners) {
            listener.notifySimStateChanged(event);
        }
    }

    public void notifyItemPickedFromPath(Robot robot,
        CarryableItem carryableItem) {
        ItemPickedFromPathSimEvent event = new ItemPickedFromPathSimEvent(robot
            .getID(), carryableItem.getID(), robot.getPositionX(), robot
            .getPositionY(), robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyItemPickedFromPath(event);
        }
    }

    public void notifyItemDroppedOnPath(Robot robot, CarryableItem carryableItem) {
        ItemDroppedOnPathSimEvent event = new ItemDroppedOnPathSimEvent(robot
            .getID(), carryableItem.getID(), robot.getPositionX(), robot
            .getPositionY(), robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyItemDroppedOnPath(event);
        }
    }

    public void notifyItemPickedFromContainer(Robot robot,
        CarryableItem carryableItem, ItemContainer itemContainer) {
        ItemPickedFromContainerSimEvent event = new ItemPickedFromContainerSimEvent(
            robot.getID(), carryableItem.getID(), itemContainer.getID(), robot
                .getPositionX(), robot.getPositionY(), robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyItemPickedFromContainer(event);
        }
    }

    public void notifyItemDroppedInContainer(Robot robot,
        CarryableItem carryableItem, ItemContainer itemContainer) {
        ItemDroppedInContainerSimEvent event = new ItemDroppedInContainerSimEvent(
            robot.getID(), carryableItem.getID(), itemContainer.getID(), robot
                .getPositionX(), robot.getPositionY(), robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyItemDroppedInContainer(event);
        }
    }

    public void notifyRobotTurned(Robot robot) {
        RobotTurnedSimEvent event = new RobotTurnedSimEvent(robot.getID(),
            robot.getHeadingState().getRobotHeading(), robot.getPositionX(),
            robot.getPositionY(), robot.getPositionZ());
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotTurned(event);
        }
    }

    public void notifyRobotOutOfBounds(Robot robot, int outOfBoundsX,
        int outOfBoundsY, int outOfBoundsZ) {
        RobotOutOfBoundsSimEvent event = new RobotOutOfBoundsSimEvent(robot
            .getID(), robot.getPositionX(), robot.getPositionY(), robot
            .getPositionZ(), outOfBoundsX, outOfBoundsY, outOfBoundsZ);
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotOutOfBounds(event);
        }
    }

    public void notifyRobotCollision(Robot robot1, Robot robot2,
        int collisionX, int collisionY, int collisionZ) {
        RobotCollisionSimEvent event = new RobotCollisionSimEvent(robot1
            .getID(), robot2.getID(), collisionX, collisionY, collisionZ);
        for (SimEventListener listener : simEventListeners) {
            listener.notifyRobotCollision(event);
        }
    }

    public void notifyApplesInBins(String winMessage) {
        ApplesInBinsSimEvent event = new ApplesInBinsSimEvent(winMessage);
        for (SimEventListener listener : simEventListeners) {
            listener.notifyApplesInBins(event);
        }
    }

    public void notifySimStepChanged(int simStepCounter) {
        SimStepChangedSimEvent event = new SimStepChangedSimEvent(
            simStepCounter);
        for (SimEventListener listener : simEventListeners) {
            listener.notifySimStepChanged(event);
        }
    }

    public void notifySimReset() {
        for (SimEventListener listener : simEventListeners) {
            listener.notifySimReset();
        }
    }

}
