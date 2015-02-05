// Author: Adrian Wong
// Student Number: s3452563

package userinterface.gridpanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import simulator.LocationState;
import simulator.interfaces.SimController;
import userinterface.BotUIView;
import userinterface.square.Square;

public class PathController extends MouseAdapter
{
    private SimController simController;
    
    public PathController(SimController simController)
    {
        this.simController = simController;
    }

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(SwingUtilities.isLeftMouseButton(e))
		{
			Square square = (Square) e.getComponent();
			
			LocationState locationState = this.simController.queryLocationState
			        (square.getPosX(), square.getPosY(), square.getPosZ());
			
			if(locationState.locationHasPath() == false)
			    this.simController.addPath(square.getPosX(), square.getPosY(), square.getPosZ());
			else
			    this.simController.removePath(square.getPosX(), square.getPosY(), square.getPosZ());
		}
	}
}
