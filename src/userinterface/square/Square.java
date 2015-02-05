// Author: Adrian Wong
// Student Number: s3452563

package userinterface.square;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import userinterface.squaredecorator.Render;
import userinterface.squaredecorator.RenderFactory;

public class Square extends JPanel
{
    private int posX, posY, posZ;
    private String id;
    
    private RenderFactory renderFactory;
    private Render render;
    
    private ArrayList<SquareEnums> squareContents;
    
    private String robotIDRef;
    private String itemIDRef;
    
    public Square(int posX, int posY, int posZ)
    {
        this.renderFactory = RenderFactory.getInstance();
        
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        
        this.id = "" + posX + posY + posZ;

        this.squareContents = new ArrayList<SquareEnums>();

        this.robotIDRef = "nothing";
        this.itemIDRef = "nothing";
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        this.render = this.renderFactory.getRender(this.squareContents);
        this.render.renderGraphics(this, g);
    }
    
    public int getPosX() { return this.posX; }
    public int getPosY() { return this.posY; }
    public int getPosZ() { return this.posZ; }
    public String getID() { return this.id; }
    
    public void setRobotIDRef(String robotID) { this.robotIDRef = robotID; }
    public String getRobotIDRef() { return this.robotIDRef; }
    public void setItemIDRef(String itemID) { this.itemIDRef = itemID; }
    public String getItemIDRef() { return this.itemIDRef; }
    
    public void setSquarePaintComponents(SquareEnums squareEnums)
    {
        this.squareContents.add(squareEnums);
    }
    
    public void clearSquarePaintComponents()
    {
        this.squareContents = new ArrayList<SquareEnums>();
    }
}
