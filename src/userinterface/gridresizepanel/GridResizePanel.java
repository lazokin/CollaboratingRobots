// Author: Adrian Wong
// Student Number: s3452563

package userinterface.gridresizepanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import simulator.interfaces.SimController;
import userinterface.BotUserInterface;


public class GridResizePanel extends JPanel
{
    private JTextField inputX, inputY, inputZ;
    private JButton gridResizeButton;
    
    private TitledBorder border;
    private Border blackLine;
    private EmptyBorder margin;
    
    private GridResizeController gridResizeController;
    
    public GridResizePanel(BotUserInterface botUI, 
    		SimController simController)
    {
        this.blackLine = BorderFactory.createLineBorder(Color.BLACK);
        this.border = BorderFactory.createTitledBorder(blackLine, "Set Grid Size");
        this.border.setTitleFont(new Font("Arial", Font.BOLD, 12));
        this.margin = new EmptyBorder(1, 1, 1, 1);
        this.setBorder(new CompoundBorder(border, margin));
        
        this.setLayout(new FlowLayout());
        
        this.add(new JLabel("Set X:"));
        this.inputX = new JTextField(2);
        this.add(inputX);
        
        this.add(new JLabel("Set Y:"));
        this.inputY = new JTextField(2);
        this.add(inputY);
        
        this.add(new JLabel("Set Z:"));
        this.inputZ = new JTextField(2);
        this.add(inputZ);
        
        this.gridResizeController = new GridResizeController(botUI, simController);
        this.gridResizeButton = new JButton("Set Grid");
        this.gridResizeButton.setFont(new Font("Arial", Font.BOLD, 14));
        this.gridResizeButton.addActionListener(gridResizeController);
        this.add(gridResizeButton);
    }
    
    public String getInputX() { return inputX.getText(); }
    public String getInputY() { return inputY.getText(); }
    public String getInputZ() { return inputZ.getText(); }
    
    public void clearInput()
    {
        inputX.setText("");
        inputY.setText("");
        inputZ.setText("");
    }
}
