// Author: Adrian Wong
// Student Number: s3452563

package userinterface.buttonpanel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import simulator.interfaces.SimController;
import userinterface.BotUserInterface;

public class ButtonPanel extends JPanel
{
    private JButton stepBackwardButton, playBackwardButton, stopButton, 
                    playForwardButton, stepForwardButton, slowDownButton, 
                    resetButton, speedUpButton;
    
    private Action stepBackwardCommand, playBackwardCommand, stopCommand,
                   playForwardCommand, stepForwardCommand, slowDownCommand, 
                   resetCommand, speedUpCommand;
    
    private JLabel simStateLabel;
    private JLabel simStep;
    
    private static int imageCount = 1;
    private ImageIcon imageOne = new ImageIcon("images//linux_ico_one.png");
    private ImageIcon imageTwo = new ImageIcon("images//linux_ico_two.png");
    
    public ButtonPanel(BotUserInterface botUI, SimController simController)
    {
        this.setLayout(new GridLayout(2, 5, 5, 5));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        this.stepBackwardCommand = new StepBackwardCommand(simController);
        this.stepBackwardButton = new JButton(stepBackwardCommand);
        this.stepBackwardButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.playBackwardCommand = new PlayBackwardCommand(simController);
        this.playBackwardButton = new JButton(playBackwardCommand);
        this.playBackwardButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.stopCommand = new StopCommand(simController);
        this.stopButton = new JButton(stopCommand);
        this.stopButton.setFont(new Font("Arial", Font.BOLD, 14));

        this.playForwardCommand = new PlayForwardCommand(simController);
        this.playForwardButton = new JButton(playForwardCommand);
        this.playForwardButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.stepForwardCommand = new StepForwardCommand(simController);
        this.stepForwardButton = new JButton(stepForwardCommand);
        this.stepForwardButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.slowDownCommand = new SlowDownCommand(simController);
        this.slowDownButton = new JButton(slowDownCommand);
        this.slowDownButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.resetCommand = new ResetCommand(botUI, simController);
        this.resetButton = new JButton(resetCommand);
        this.resetButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.speedUpCommand = new SpeedUpCommand(simController);
        this.speedUpButton = new JButton(speedUpCommand);
        this.speedUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        this.add(stepBackwardButton);
        this.add(playBackwardButton);
        this.add(stopButton);
        this.add(playForwardButton);
        this.add(stepForwardButton);
        
        this.simStep = new JLabel("SIM STEP: 0");
        this.simStep.setIcon(imageOne);
        this.simStep.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(simStep);
        
        
        this.add(slowDownButton);
        this.add(resetButton);
        this.add(speedUpButton);
        
        this.simStateLabel = new JLabel("GAME STATE: STOPPED");
        this.simStateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.simStateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(simStateLabel);
        
        
    }
    
    public void updateSimStateLabel(String simState)
    {
        this.simStateLabel.setText("GAME STATE: " + simState);
    }
    
    public void setCounter(int count)
    {
        this.simStep.setText("SIM STEP: " + count);
        
        if(imageCount == 1)
        {
            this.simStep.setIcon(imageTwo);
            imageCount = 2;
        }
        else
        {
            this.simStep.setIcon(imageOne);
            imageCount = 1;
        }
    }
}
