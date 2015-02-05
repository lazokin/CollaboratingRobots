// Author: Adrian Wong
// Student Number: s3452563

package userinterface.gridresizepanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import simulator.interfaces.SimController;
import userinterface.BotUserInterface;

public class GridResizeController implements ActionListener
{
    private BotUserInterface botUI;
    private SimController simController;
    
    public GridResizeController(BotUserInterface botUI, 
    		SimController simController)
    {
        this.botUI = botUI;
        this.simController = simController;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        int sizeX = Integer.parseInt(botUI.getMenuPanelView().
        		getGridResizePanel().getInputX());
        int sizeY = Integer.parseInt(botUI.getMenuPanelView().
        		getGridResizePanel().getInputY());
        int sizeZ = Integer.parseInt(botUI.getMenuPanelView().
        		getGridResizePanel().getInputZ());
        
        botUI.getMenuPanelView().getGridResizePanel().clearInput();
        
        simController.setGridSize(sizeX, sizeY, sizeZ);
    }
}
