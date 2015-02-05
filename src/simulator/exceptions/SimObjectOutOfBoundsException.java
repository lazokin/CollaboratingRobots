// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.exceptions;

@SuppressWarnings("serial")
public class SimObjectOutOfBoundsException extends BotSimulatorException {

    int outOfBoundsX;
    int outOfBoundsY;
    int outOfBoundsZ;

    public SimObjectOutOfBoundsException(int outOfBoundsX, int outOfBoundsY,
        int outOfBoundsZ) {
        super();
        this.outOfBoundsX = outOfBoundsX;
        this.outOfBoundsY = outOfBoundsY;
        this.outOfBoundsZ = outOfBoundsZ;
    }

    public int getOutOfBoundsX() {
        return outOfBoundsX;
    }

    public int getOutOfBoundsY() {
        return outOfBoundsY;
    }

    public int getOutOfBoundsZ() {
        return outOfBoundsZ;
    }

}
