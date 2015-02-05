// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.items;

public class ItemFactory {

    public ItemFactory() {
        super();
    }

    public Item createItem(String itemID, ItemType itemType, int positionX,
            int positionY, int positionZ) {

        switch (itemType) {
        case APPLE:
            return new Apple(itemID, positionX, positionY, positionZ);
        case BIN:
            return new Bin(itemID, positionX, positionY, positionZ);
        default:
            return null;
        }

    }

}
