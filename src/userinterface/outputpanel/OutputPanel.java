// Author: Adrian Wong
// Student Number: s3452563

package userinterface.outputpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import simulator.interfaces.SimController;
import userinterface.BotUserInterface;

public class OutputPanel extends JPanel
{
    private TitledBorder border;
    private Border blackLine;
    private EmptyBorder margin;
    
    private JTextArea textOutput;
    private JScrollPane scrollPane;
    
    private final static String newline = "\n";
    
    public OutputPanel(BotUserInterface botUI, 
            SimController simController)
    {
        this.blackLine = BorderFactory.createLineBorder(Color.BLACK);
        this.border = BorderFactory.createTitledBorder(blackLine, "Output");
        this.border.setTitleFont(new Font("Arial", Font.BOLD, 12));
        this.margin = new EmptyBorder(5, 5, 5, 5);
        this.setBorder(new CompoundBorder(border, margin));
        
        this.setLayout(new BorderLayout());
        
        this.textOutput = new JTextArea();
        this.textOutput.setEditable(false);
        this.textOutput.setLineWrap(true);
        this.textOutput.setWrapStyleWord(true);
        this.textOutput.setFont(new Font("Arial", Font.PLAIN, 12));
        
        this.scrollPane = new JScrollPane(this.textOutput);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
        
        DefaultCaret caret = (DefaultCaret) this.textOutput.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
    
    public void addText(String string)
    {
        this.textOutput.append(string + newline);
    }
    
    public void clearText()
    {
        this.textOutput.setText("");
    }
}
