// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.interfaces.SimController;

public class SpeedUpCommand extends AbstractAction
{
    private SimController simController;
    
    public SpeedUpCommand(SimController simController)
    {
        putValue(Action.NAME, "Speed Up");
        putValue(Action.SMALL_ICON, new ImageIcon("images//fastforward_ico.png"));
        this.simController = simController;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.simController.speedUpSim();
    }
}
