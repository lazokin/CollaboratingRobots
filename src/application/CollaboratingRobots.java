package application;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import programmer.BotProgrammer;
import programmer.interfaces.CommandParser;
import simulator.BotSimulator;
import simulator.interfaces.SimAutomator;
import simulator.interfaces.SimController;
import simulator.interfaces.SimProgrammer;
import userinterface.BotUserInterface;
import automation.BotAutomator;

public class CollaboratingRobots {

    public static void main(String[] args) {
        

        // Set the look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel(UIManager
            // .getCrossPlatformLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        // Create BotSimulator and interface references
        final BotSimulator botSimulator = BotSimulator.getInstance();
        final SimController simController = botSimulator;
        SimProgrammer simProgrammer = botSimulator;
        SimAutomator simAutomator = botSimulator;

        // Create BotProgrammer and interface references
        BotProgrammer botProgrammer = new BotProgrammer(simProgrammer);
        final CommandParser commandParser = botProgrammer;

        // Create BotAutomator
        BotAutomator botAutomator = new BotAutomator(simAutomator);

        // Create BotUserInterface
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BotUserInterface botUI = new BotUserInterface(simController,
                        commandParser);
                
                // Register BotUserInterface as a simulation event listener
                botSimulator.registerSimEventListener(botUI.getSimListener());
            }
        });
    }
}
