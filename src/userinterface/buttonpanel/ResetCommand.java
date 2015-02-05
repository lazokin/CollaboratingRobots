// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.interfaces.SimController;
import userinterface.BotUserInterface;
import userinterface.square.SquareContentManager;

public class ResetCommand extends AbstractAction
{
    private SimController simController;
    
    private SquareContentManager squareManager;
    
    public ResetCommand(BotUserInterface botUI, SimController simController)
    {
        putValue(Action.NAME, "Reset");
        putValue(Action.SMALL_ICON, new ImageIcon("images//reset_ico.png"));
        this.simController = simController;
        
        this.squareManager = new SquareContentManager(botUI, simController);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.simController.resetSim();
    }
}
