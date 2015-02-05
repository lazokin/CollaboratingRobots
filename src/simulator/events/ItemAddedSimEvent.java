// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

import simulator.items.ItemType;

public class ItemAddedSimEvent extends SimEvent {

    private String itemID;
    private ItemType itemType;
    private int positionX, positionY, positionZ;

    public ItemAddedSimEvent(String itemID, ItemType itemType, int positionX,
            int positionY, int positionZ) {
        super();
        this.itemID = itemID;
        this.itemType = itemType;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public String getItemID() {
        return itemID;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionZ() {
        return positionZ;
    }

}
