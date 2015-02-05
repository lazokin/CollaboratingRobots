// Author: See Ping Lim
// Student Number: s3338291

package programmer;

import simulator.robotcommands.*;

public class CommandStack {
	
	private static CommandStack instances = null;
	private int limit = 100;
	private RobotCommandType[] arr ;
    private int    sp  = -1;
    
    private CommandStack(){
    	arr = new RobotCommandType[limit];
    }
    
    public static CommandStack getInstances(){
    	if(instances == null)
		{
			instances = new CommandStack();
		}
		return instances;
    }
    
    public void push( RobotCommandType cmd ) { 
    	if ( !isFull())
    		arr[++sp] = cmd;
    	else{
    		limit +=100;
    		RobotCommandType[] cloneArr = new RobotCommandType[limit];
    		cloneArr = arr.clone();
    		arr = cloneArr;
    		push(cmd);
    	}
    }
    
    public RobotCommandType pop(){
    	if (isEmpty())
    		return null;  
    	return arr[sp--];
    }
    
    private boolean isFull(){ 
    	return sp == arr.length-1; 
    }
    
    protected boolean isEmpty(){ 
    	return sp == -1;
    }
    
    public int getLength(){
    	return sp+1;
    }

}
