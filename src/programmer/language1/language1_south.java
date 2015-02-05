// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;
import programmer.LiteralExpression;


public class language1_south extends LiteralExpression{
	
	public language1_south(){
		super("#S");
	}

	@Override
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addSouthCommand();
			return true;
		}
		return false;
	}

}
