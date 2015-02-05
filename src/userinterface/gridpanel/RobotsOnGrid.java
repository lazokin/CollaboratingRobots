// Author: Adrian Wong
// Student Number: s3452563

package userinterface.gridpanel;

import java.util.TreeMap;

public class RobotsOnGrid
{
    private static RobotsOnGrid uniqueInstance;
    
    private int newRobotID = 1;
    private TreeMap<String, String> robotList;
    
    private RobotsOnGrid()
    {
        this.robotList = new TreeMap<String, String>();
    }
    
    public static RobotsOnGrid getInstance()
    {
        if(uniqueInstance == null)
            uniqueInstance = new RobotsOnGrid();
        
        return uniqueInstance;
    }
    
    public void addRobotToList(String robotID)
    {
        this.robotList.put(robotID, null);
    }
    
    public void removeRobotFromList(String robotID)
    {
        this.robotList.remove(robotID);
    }
    
    public void storeRobotCommands(String robotID, String command)
    {
        this.robotList.put(robotID, command);
    }
    
    public String getRobotCommands(String robotID)
    {
        return this.robotList.get(robotID);
    }
    
    public String getNewRobotID()
    {
        return String.valueOf(this.newRobotID++);
    }
    
    public String[] getAllRobotsOnGrid()
    {
        String[] allRobotIDs = this.robotList.keySet().toArray
                (new String[this.robotList.size()]);
        return allRobotIDs;
    }
    
    public void resetRobotID()
    {
        this.newRobotID = 1;
    }
}
