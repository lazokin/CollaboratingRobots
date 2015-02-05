// Author: Adrian Wong
// Student Number: s3452563

package userinterface.rightclickmenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import simulator.interfaces.SimController;
import userinterface.BotUIView;
import userinterface.square.Square;

public class RightClickController extends MouseAdapter
{
    private RightClickPopupMenu rightClickPopupMenu;
    
    public RightClickController(SimController simController)
    {
        this.rightClickPopupMenu = new RightClickPopupMenu(simController);
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        if(SwingUtilities.isRightMouseButton(e))
        {
            this.rightClickPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            Square square = (Square) e.getComponent();
            this.rightClickPopupMenu.setSquareReference(square);
        }
    }
}
