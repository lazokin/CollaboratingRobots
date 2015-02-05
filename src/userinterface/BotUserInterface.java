// Author: Adrian Wong
// Student Number: s3452563

package userinterface;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import programmer.interfaces.CommandParser;
import programmer.language.LanguageTypes;
import simulator.interfaces.SimController;
import userinterface.buttonpanel.ButtonPanel;
import userinterface.gridpanel.GridPanel;
import userinterface.menupanel.MenuPanel;

public class BotUserInterface extends JFrame
{

    private SimController simController;
    private CommandParser commandParser;
    private SimListener simListener;
    
    private MenuPanel menuPanel;
    private GridPanel gridPanel;
    
    private JSplitPane splitPane;
    
    private ButtonPanel buttonPanel;
    
    private WindowResizeController windowResizeController;

    public BotUserInterface(SimController simController,
            CommandParser commandParser) 
    {
        this.simController = simController;
        this.commandParser = commandParser;
        this.simListener = new SimListener(this, simController);
        
        this.menuPanel = new MenuPanel(this, simController, commandParser);
        this.gridPanel = new GridPanel(simController);
        
        this.setSize(gridPanel.getWidth() + menuPanel.getWidth(), gridPanel.getHeight());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gridPanel, menuPanel);
        this.splitPane.setDividerLocation(gridPanel.getWidth());
        
        this.add(splitPane, BorderLayout.CENTER);
        this.setTitle("Collaborating Robots v3.142");
        
        this.buttonPanel = new ButtonPanel(this, simController);
        this.add(buttonPanel,BorderLayout.SOUTH);
        
        this.simController.setGridSize(10, 10, 10);
        this.gridPanel.setGrid(10, 10, 10);
        this.gridPanel.redrawGrid();
        this.commandParser.setLanguage(LanguageTypes.LANGUAGE1);
        
        this.windowResizeController = new WindowResizeController(this);
        this.addComponentListener(windowResizeController);
    }

    public SimListener getSimListener() 
    {
        return this.simListener;
    }

    public GridPanel getGridPanelView()
    {
        return this.gridPanel;
    }

    public MenuPanel getMenuPanelView()
    {
        return this.menuPanel;
    }
    
    public ButtonPanel getButtonPanelView()
    {
        return this.buttonPanel;
    }

    public void setDividerSplitPane(int width)
    {
        this.splitPane.setDividerLocation(width);
    }
}
