// Author: Adrian Wong
// Student Number: s3452563

package userinterface.squaredecorator;

import java.util.ArrayList;

import userinterface.square.SquareEnums;

public class RenderFactory
{
    private static RenderFactory uniqueInstance;
    
    public static RenderFactory getInstance()
    {
        if(uniqueInstance == null)
            uniqueInstance = new RenderFactory();
        
        return uniqueInstance;
    }
    
    public Render getRender(ArrayList<SquareEnums> squareContents)
    {
        Render render = new EmptySquare();
        
        for(SquareEnums s : squareContents)
        {
            switch(s)
            {
                case EMPTY:
                    break;
                case PATH:
                    render = new PathSquare(render);
                    break;
                case ROBOT_N:
                    render = new RobotImageNorth(render);
                    render = new RobotNumber(render);
                    break;
                case ROBOT_E:
                    render = new RobotImageEast(render);
                    render = new RobotNumber(render);
                    break;
                case ROBOT_S:
                    render = new RobotImageSouth(render);
                    render = new RobotNumber(render);
                    break;
                case ROBOT_W:
                    render = new RobotImageWest(render);
                    render = new RobotNumber(render);
                    break;
                case APPLE:
                    render = new AppleImage(render);
                    // render = new ItemNumber(render);
                    break;
                case BIN_EMPTY:
                    render = new BinEmptyImage(render);
                    // render = new ItemNumber(render);
                    break;
                case BIN_FULL:
                    render = new BinFullImage(render);
                    break;
                case ROBOT_HAS_APPLE_N:
                    render = new RobotHasAppleImageNorth(render);
                    render = new RobotNumber(render);
                    break;
                case ROBOT_HAS_APPLE_E:
                    render = new RobotHasAppleImageEast(render);
                    render = new RobotNumber(render);
                    break;
                case ROBOT_HAS_APPLE_S:
                    render = new RobotHasAppleImageSouth(render);
                    render = new RobotNumber(render);
                    break;
                case ROBOT_HAS_APPLE_W:
                    render = new RobotHasAppleImageWest(render);
                    render = new RobotNumber(render);
                    break;
                default:
                    break;
            }
        }
        
        return render;
    }
}
