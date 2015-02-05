// Author: See Ping Lim
// Student Number: s3338291

package programmer;


public class ProgramInterpreter {
	
	private String[] tokens;
	private TokenInterpreter ti;
	private LiteralExpression[] literal;
	
	public ProgramInterpreter(LiteralExpression[] literal){
		this.literal = literal;
	}
	
	public void storeToken(String[] tokens)
	{
		this.tokens = tokens;
	}
	
	public boolean interpretProgram(){
		boolean result = true;
		for(String token: tokens)
		{
			ti = new TokenInterpreter(token, literal);
			result = ti.interpret();
			if(!result)
			{
				return false;
			}
		}
		return result;
	}

}
