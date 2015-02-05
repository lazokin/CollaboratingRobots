// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator;

import simulator.items.Item;
import simulator.items.ItemContainer;
import simulator.items.ItemType;
import simulator.path.Path;
import simulator.robot.Robot;
import simulator.robot.RobotType;
import simulator.robot.heading.RobotHeadingType;

public class LocationState {

    boolean locationHasPath;
    private RobotType typeOfRobotAtLocation;
    private ItemType typeOfItemAtLocation;
    private ItemType typeOfItemInRobot;
    private ItemType typeOfItemInContainer;

    private String robotAtLocationID;
    private String itemAtLocationID;
    private String itemInRobotID;

    RobotHeadingType headingOfRobotAtLocation;

    public LocationState(Path path) {
        this.locationHasPath = false;
        this.typeOfRobotAtLocation = RobotType.NULL;
        this.typeOfItemAtLocation = ItemType.NULL;
        this.typeOfItemInRobot = ItemType.NULL;
        this.typeOfItemInContainer = ItemType.NULL;
        this.robotAtLocationID = null;
        this.itemAtLocationID = null;
        this.itemInRobotID = null;
        if (path != null) {
            this.locationHasPath = true;
            Robot robot = path.getRobot();
            if (robot != null) {
                this.typeOfRobotAtLocation = robot.getRobotType();
                this.robotAtLocationID = robot.getID();
                this.headingOfRobotAtLocation = robot.getHeadingState()
                    .getRobotHeading();
                if (robot.hasCarryableItem()) {
                    this.typeOfItemInRobot = robot.getCarryableItem()
                        .getItemType();
                    this.itemInRobotID = robot.getCarryableItem().getID();
                }
            }
            Item item = path.getItem();
            if (item != null) {
                this.typeOfItemAtLocation = item.getItemType();
                if (typeOfItemAtLocation == ItemType.BIN) {
                    if (((ItemContainer) item).hasCarryableItem()) {
                        typeOfItemInContainer = ((ItemContainer) item)
                            .getCarryableItem().getItemType();
                    }
                }
                this.itemAtLocationID = item.getID();
            }
        }
    }

    public boolean locationHasPath() {
        return locationHasPath;
    }

    public RobotType getTypeOfRobotAtLocation() {
        return typeOfRobotAtLocation;
    }

    public ItemType getTypeOfItemAtLocation() {
        return typeOfItemAtLocation;
    }

    public ItemType getTypeOfItemInRobot() {
        return typeOfItemInRobot;
    }

    public ItemType getTypeOfItemInContainer() {
        return typeOfItemInContainer;
    }

    public boolean locationHasRobot() {
        return (typeOfRobotAtLocation != RobotType.NULL) ? true : false;
    }

    public boolean locationHasItem() {
        return (typeOfItemAtLocation != ItemType.NULL) ? true : false;
    }

    public boolean robotIsCarryingItem() {
        return (typeOfItemInRobot != ItemType.NULL) ? true : false;
    }

    public boolean containerHasItem() {
        return (typeOfItemInContainer != ItemType.NULL) ? true : false;
    }

    public String getRobotAtLocationID() {
        return robotAtLocationID;
    }

    public String getItemAtLocationID() {
        return itemAtLocationID;
    }

    public String getItemInRobotID() {
        return itemInRobotID;
    }

    public RobotHeadingType getHeadingOfRobotAtLocation() {
        return headingOfRobotAtLocation;
    }

}
