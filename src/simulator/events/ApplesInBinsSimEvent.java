// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.events;

public class ApplesInBinsSimEvent extends SimEvent {

    private String winningMessage;

    public ApplesInBinsSimEvent(String winningMessage) {
        super();
        this.winningMessage = winningMessage;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

}
