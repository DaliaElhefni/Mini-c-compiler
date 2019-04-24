package Lexical;

public class TokenTypes {
    public String tokenName;
    public String tokenExpression;
    public TokenTypes() {
        this.tokenName = "";
        this.tokenExpression = "";
    }

    public TokenTypes(String name, String expression) {
        this.tokenName = name;
        this.tokenExpression = expression;
    }
}
