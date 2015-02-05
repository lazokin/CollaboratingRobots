// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import simulator.interfaces.SimController;

public class PlayBackwardCommand extends AbstractAction
{
    private SimController simController;
    
    public PlayBackwardCommand(SimController simController)
    {
        putValue(Action.NAME, "Play Backward");
        putValue(Action.SMALL_ICON, new ImageIcon("images//playbackward_ico.png"));
        this.simController = simController;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        SwingWorker<String, String> sw = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception
            {
                simController.runSimBackward();
                return null;
            }
        };
        
        sw.execute();
    }
}
