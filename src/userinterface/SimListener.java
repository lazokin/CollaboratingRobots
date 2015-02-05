// Author: Adrian Wong
// Student Number: s3452563

package userinterface;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import simulator.events.ApplesInBinsSimEvent;
import simulator.events.GridSizeChangedSimEvent;
import simulator.events.ItemAddedSimEvent;
import simulator.events.ItemDroppedInContainerSimEvent;
import simulator.events.ItemDroppedOnPathSimEvent;
import simulator.events.ItemPickedFromContainerSimEvent;
import simulator.events.ItemPickedFromPathSimEvent;
import simulator.events.ItemRemovedSimEvent;
import simulator.events.PathAddedSimEvent;
import simulator.events.PathRemovedSimEvent;
import simulator.events.RobotAddedSimEvent;
import simulator.events.RobotCollisionSimEvent;
import simulator.events.RobotMovedSimEvent;
import simulator.events.RobotOutOfBoundsSimEvent;
import simulator.events.RobotProgrammedSimEvent;
import simulator.events.RobotRemovedSimEvent;
import simulator.events.RobotTurnedSimEvent;
import simulator.events.RobotWaitedSimEvent;
import simulator.events.SimEventListener;
import simulator.events.SimStateChangedSimEvent;
import simulator.events.SimStepChangedSimEvent;
import simulator.interfaces.SimController;
import simulator.robotcommands.RobotCommandType;
import userinterface.gridpanel.ItemsOnGrid;
import userinterface.gridpanel.RobotsOnGrid;
import userinterface.square.SquareContentManager;

public class SimListener implements SimEventListener
{

    BotUserInterface botUI;
    SimController simController;
    
    SquareContentManager squareManager;

    RobotsOnGrid robotsOnGrid;
    ItemsOnGrid itemsOnGrid;

    public SimListener(BotUserInterface botUI, SimController simController)
    {
        this.botUI = botUI;
        this.simController = simController;
        
        this.squareManager = new SquareContentManager(botUI, simController);

        this.robotsOnGrid = RobotsOnGrid.getInstance();
        this.itemsOnGrid = ItemsOnGrid.getInstance();
    }

    @Override
    public void notifyPathAdded(PathAddedSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Path added at (" + event.getPositionX() + ", "
                + event.getPositionY() + ", " + event.getPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyPathRemoved(PathRemovedSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Path removed at (" + event.getPositionX() + ", "
                + event.getPositionY() + ", " + event.getPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotAdded(RobotAddedSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);
        this.robotsOnGrid.addRobotToList(event.getRobotID());

        // update combo box
        String[] allRobotIDs = this.robotsOnGrid.getAllRobotsOnGrid();
        this.botUI.getMenuPanelView().getRobotProgrammerPanel()
                .updateComboBox(allRobotIDs);

        String output = "-> Robot " + event.getRobotID() + " of type "
                + event.getRobotType() + " added at (" + event.getPositionX()
                + ", " + event.getPositionY() + ", " + event.getPositionZ()
                + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotRemoved(RobotRemovedSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);
        this.robotsOnGrid.removeRobotFromList(event.getRobotID());

        // update combo box
        String[] allRobotIDs = this.robotsOnGrid.getAllRobotsOnGrid();
        this.botUI.getMenuPanelView().getRobotProgrammerPanel()
                .updateComboBox(allRobotIDs);

        String output = "-> Robot " + event.getRobotID() + " of type "
                + event.getRobotType() + " removed from ("
                + event.getPositionX() + ", " + event.getPositionY() + ", "
                + event.getPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotMoved(RobotMovedSimEvent event)
    {
        int fromX = event.getFromPositionX();
        int fromY = event.getFromPositionY();
        int fromZ = event.getFromPositionZ();

        squareManager.updateSquare(fromX, fromY, fromZ);

        int toX = event.getToPositionX();
        int toY = event.getToPositionY();
        int toZ = event.getToPositionZ();

        squareManager.updateSquare(toX, toY, toZ);

        String output = "-> Robot " + event.getRobotID() + " moved from ("
                + event.getFromPositionX() + ", " + event.getFromPositionY()
                + ", " + event.getFromPositionZ() + ") to ("
                + +event.getToPositionX() + ", " + event.getToPositionY()
                + ", " + event.getToPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotWaited(RobotWaitedSimEvent event)
    {

        String output = "-> Robot " + event.getRobotID() + " waited";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyGridSizeChanged(GridSizeChangedSimEvent event)
    {
        int sizeX = event.getSizeX();
        int sizeY = event.getSizeY();
        int sizeZ = event.getSizeZ();

        this.botUI.getGridPanelView().setGrid(sizeX, sizeY, sizeZ);
        this.botUI.getGridPanelView().redrawGrid();

        this.robotsOnGrid.resetRobotID();
        this.itemsOnGrid.resetAppleID();
        this.itemsOnGrid.resetBinID();

        String output = "-> Grid size set to (" + event.getSizeX() + ", "
                + event.getSizeY() + ", " + event.getSizeZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotProgrammed(RobotProgrammedSimEvent event)
    {
        String output = "-> Robot " + event.getRobotID() + " programmed\n";
        String command = this.botUI.getMenuPanelView().getRobotProgrammerPanel().getCommandInput();
        output += "    -> " + command;
        
        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
        
        this.robotsOnGrid.storeRobotCommands(event.getRobotID(), command);
    }

    @Override
    public void notifyItemAdded(ItemAddedSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);
        this.itemsOnGrid.addItemToList(event.getItemID());

        String output = "-> Item " + event.getItemID() + " of type "
                + event.getItemType() + " added at (" + event.getPositionX()
                + ", " + event.getPositionY() + ", " + event.getPositionZ()
                + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyItemRemoved(ItemRemovedSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);
        this.itemsOnGrid.removeItemFromList(event.getItemID());

        String output = "-> Item " + event.getItemID() + " of type "
                + event.getItemType() + " removed from ("
                + event.getPositionX() + ", " + event.getPositionY() + ", "
                + event.getPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifySimStateChanged(SimStateChangedSimEvent event)
    {
        String simState = "" + event.getSimState();
        this.botUI.getButtonPanelView().updateSimStateLabel(simState);

        String output = "-> Sim State changed to " + event.getSimState();

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyItemPickedFromPath(ItemPickedFromPathSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Item " + event.getCarryableID()
                + " picked from path by " + event.getRobotID()
                + " at position (" + event.getPositionX() + ", "
                + event.getPositionY() + ", " + event.getPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyItemDroppedOnPath(ItemDroppedOnPathSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Item " + event.getCarryableID()
                + " dropped on path by " + event.getRobotID()
                + " at position (" + event.getPositionX() + ", "
                + event.getPositionY() + ", " + event.getPositionZ() + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyItemPickedFromContainer(
            ItemPickedFromContainerSimEvent event)
    {

        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Item " + event.getCarryableID()
                + " picked from container " + event.getContainerID() + " by "
                + event.getRobotID() + " at position (" + event.getPositionX()
                + ", " + event.getPositionY() + ", " + event.getPositionZ()
                + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyItemDroppedInContainer(
            ItemDroppedInContainerSimEvent event)
    {
        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Item " + event.getCarryableID()
                + " dropped into container " + event.getContainerID() + " by "
                + event.getRobotID() + " at position (" + event.getPositionX()
                + ", " + event.getPositionY() + ", " + event.getPositionZ()
                + ")";
        
        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotTurned(RobotTurnedSimEvent event)
    {

        int posX = event.getPositionX();
        int posY = event.getPositionY();
        int posZ = event.getPositionZ();

        squareManager.updateSquare(posX, posY, posZ);

        String output = "-> Robot " + event.getRobotID() + " turned to the "
                + event.getRobotHeadingType();
        
        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
    }

    @Override
    public void notifyRobotOutOfBounds(RobotOutOfBoundsSimEvent event)
    {

        String output = "-> Robot " + event.getRobotID()
                + " moved out of bounds from (" + event.getFromPositionX()
                + ", " + event.getFromPositionY() + ", "
                + event.getFromPositionZ() + ") to (" + +event.getToPositionX()
                + ", " + event.getToPositionY() + ", " + event.getToPositionZ()
                + ")";

        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
        
        SwingWorker<String, String> sw = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception
            {
                String[] options = {"Reset", "OK"};
                
                int reset = JOptionPane.showOptionDialog(botUI, "Robot is out of bounds!", "You Lose!", 
                        JOptionPane.NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[1]);
                if(reset == 0)
                {
                    simController.resetSim();
                    squareManager.updateAllSquares();
                }
                return null;
            }
        };
        
        sw.execute();
    }

    @Override
    public void notifyRobotCollision(RobotCollisionSimEvent event)
    {
        
        int posX = event.getCollisionX();
        int posY = event.getCollisionY();
        int posZ = event.getCollisionZ();
        
        String output = "-> Robot " + event.getRobotID_1()
            + " collided with Robot " + event.getRobotID_2() + " at ("
            + posX + ", " + posY + ", " + posZ + ")";
        
        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
        
        SwingWorker<String, String> sw = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception
            {
                String[] options = {"Reset", "OK"};
                
                int reset = JOptionPane.showOptionDialog(botUI, "Two robots have collided!", "You Lose!", 
                        JOptionPane.NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[1]);
                if(reset == 0)
                {
                    simController.resetSim();
                    squareManager.updateAllSquares();
                }
                return null;
            }
        };
        
        sw.execute();
    }

    @Override
    public void notifyApplesInBins(ApplesInBinsSimEvent event)
    {
        String output = "-> " + event.getWinningMessage();
        this.botUI.getMenuPanelView().getOutputPanel().addText(output);
        
        SwingWorker<String, String> sw = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception
            {
                String[] options = {"Reset", "OK"};
                
                int reset = JOptionPane.showOptionDialog(botUI, "Congratulations, you've won the game!", "You Win!", 
                        JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
                if(reset == 0)
                {
                    simController.resetSim();
                    squareManager.updateAllSquares();
                }
                return null;
            }
        };
        
        sw.execute();
    }

    @Override
    public void notifySimStepChanged(SimStepChangedSimEvent event)
    {
        int count = event.getSimStep();
        
        this.botUI.getButtonPanelView().setCounter(count);
    }

    @Override
    public void notifySimReset() {

        squareManager.updateAllSquares();
    }
}
