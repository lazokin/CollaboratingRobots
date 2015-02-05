// Author: See Ping Lim
// Student Number: s3338291

package programmer;

import programmer.interfaces.CommandParser;
import programmer.language.LanguageType;
import programmer.language1.*;
import programmer.language2.*;
import simulator.interfaces.SimProgrammer;
import simulator.robotcommands.RobotCommandType;
import programmer.language.*;

public class BotProgrammer implements CommandParser {

    private SimProgrammer simProgrammer;
    private String inputProgram; // program entered by user
    private String robotID;
    private String[] tokenizedProgram;
    private LanguageType language;
    private ProgramTokenizer programTokenizer = new ProgramTokenizer();
    private ProgramInterpreter interpreter;
	private LiteralExpression[] language1 = new LiteralExpression[9];
	private LiteralExpression[] language2 = new LiteralExpression[7];
	private CommandStack cmdStack;

    public BotProgrammer(SimProgrammer simProgrammer) {
        super();
        this.simProgrammer = simProgrammer;
        this.language = new LanguageType();
        setupLanguage();
        setupCmdStack();
    }

	private void setupCmdStack() {
		// TODO Auto-generated method stub
		cmdStack = CommandStack.getInstances();
	}

	private void setupLanguage() {
		// TODO Auto-generated method stub
		language1[0] = new language1_down();
		language1[1] = new language1_east();
		language1[2] = new language1_north();
		language1[3] = new language1_onhold();
		language1[4] = new language1_pick();
		language1[5] = new language1_release();
		language1[6] = new language1_south();
		language1[7] = new language1_up();
		language1[8] = new language1_west();
		language2[0] = new language2_backward();
		language2[1] = new language2_drop();
		language2[2] = new language2_forward();
		language2[3] = new language2_pick();
		language2[4] = new language2_turnLeft();
		language2[5] = new language2_turnRight();
		language2[6] = new language2_wait();
		
	}

	@Override
	public void parseCommand(String robotID, String command) {
		// TODO Auto-generated method stub
		this.robotID = robotID;
		this.inputProgram = command;
		breakCommand();
		interpreter = new ProgramInterpreter(getLanguage());
		interpreter.storeToken(tokenizedProgram);
		boolean result = interpreter.interpretProgram();
		if(result)
		{
			parseProgram();
		}
		else{
			clearCmdStack();
		}
	}
	
	private LiteralExpression[] getLanguage() {
		// TODO Auto-generated method stub
		LanguageTypes type = language.getLanguageType();
		if(type.equals(LanguageTypes.LANGUAGE1))
			return language1;
		else if(type.equals(LanguageTypes.LANGUAGE2))
			return language2;
		else
			return language1;
	}

	private void parseProgram() {
		// TODO Auto-generated method stub
		RobotCommandType command;
		int bound = cmdStack.getLength();
		int i = bound;
		RobotCommandType[] commandArr = new RobotCommandType[bound];
		command = cmdStack.pop();
		while(command!=null){
			commandArr[i-1] = command;
			command = cmdStack.pop();
			i--;
		}
		clearCmdStack();
		simProgrammer.programRobot(robotID, commandArr);
	}

	private void clearCmdStack() {
		// TODO Auto-generated method stub
		while(!cmdStack.isEmpty())
			cmdStack.pop();
	}

	private void breakCommand() {
		// TODO Auto-generated method stub
		tokenizedProgram = programTokenizer.tokenProgram(inputProgram);
	}

	@Override
	public boolean setLanguage(LanguageTypes type) {
		// TODO Auto-generated method stub
		language.changeLanguage(type);
		if(language.getLanguageType() != null)
			return true;
		return false;
	}

	@Override
	public void getProgram(String robotID, String program) {
		// TODO Auto-generated method stub
		
	}

}
