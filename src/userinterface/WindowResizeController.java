// Author: Adrian Wong
// Student Number: s3452563

package userinterface;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class WindowResizeController implements ComponentListener
{
    private BotUserInterface botUI;
    
    public WindowResizeController(BotUserInterface botUI)
    {
        this.botUI = botUI;
    }

    @Override
    public void componentHidden(ComponentEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void componentMoved(ComponentEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void componentResized(ComponentEvent arg0)
    {
        int gridHeight = this.botUI.getGridPanelView().getHeight();
        this.botUI.setDividerSplitPane(gridHeight);
    }

    @Override
    public void componentShown(ComponentEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
}
