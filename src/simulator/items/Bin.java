// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.items;

public class Bin extends ItemContainer {

    public Bin(String ID, int positionX, int positionY, int positionZ) {
        super(ID, positionX, positionY, positionZ);
        super.itemType = ItemType.BIN;
    }

}
