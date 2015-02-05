// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.interfaces.SimController;

public class StepForwardCommand extends AbstractAction
{
    private SimController simController;
    
    public StepForwardCommand(SimController simController)
    {
        putValue(Action.NAME, "Step Forward");
        putValue(Action.SMALL_ICON, new ImageIcon("images//forward_ico.png"));
        this.simController = simController;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.simController.stepSimForward();
    }
}
