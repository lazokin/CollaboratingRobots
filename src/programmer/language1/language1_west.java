// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;
import programmer.LiteralExpression;


public class language1_west extends LiteralExpression{

	public language1_west() {
		super("#W");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addWestCommand();
			return true;
		}
		return false;
	}

}
