package application.test;

public class Simulator {

    private int count = 0;
    private volatile boolean running = false;
    private Window window = null;
    private int delay = 250;
    private int max_count = 50;

    private SimStatePlaying simStatePlaying;
    private SimStateStopped simStateStopped;
    private SimState simState;

    public Simulator() {
        this.simStatePlaying = new SimStatePlaying(this);
        this.simStateStopped = new SimStateStopped(this);
        this.simState = simStateStopped;
    }

    public void setSimStateToPlaying() {
        this.simState = simStatePlaying;
        window.changeStateLabel("Playing");
    }

    public void setSimStateToStopped() {
        this.simState = simStateStopped;
        window.changeStateLabel("Stopped");
    }

    public void playpause() {
        simState.playstop();
    }

    public void stop() {
        simState.reset();
    }

    public void stepForward() {
        simState.stepForward();
    }

    public void stepBackward() {
        simState.stepBackward();
    }

    public void speedUp() {
        simState.speedUp();
    }

    public void slowDown() {
        simState.slowDown();
    }

    public void playSim() {
        running = true;
        while (running && count < max_count) {
            stepSimForward();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (count == max_count) {
            setSimStateToStopped();
        }
    }

    public void stopSim() {
        running = false;
    }

    public void resetSim() {
        stopSim();
        count = 0;
        window.changeCounterLabel("" + count);
    }

    public void stepSimBackward() {
        count--;
        if (count < 0) {
            count = 0;
        }
        window.changeCounterLabel("" + count);
    }

    public void stepSimForward() {
        count++;
        if (count > max_count) {
            count = max_count;
        }
        window.changeCounterLabel("" + count);
    }

    public void speedUpSim() {
        delay /= 2;
    }

    public void slowDownSim() {
        delay *= 2;

    }

    public void setWindow(Window window) {
        this.window = window;
    }

}

abstract class SimState {

    Simulator simulator;

    public SimState(Simulator s) {
        this.simulator = s;
    }

    public abstract void playstop();

    public abstract void reset();

    public abstract void stepForward();

    public abstract void stepBackward();

    public abstract void speedUp();

    public abstract void slowDown();
}

class SimStatePlaying extends SimState {

    public SimStatePlaying(Simulator s) {
        super(s);
    }

    @Override
    public void playstop() {
        simulator.setSimStateToStopped();
        simulator.stopSim();
    }

    @Override
    public void reset() {
        simulator.setSimStateToStopped();
        simulator.resetSim();
    }

    @Override
    public void stepForward() {
        // No action
    }

    @Override
    public void stepBackward() {
        // No action
    }

    @Override
    public void speedUp() {
        simulator.speedUpSim();
    }

    @Override
    public void slowDown() {
        simulator.slowDownSim();
    }

}

class SimStateStopped extends SimState {

    public SimStateStopped(Simulator s) {
        super(s);
    }

    @Override
    public void playstop() {
        simulator.setSimStateToPlaying();
        simulator.playSim();
    }

    @Override
    public void reset() {
        simulator.resetSim();
    }

    @Override
    public void stepForward() {
        simulator.stepSimForward();
    }

    @Override
    public void stepBackward() {
        simulator.stepSimBackward();
    }

    @Override
    public void speedUp() {
        // No action
    }

    @Override
    public void slowDown() {
        // No action
    }

}
