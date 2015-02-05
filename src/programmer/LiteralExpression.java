// Author: See Ping Lim
// Student Number: s3338291

package programmer;

public abstract class LiteralExpression {
	
	private String literal;
	protected static CommandCreator cmd;
	
	public LiteralExpression(String literal)
	{
		this.literal = literal;
		cmd = CommandCreator.getInstances();
	}
	
	public String getLiteral()
	{
		return literal;
	}
	
	public abstract boolean interpret(String token);

}
