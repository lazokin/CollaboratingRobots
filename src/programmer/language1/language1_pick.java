// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;
import programmer.LiteralExpression;


public class language1_pick extends LiteralExpression{
	
	public language1_pick(){
		super("P");
	}

	@Override
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addPickCommand();
			return true;
		}
		return false;
	}

}
