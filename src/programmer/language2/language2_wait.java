// Author: See Ping Lim
// Student Number: s3338291

package programmer.language2;

import programmer.LiteralExpression;

public class language2_wait extends LiteralExpression {

    public language2_wait() {
        super("#H");
    }

    public boolean interpret(String token) {
        // TODO Auto-generated method stub
        if (token.compareToIgnoreCase(this.getLiteral()) == 0) {
            cmd.addOnholdCommand();
            return true;
        }
        return false;
    }

}
