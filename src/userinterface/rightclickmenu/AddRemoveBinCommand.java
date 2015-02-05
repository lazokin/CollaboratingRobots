// Author: Adrian Wong
// Student Number: s3452563

package userinterface.rightclickmenu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.LocationState;
import simulator.interfaces.SimController;
import simulator.items.ItemType;
import userinterface.gridpanel.ItemsOnGrid;
import userinterface.square.Square;

public class AddRemoveBinCommand extends AbstractAction
{
    private SimController simController;
    private Square square;
    private ItemsOnGrid itemsOnGrid;
    
    public AddRemoveBinCommand(SimController simController)
    {
        this.putValue(Action.NAME, "Add/Remove Bin");
        this.putValue(Action.SMALL_ICON, new ImageIcon("images//bin_ico.png"));

        this.simController = simController;
        
        this.itemsOnGrid = ItemsOnGrid.getInstance();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int x = this.square.getPosX();
        int y = this.square.getPosY();
        int z = this.square.getPosZ();
        
        LocationState locationState = this.simController.queryLocationState(x, y, z);
        
        if(locationState.locationHasItem() == false)
            this.simController.addItem(this.itemsOnGrid.getNewBinID(), ItemType.BIN, x, y, z);
        else if(locationState.getTypeOfItemAtLocation() == ItemType.BIN)
            this.simController.removeItem(locationState.getItemAtLocationID());
    }

    protected void setSquareReference(Square square) { this.square = square; }
}