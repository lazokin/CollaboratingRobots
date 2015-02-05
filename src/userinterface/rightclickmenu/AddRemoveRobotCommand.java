// Author: Adrian Wong
// Student Number: s3452563

package userinterface.rightclickmenu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import simulator.LocationState;
import simulator.interfaces.SimController;
import simulator.robot.RobotType;
import userinterface.gridpanel.RobotsOnGrid;
import userinterface.square.Square;

public class AddRemoveRobotCommand extends AbstractAction
{
    private SimController simController;
    private Square square;
    private RobotsOnGrid robotsOnGrid;
    
    public AddRemoveRobotCommand(SimController simController)
    {
        this.putValue(Action.NAME, "Add/Remove Robot");
        this.putValue(Action.SMALL_ICON, new ImageIcon("images//android_ico.png"));
        this.simController = simController;
        
        this.robotsOnGrid = RobotsOnGrid.getInstance();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int x = this.square.getPosX();
        int y = this.square.getPosY();
        int z = this.square.getPosZ();
        
        LocationState locationState = this.simController.queryLocationState(x, y, z);
        
        if(locationState.locationHasRobot() == false)
            this.simController.addRobot(this.robotsOnGrid.getNewRobotID(), RobotType.BASIC_ANDROID, x, y, z);
        else
        {
            String id = locationState.getRobotAtLocationID();
            this.simController.removeRobot(id);
        }
    }
    
    protected void setSquareReference(Square square) { this.square = square; }
}
