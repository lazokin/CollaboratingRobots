// Author: Adrian Wong
// Student Number: s3452563

package userinterface.robotprogrammerpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import programmer.interfaces.CommandParser;
import userinterface.BotUserInterface;

public class RobotProgrammerPanel extends JPanel
{
    private JTextField commandInput;
    private JComboBox<String> selectRobot;
    private JButton programButton;
    private JRadioButton language1Button, language2Button;
    private ButtonGroup buttonGroup;
    
    private RobotProgrammerController robotProgrammerController;
    private LanguageSelectorController languageSelectorController;
    
    private JPanel robotSelectionPanel, languageSelectionPanel, radioButtonPanel, buttonPanel;
    
    private JLabel commandsLabel;
    private String commandsLang1 = "<html>#(N)orth, #(S)outh, #(E)ast, #(W)est, #(U)p, #(D)own, (P)ick, (Dr)op, (H)alt</html>";
    private String commandsLang2 = "<html>#(F)orward, #(B)ack, #(R)ight, #(L)eft, #(U)p, #(D)own, (P)ick, (Dr)op, (H)alt</html>";
    
    private TitledBorder border;
    private Border blackLine;
    private EmptyBorder margin;
    
    public RobotProgrammerPanel(BotUserInterface botUI, 
            CommandParser commandParser)
    {
        this.blackLine = BorderFactory.createLineBorder(Color.BLACK);
        this.border = BorderFactory.createTitledBorder(blackLine, "Program Robot");
        this.border.setTitleFont(new Font("Arial", Font.BOLD, 12));
        this.margin = new EmptyBorder(5, 5, 5, 5);
        this.setBorder(new CompoundBorder(border, margin));
        
        this.setLayout(new GridLayout(6, 1, 5, 5));
        
        this.robotSelectionPanel = new JPanel();
        this.robotSelectionPanel.setLayout(new GridLayout(1, 2));
        
        this.robotSelectionPanel.add(new JLabel("Select Robot:"));
        this.selectRobot = new JComboBox<String>();
        this.selectRobot.addItem(" ");
        this.selectRobot.addActionListener(new LanguageTextController(botUI, commandParser));
        this.robotSelectionPanel.add(this.selectRobot);
        
        this.add(robotSelectionPanel);
        
        this.languageSelectionPanel = new JPanel();
        this.languageSelectionPanel.setLayout(new GridLayout(1, 2));
        
        this.languageSelectionPanel.add(new JLabel("Select Language:"));
        
        this.languageSelectorController = new LanguageSelectorController(botUI, commandParser);
        
        this.radioButtonPanel = new JPanel();
        this.radioButtonPanel.setLayout(new GridLayout(1, 2));
        
        this.language1Button = new JRadioButton("Lang 1");
        this.radioButtonPanel.add(language1Button);
        this.language1Button.setActionCommand("Lang 1");
        this.language1Button.setSelected(true);
        
        this.language2Button = new JRadioButton("Lang 2");
        this.radioButtonPanel.add(language2Button);
        this.language2Button.setActionCommand("Lang 2");
        
        this.language1Button.addActionListener(languageSelectorController);
        this.language2Button.addActionListener(languageSelectorController);
        
        this.languageSelectionPanel.add(radioButtonPanel);
        
        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(language1Button);
        this.buttonGroup.add(language2Button);
        
        this.add(languageSelectionPanel);
        
        this.commandsLabel = new JLabel(this.commandsLang1);
        this.commandsLabel.setMaximumSize(getMaximumSize());
        this.add(this.commandsLabel);
        
        this.add(new JLabel("Enter Commands:"));
        
        this.commandInput = new JTextField();
        this.add(this.commandInput);
        
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new GridLayout(1, 3));
        
        this.buttonPanel.add(new JLabel(""));
        this.buttonPanel.add(new JLabel(""));
        
        this.robotProgrammerController = new RobotProgrammerController(botUI, commandParser);
        this.programButton = new JButton("Program");
        this.programButton.setFont(new Font("Arial", Font.BOLD, 14));
        this.programButton.addActionListener(robotProgrammerController);
        this.buttonPanel.add(programButton);
        
        this.add(buttonPanel);
    }
    
    public String getSelectedRobot()
    {
        String selectedRobot = (String) this.selectRobot.getSelectedItem();
        
        String robotID = " ";
        
        if(selectedRobot != null)
            robotID = selectedRobot.substring(selectedRobot.length() - 1);
        
        return robotID;
    }
    
    public String getCommandInput()
    {
        return this.commandInput.getText();
    }
    
    public void clearCommandInput()
    {
        this.commandInput.setText(" ");
    }
    
    public void updateCommandInput(String command)
    {
        this.commandInput.setText(command);
    }
    
    public void updateComboBox(String[] allRobotIDs)
    {
        this.selectRobot.removeAllItems();
        this.selectRobot.addItem(" ");
        String robotID = null;
        
        for(String s : allRobotIDs)
        {
            if(s.length() == 1)
                robotID = "Robot #0" + s;
            else if(s.length() == 2)
                robotID = "Robot #" + s;
                
            this.selectRobot.addItem(robotID);
        }
    }
    
    public int getComboBoxCurrentPosition()
    {
        return this.selectRobot.getSelectedIndex();
    }
    
    public void resetComboBoxPosition()
    {
        this.selectRobot.setSelectedIndex(0);
    }
    
    public void setCommandsLabelToLang1()
    {
        this.commandsLabel.setText(this.commandsLang1);
    }
    
    public void setCommandsLabelToLang2()
    {
        this.commandsLabel.setText(this.commandsLang2);
    }
}
