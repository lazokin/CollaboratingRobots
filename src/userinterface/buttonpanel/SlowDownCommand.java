// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.interfaces.SimController;

public class SlowDownCommand extends AbstractAction
{
    private SimController simController;
    
    public SlowDownCommand(SimController simController)
    {
        putValue(Action.NAME, "Slow Down");
        putValue(Action.SMALL_ICON, new ImageIcon("images//fastrewind_ico.png"));
        this.simController = simController;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.simController.slowDownSim();
    }
}
