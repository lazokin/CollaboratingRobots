// Author: Adrian Wong
// Student Number: s3452563

package userinterface.square;

import simulator.LocationState;
import simulator.interfaces.SimController;
import simulator.items.ItemType;
import simulator.robot.heading.RobotHeadingType;
import userinterface.BotUserInterface;

public class SquareContentManager
{
    private BotUserInterface botUI;
    private SimController simController;
    
    private Square square;
    
    public SquareContentManager(BotUserInterface botUI, SimController simController)
    {
        this.botUI = botUI;
        this.simController = simController;
    }
    
    public void updateSquare(int posX, int posY, int posZ)
    {
        String id = "" + posX + posY + posZ;

        this.square = botUI.getGridPanelView().getSquare(id);

        repaintUpdatedSquare(square);
    }
    
    public void updateAllSquares()
    {
        Square[] squares = this.botUI.getGridPanelView().getAllSquares();
        
        for(Square s : squares)
        {
            repaintUpdatedSquare(s);
        }
    }
    
    private void repaintUpdatedSquare(Square square)
    {
        getSquareContents(square);
        square.repaint();
    }
    
    private void getSquareContents(Square square)
    {
        square.clearSquarePaintComponents();

        LocationState locationState = this.simController.queryLocationState(
                square.getPosX(), square.getPosY(), square.getPosZ());

        if(locationState.locationHasPath() == false)
            square.setSquarePaintComponents(SquareEnums.EMPTY);

        if(locationState.locationHasPath() == true)
            square.setSquarePaintComponents(SquareEnums.PATH);

        if(locationState.locationHasItem() == true)
        {
            if(locationState.getTypeOfItemAtLocation() == ItemType.APPLE)
            {
                square.setSquarePaintComponents(SquareEnums.APPLE);
                square.setItemIDRef(locationState.getItemAtLocationID());
            }
            if(locationState.getTypeOfItemAtLocation() == ItemType.BIN)
            {
                if(locationState.containerHasItem())
                    square.setSquarePaintComponents(SquareEnums.BIN_FULL);
                else
                    square.setSquarePaintComponents(SquareEnums.BIN_EMPTY);
                square.setItemIDRef(locationState.getItemAtLocationID());
            }
        } else
        {
            square.setItemIDRef("nothing");
        }

        if(locationState.locationHasRobot() == true)
        {
            if(locationState.robotIsCarryingItem() == true)
            {
                if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.NORTH)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_HAS_APPLE_N);
                else if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.EAST)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_HAS_APPLE_E);
                else if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.SOUTH)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_HAS_APPLE_S);
                else if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.WEST)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_HAS_APPLE_W);
                square.setRobotIDRef(locationState.getRobotAtLocationID());
            } else
            {
                if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.NORTH)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_N);
                else if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.EAST)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_E);
                else if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.SOUTH)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_S);
                else if(locationState.getHeadingOfRobotAtLocation() == RobotHeadingType.WEST)
                    square.setSquarePaintComponents(SquareEnums.ROBOT_W);
                square.setRobotIDRef(locationState.getRobotAtLocationID());
            }
        } else
        {
            square.setRobotIDRef("nothing");
        }

    }
}
