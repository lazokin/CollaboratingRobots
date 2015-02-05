// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.path;

import simulator.SimObject;
import simulator.items.CarryableItem;
import simulator.items.Item;
import simulator.items.ItemContainer;
import simulator.robot.Robot;

public class Path extends SimObject {

    private Robot robot = null;
    private Item item = null;

    public Path(String pathID, int positionX, int positionY, int positionZ) {
        super(pathID, positionX, positionY, positionZ);
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean hasRobot() {
        return (robot != null) ? true : false;
    }

    public boolean hasItem() {
        return (item != null) ? true : false;
    }

    public boolean hasCarryableItem() {
        if (hasItem()) {
            return (item instanceof CarryableItem) ? true : false;
        } else {
            return false;
        }
    }

    public boolean hasItemContainer() {
        if (hasItem()) {
            return (item instanceof ItemContainer) ? true : false;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        boolean result = true;
        if (hasRobot() || hasItem()) {
            result = false;
        }
        return result;
    }

    public void reset() {
        super.reset();
        robot = null;
        item = null;
    }

}
