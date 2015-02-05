// Author: See Ping Lim
// Student Number: s3338291

package programmer.language2;

import programmer.LiteralExpression;

public class language2_turnRight extends LiteralExpression{

	public language2_turnRight(){
		super("#R");
	}
	
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addTurnRightCommand();
			return true;
		}
		return false;
	}

}
