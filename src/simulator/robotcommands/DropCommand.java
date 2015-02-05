// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.robotcommands;

import simulator.SimCoordinator;
import simulator.events.SimEventDispatcher;
import simulator.items.CarryableItem;
import simulator.items.ItemContainer;
import simulator.path.Path;
import simulator.robot.Robot;

public class DropCommand extends RobotCommand {

    public DropCommand(Robot robot) {
        super(robot);
    }

    @Override
    public void execute() {
        Path path = SimCoordinator.getInstance().getPath(robot.getPositionX(),
                robot.getPositionY(), robot.getPositionZ());
        CarryableItem carryableItem = robot.getCarryableItem();
        if (carryableItem != null) {
            if (!path.hasItem()) {
                path.setItem(carryableItem);
                robot.dropCarryableItem();
                SimEventDispatcher.getInstance().notifyItemDroppedOnPath(robot,
                        carryableItem);
            }
            if (path.hasItemContainer()) {
                ItemContainer itemContainer = (ItemContainer) path.getItem();
                if (!itemContainer.hasCarryableItem()) {
                    robot.dropCarryableItem();
                    itemContainer.addCarryableItem(carryableItem);
                    SimEventDispatcher.getInstance()
                            .notifyItemDroppedInContainer(robot, carryableItem,
                                    itemContainer);
                }
            }

        }
    }

    @Override
    public void reverse() {
        Path path = SimCoordinator.getInstance().getPath(robot.getPositionX(),
                robot.getPositionY(), robot.getPositionZ());
        if (!robot.hasCarryableItem()) {
            if (path.hasCarryableItem()) {
                CarryableItem carryableItem = (CarryableItem) path.getItem();
                robot.pickUpCarryableItem(carryableItem);
                path.setItem(null);
                SimEventDispatcher.getInstance().notifyItemPickedFromPath(
                        robot, carryableItem);
            }
            if (path.hasItemContainer()) {
                ItemContainer itemContainer = (ItemContainer) path.getItem();
                if (itemContainer.hasCarryableItem()) {
                    CarryableItem carryableItem = itemContainer
                            .getCarryableItem();
                    robot.pickUpCarryableItem(carryableItem);
                    itemContainer.removeCarryableItem();
                    SimEventDispatcher.getInstance()
                            .notifyItemPickedFromContainer(robot,
                                    carryableItem, itemContainer);

                }
            }

        }
    }
}
