// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;
import programmer.LiteralExpression;


public class language1_east extends LiteralExpression{

	public language1_east() {
		super("#E");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean interpret(String token) {
		// TODO Auto-generated method stub
		if(token.compareToIgnoreCase(this.getLiteral())==0){
			cmd.addEastCommand();
			return true;
		}
		return false;
	}

}
