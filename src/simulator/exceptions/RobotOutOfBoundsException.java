// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.exceptions;

@SuppressWarnings("serial")
public class RobotOutOfBoundsException extends SimObjectOutOfBoundsException {

    String robotID;

    public RobotOutOfBoundsException(String robotID, int outOfBoundsX,
        int outOfBoundsY, int outOfBoundsZ) {
        super(outOfBoundsX, outOfBoundsY, outOfBoundsZ);
        this.robotID = robotID;
    }

    public String getRobotID() {
        return robotID;
    }

}
