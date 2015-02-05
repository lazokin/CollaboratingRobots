// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.interfaces.SimController;

public class StepBackwardCommand extends AbstractAction
{
    private SimController simController;
    
    public StepBackwardCommand(SimController simController)
    {
        putValue(Action.NAME, "Step Backward");
        putValue(Action.SMALL_ICON, new ImageIcon("images//backward_ico.png"));
        this.simController = simController;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.simController.stepSimBackward();
    }
}