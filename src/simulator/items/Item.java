// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.items;

import simulator.SimObject;

public abstract class Item extends SimObject {

    protected ItemType itemType;

    public Item(String ID, int positionX, int positionY, int positionZ) {
        super(ID, positionX, positionY, positionZ);
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void reset() {
        super.reset();
    }

}
