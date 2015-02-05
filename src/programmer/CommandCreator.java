// Author: See Ping Lim
// Student Number: s3338291

package programmer;

import simulator.robotcommands.*;
import programmer.CommandStack;

public class CommandCreator {
	
	private static CommandCreator instances = null;
	private CommandStack stack = CommandStack.getInstances();
	
	private CommandCreator()
	{
		super();
	}
	
	public static CommandCreator getInstances(){
		if(instances == null)
		{
			instances = new CommandCreator();
		}
		return instances;
	}
	
	public void addDownCommand(){
		stack.push(RobotCommandType.MOVE_DOWN);
	}
	
	public void addEastCommand(){
		stack.push(RobotCommandType.MOVE_EAST);
	}
	
	public void addNorthCommand(){
		stack.push(RobotCommandType.MOVE_NORTH);
	}
	
	public void addOnholdCommand(){
		stack.push(RobotCommandType.WAIT);
	}
	
	public void addPickCommand(){
		stack.push(RobotCommandType.PICK);
	}
	
	public void addReleaseCommand(){
		stack.push(RobotCommandType.DROP);
	}
	
	public void addSouthCommand(){
		stack.push(RobotCommandType.MOVE_SOUTH);
	}
	
	public void addUpCommand(){
		stack.push(RobotCommandType.MOVE_UP);
	}
	
	public void addWestCommand(){
		stack.push(RobotCommandType.MOVE_WEST);
	}
	
	public void addForwardCommand(){
		stack.push(RobotCommandType.MOVE_FORWARD);
	}
	
	public void addBackwardCommand(){
		stack.push(RobotCommandType.MOVE_BACKWARD);
	}
	
	public void addTurnLeftCommand(){
		stack.push(RobotCommandType.TURN_LEFT);
	}
	
	public void addTurnRightCommand(){
		stack.push(RobotCommandType.TURN_RIGHT);
	}

}
