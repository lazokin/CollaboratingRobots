// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.items;

import simulator.robot.Robot;

public abstract class CarryableItem extends Item {

    private Robot carrier = null;
    private ItemContainer container = null;

    public CarryableItem(String ID, int positionX, int positionY, int positionZ) {
        super(ID, positionX, positionY, positionZ);
    }

    public Robot getCarrier() {
        return carrier;
    }

    public ItemContainer getContainer() {
        return container;
    }

    public void setCarrier(Robot carrier) {
        this.carrier = carrier;
    }

    public void setContainer(ItemContainer container) {
        this.container = container;
    }

    public boolean hasCarrier() {
        return (carrier != null) ? true : false;
    }

    public boolean hasContainer() {
        return (container != null) ? true : false;
    }

    public void reset() {
        super.reset();
        carrier = null;
        container = null;
    }

}
