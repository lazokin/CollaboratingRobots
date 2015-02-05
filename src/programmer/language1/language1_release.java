// Author: See Ping Lim
// Student Number: s3338291

package programmer.language1;

import programmer.LiteralExpression;

public class language1_release extends LiteralExpression {

    public language1_release() {
        super("DR");
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean interpret(String token) {
        // TODO Auto-generated method stub
        if (token.compareToIgnoreCase(this.getLiteral()) == 0) {
            cmd.addReleaseCommand();
            return true;
        }
        return false;
    }

}
