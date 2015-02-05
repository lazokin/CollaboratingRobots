// Author: Adrian Wong
// Student Number: s3452563

package userinterface.robotprogrammerpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import programmer.interfaces.CommandParser;
import programmer.language.LanguageTypes;
import userinterface.BotUserInterface;

public class LanguageSelectorController implements ActionListener
{
    private BotUserInterface botUI;
    private CommandParser commandParser;
    
    public LanguageSelectorController(BotUserInterface botUI, CommandParser commandParser)
    {   
        this.botUI = botUI;
        this.commandParser = commandParser;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Lang 1"))
        {
            this.commandParser.setLanguage(LanguageTypes.LANGUAGE1);
            this.botUI.getMenuPanelView().getRobotProgrammerPanel().setCommandsLabelToLang1();
        }
        else if(e.getActionCommand().equals("Lang 2"))
        {
            this.commandParser.setLanguage(LanguageTypes.LANGUAGE2);
            this.botUI.getMenuPanelView().getRobotProgrammerPanel().setCommandsLabelToLang2();
        }
    }

}
