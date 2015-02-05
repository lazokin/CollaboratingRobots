// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;
import programmer.LiteralExpression;


public class language1_down extends LiteralExpression{
	
	public language1_down(){
		super("#D");
	}

	@Override
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addDownCommand();
			return true;
		}
		return false;
	}

}
