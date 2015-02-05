// Author: Adrian Wong
// Student Number: s3452563

package userinterface.gridpanel;

import java.util.TreeMap;

public class ItemsOnGrid
{
    private static ItemsOnGrid uniqueInstance;
    
    private int newAppleID = 1;
    private int newBinID = 1;
    private TreeMap<String, String> itemList;
    
    private ItemsOnGrid()
    {
        this.itemList = new TreeMap<String, String>();
    }
    
    public static ItemsOnGrid getInstance()
    {
        if(uniqueInstance == null)
            uniqueInstance = new ItemsOnGrid();
        
        return uniqueInstance;
    }
    
    public void addItemToList(String itemID)
    {
        this.itemList.put(itemID, null);
    }
    
    public void removeItemFromList(String itemID)
    {  
        this.itemList.remove(itemID);
    }
    
    public String getNewAppleID()
    {
        return "A" + this.newAppleID++;
    }
    
    public String getNewBinID()
    {
        return "B" + this.newBinID++;
    }
    
    public String[] getAllItemsOnGrid()
    {
        String[] allItemIDs = this.itemList.keySet().toArray
                (new String[this.itemList.size()]);
        return allItemIDs;
    }
    
    public void resetAppleID()
    {
        this.newAppleID = 1;
    }
    
    public void resetBinID()
    {
        this.newBinID = 1;
    }
}
