// Author: See Ping Lim
// Student Number: s3338291

package programmer.language2;

import programmer.LiteralExpression;

public class language2_drop extends LiteralExpression {

    public language2_drop() {
        super("DR");
    }

    public boolean interpret(String token) {
        // TODO Auto-generated method stub
        if (token.compareToIgnoreCase(this.getLiteral()) == 0) {
            cmd.addReleaseCommand();
            return true;
        }
        return false;
    }
}
