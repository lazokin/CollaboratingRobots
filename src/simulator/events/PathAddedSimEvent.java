// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class PathAddedSimEvent extends SimEvent {

    private int positionX, positionY, positionZ;

    public PathAddedSimEvent(int positionX, int positionY, int positionZ) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
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
