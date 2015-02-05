// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.items;

public abstract class ItemContainer extends Item {

    private CarryableItem carryableItem = null;

    public ItemContainer(String ID, int positionX, int positionY, int positionZ) {
        super(ID, positionX, positionY, positionZ);
    }

    public CarryableItem getCarryableItem() {
        return carryableItem;
    }

    public boolean addCarryableItem(CarryableItem carryableItem) {
        boolean result = false;
        if (this.carryableItem == null) {
            this.carryableItem = carryableItem;
            this.carryableItem.setContainer(this);
            result = true;
        }
        return result;
    }

    public boolean removeCarryableItem() {
        boolean result = false;
        if (this.carryableItem != null) {
            this.carryableItem.setContainer(null);
            ;
            this.carryableItem = null;
            result = true;
        }
        return result;
    }

    public boolean hasCarryableItem() {
        return (carryableItem != null) ? true : false;
    }

    public void reset() {
        super.reset();
        carryableItem = null;
    }

}
