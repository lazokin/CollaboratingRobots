// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class GridSizeChangedSimEvent extends SimEvent {

    private int sizeX, sizeY, sizeZ;

    public GridSizeChangedSimEvent(int sizeX, int sizeY, int sizeZ) {
        super();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeZ() {
        return sizeZ;
    }

}
