// Author: Adrian Wong
// Student Number: s3452563

package userinterface.rightclickmenu;

import javax.swing.JPopupMenu;

import simulator.interfaces.SimController;
import userinterface.square.Square;

public class RightClickPopupMenu extends JPopupMenu
{
    private AddRemoveRobotCommand addRemoveRobotCommand;
    private AddRemoveAppleCommand addRemoveAppleCommand;
    private AddRemoveBinCommand addRemoveBinCommand;
    
    public RightClickPopupMenu(SimController simController)
    {
        this.addRemoveRobotCommand = new AddRemoveRobotCommand(simController);
        this.add(addRemoveRobotCommand);
        
        this.addRemoveAppleCommand = new AddRemoveAppleCommand(simController);
        this.add(addRemoveAppleCommand);
        
        this.addRemoveBinCommand = new AddRemoveBinCommand(simController);
        this.add(addRemoveBinCommand);
    }
    
    protected void setSquareReference(Square square)
    {
        this.addRemoveRobotCommand.setSquareReference(square);
        this.addRemoveAppleCommand.setSquareReference(square);
        this.addRemoveBinCommand.setSquareReference(square);
    }
}
