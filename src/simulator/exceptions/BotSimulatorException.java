// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.exceptions;

@SuppressWarnings("serial")
public class BotSimulatorException extends Exception {

    public BotSimulatorException() {
        super();
    }

    public BotSimulatorException(String message, Throwable cause,
        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BotSimulatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public BotSimulatorException(String message) {
        super(message);
    }

    public BotSimulatorException(Throwable cause) {
        super(cause);
    }

}
