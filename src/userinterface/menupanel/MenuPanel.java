// Author: Adrian Wong
// Student Number: s3452563

package userinterface.menupanel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programmer.interfaces.CommandParser;
import simulator.interfaces.SimController;
import userinterface.BotUserInterface;
import userinterface.gridresizepanel.GridResizePanel;
import userinterface.outputpanel.OutputPanel;
import userinterface.robotprogrammerpanel.RobotProgrammerPanel;

public class MenuPanel extends JPanel
{
    private GridResizePanel gridResizePanel;
    private OutputPanel outputPanel;
    private RobotProgrammerPanel robotProgrammerPanel;

    public MenuPanel(BotUserInterface botUI, 
            SimController simController, CommandParser commandParser)
    {   
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setSize(400, 600);
        
        this.gridResizePanel = new GridResizePanel(botUI, simController);
        this.add(gridResizePanel, BorderLayout.NORTH);
        
        this.outputPanel = new OutputPanel(botUI, simController);
        this.add(outputPanel, BorderLayout.CENTER);
        
        this.robotProgrammerPanel = new RobotProgrammerPanel(botUI, commandParser);
        this.add(robotProgrammerPanel, BorderLayout.SOUTH);
    }
    
    public GridResizePanel getGridResizePanel()
    {
        return this.gridResizePanel;
    }
    
    public OutputPanel getOutputPanel()
    {
        return this.outputPanel;
    }
    
    public RobotProgrammerPanel getRobotProgrammerPanel()
    {
        return this.robotProgrammerPanel;
    }
}
