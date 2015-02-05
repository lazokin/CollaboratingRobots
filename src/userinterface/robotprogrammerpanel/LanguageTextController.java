// Author: Adrian Wong
// Student Number: s3452563

package userinterface.robotprogrammerpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import programmer.interfaces.CommandParser;
import userinterface.BotUserInterface;
import userinterface.gridpanel.RobotsOnGrid;

public class LanguageTextController implements ActionListener
{
    private BotUserInterface botUI;
    private CommandParser commandParser;
    private RobotsOnGrid robotsOnGrid;
    
    public LanguageTextController(BotUserInterface botUI, CommandParser commandParser)
    {   
        this.botUI = botUI;
        this.commandParser = commandParser;
        
        this.robotsOnGrid = RobotsOnGrid.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {     
        String robotID = this.botUI.getMenuPanelView().getRobotProgrammerPanel().getSelectedRobot();
        String command = this.robotsOnGrid.getRobotCommands(robotID);
        
        this.botUI.getMenuPanelView().getRobotProgrammerPanel().updateCommandInput(command);

    }
}
