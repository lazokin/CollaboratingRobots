// Author: See Ping Lim
// Student Number: s3338291

package programmer;


public class TokenInterpreter {
	
	private String token;
	private LiteralExpression[] expression;
	private int count;
	
	public TokenInterpreter(String token, LiteralExpression[] expression){
		this.token = token;
		this.expression = expression;
	}
	
	public boolean interpret(){
		boolean found = false;
		String number = token.replaceFirst(".*?(\\d+).*", "$1");
		try{
			if(number != null){
				count = Integer.parseInt(number);
			}
		}catch(Exception e)
		{
			return interpretNoDigitToken();
		}
		String modifiedToken = token.replaceAll("(\\d+)", "#");
		for (LiteralExpression literal: expression){
			found = literal.interpret(modifiedToken);
			if(found){
				
				for(int i=1;i<count;i++)
					found = literal.interpret(modifiedToken);
				break;
			}
		}
		if(!found){
			return false;
		}
		return true;
	}

	private boolean interpretNoDigitToken() {
		// TODO Auto-generated method stub
		boolean found = false;
		for (LiteralExpression literal: expression){
			found = literal.interpret(token);
			if(found){
				
				for(int i=1;i<count;i++)
					found = literal.interpret(token);
				break;
			}
		}
		return found;
		
	}

}
