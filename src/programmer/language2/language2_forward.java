// Author: See Ping Lim
// Student Number: s3338291

package programmer.language2;

import programmer.LiteralExpression;

public class language2_forward extends LiteralExpression{

	public language2_forward(){
		super("#F");
	}
	
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addForwardCommand();
			return true;
		}
		return false;
	}

}
