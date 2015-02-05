// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;
import programmer.LiteralExpression;


public class language1_north extends LiteralExpression{
	
	public language1_north(){
		super("#N");
	}

	@Override
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addNorthCommand();
			return true;
		}
		return false;
	}

}
