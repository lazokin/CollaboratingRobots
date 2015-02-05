// Author: Adrian Wong
// Student Number: s3452563

package userinterface.robotprogrammerpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

import programmer.interfaces.CommandParser;
import userinterface.BotUIView;
import userinterface.BotUserInterface;
import userinterface.gridpanel.RobotsOnGrid;

public class RobotProgrammerController implements ActionListener
{
    private BotUserInterface botUI;
    private CommandParser commandParser;
    
    public RobotProgrammerController(BotUserInterface botUI, 
            CommandParser commandParser)
    {   
        this.botUI = botUI;
        this.commandParser = commandParser;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String commandInput = this.botUI.getMenuPanelView().
                getRobotProgrammerPanel().getCommandInput();
        
        String selectedRobot = this.botUI.getMenuPanelView().
                getRobotProgrammerPanel().getSelectedRobot();
        
        if(!selectedRobot.equals(" "))
        {
            this.commandParser.parseCommand(selectedRobot, commandInput);
        }
        
        this.botUI.getMenuPanelView().getRobotProgrammerPanel().clearCommandInput();
        this.botUI.getMenuPanelView().getRobotProgrammerPanel().resetComboBoxPosition();
    }

}
