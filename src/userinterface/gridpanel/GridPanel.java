// Author: Adrian Wong
// Student Number: s3452563

package userinterface.gridpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import simulator.interfaces.SimController;
import userinterface.rightclickmenu.RightClickController;
import userinterface.square.Square;

public class GridPanel extends JPanel
{
    private HashMap<String, Square> squares;
    private PathController pathController;
    
    private ArrayList<JPanel> gridLayers = new ArrayList<JPanel>();
    private JTabbedPane gridPanes = new JTabbedPane();

    private RightClickController rightClickController;
    
    public GridPanel(SimController simController)
    {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setSize(600, 750);
        
        this.squares = new HashMap<String, Square>();
        
        this.pathController = new PathController(simController);
        this.rightClickController = new RightClickController(simController);
    }
    
    private void addGridLayers(int x, int y, int z)
    {
        for(int i = 0; i < z; i++)
        {
            this.gridLayers.add(new JPanel());
            this.gridLayers.get(i).setLayout(new GridLayout(y, x, 2, 2));
            this.gridLayers.get(i).setBackground(Color.WHITE);
            this.gridLayers.get(i).setBorder(new EmptyBorder(5, 5, 5, 5));
            
            this.gridPanes.addTab("Z = " + i, this.gridLayers.get(i));
        }
    }
    
    public void setGrid(int setX, int setY, int setZ)
    {
        this.gridPanes.removeAll();
        this.gridLayers.clear();
        this.removeAll();
        
        for(int z = 0; z < setZ; z++)
        {
            addGridLayers(setX, setY, setZ);

            for(int y = setY; y > 0; y--)
            {
                for(int x = 0; x < setX; x++)
                {
                    Square s = new Square(x, y - 1, z);
                    
                    s.addMouseListener(this.pathController);
                    s.addMouseListener(this.rightClickController);

                    this.squares.put(s.getID(), s);
                    this.gridLayers.get(z).add(s);
                }
            }
        }
        
        this.add(this.gridPanes);
    }
    
    public void redrawGrid()
    {
        this.revalidate();
        this.repaint();
    }
    
    public Square getSquare(String id)
    {
        return this.squares.get(id);
    }
    
    public Square[] getAllSquares()
    {
        Square[] allSquares = this.squares.values().
                toArray(new Square[this.squares.size()]);
        return allSquares;
    }
}
