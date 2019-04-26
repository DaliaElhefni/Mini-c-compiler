package Parser;

//expr                         -> IDENT expr2 expr_dash | ! expr expr_dash | - expr expr_dash | + expr expr_dash | BOOL_LIT expr_dash |
//                                INT_LIT expr_dash | FLOAT_LIT expr_dash | NEW type_spec [expr] expr_dash

import Lexical.Token;

public class Rule19 implements Node {
    Token token;
    Rule21 rule21;
    Rule20 rule20;
    Rule19 rule19;
    Token type;
    Token rightSquareBracket;
    Token leftSquareBracket;

    public Rule19(Token token, Rule21 rule21, Rule20 rule20) {
        this.token = token;
        this.rule21 = rule21;
        this.rule20 = rule20;
        this.rule19 = null;
        this.type = null;
        this.leftSquareBracket = null;
        this.rightSquareBracket = null;
    }

    public Rule19(Token token, Rule19 rule19, Rule20 rule20) {
        this.rule20 = rule20;
        this.token = token;
        this.rule19 = rule19;
        this.rule21 = null;
        this.type = null;
        this.leftSquareBracket = null;
        this.rightSquareBracket = null;
    }

    public Rule19(Token token, Rule20 rule20) {
        this.rule20 = rule20;
        this.token = token;
        this.rule21 = null;
        this.rule19 = null;
        this.type = null;
        this.leftSquareBracket = null;
        this.rightSquareBracket = null;
    }

    public Rule19(Token token, Token type, Token rightSquareBracket, Rule19 rule19, Token leftSquareBracket, Rule20 rule20) {
        this.rule20 = rule20;
        this.rule19 = rule19;
        this.token = token;
        this.type = type;
        this.leftSquareBracket = leftSquareBracket;
        this.rightSquareBracket = rightSquareBracket;
        this.rule21 = null;
    }

    @Override
    public String getTabs(Integer number) {
        String temp = "";
        for(int i=0;i<number;i++){
            temp += "\t";
        }
        return temp;
    }
    @Override
    public void printNode(Integer number) {
        String tabs = getTabs(number);
        System.out.println(tabs + "Rule 19: expr -> IDENT expr2 expr_dash | ! expr expr_dash | - expr expr_dash | + expr expr_dash | " +
                "BOOL_LIT expr_dash | INT_LIT expr_dash | FLOAT_LIT expr_dash | NEW type_spec [expr] expr_dash");
        System.out.println();
        if(token!=null) System.out.println(getTabs(number+1)+ "Terminal ("+ token.type.substring(1,token.type.length()-1)+"): "
                +token.type +" = "+ token.value);
        if(type!=null) System.out.println(getTabs(number+1)+ "Rule 27 (type_spec): " +type.type +" = "+ type.value);
        System.out.println();
        if(rule21!=null) rule21.printNode(number+1) ;
        if(rightSquareBracket!=null) System.out.println(getTabs(number+1)+ "Terminal ([): " +rightSquareBracket.type
                +" = "+ rightSquareBracket.value);
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
        System.out.println();
        if(leftSquareBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (]): " +leftSquareBracket.type
                +" = "+ leftSquareBracket.value);
        System.out.println();
        if(rule20!=null) rule20.printNode(number+1) ; else System.out.println(getTabs(number+1)
                + "Rule 20(expr_dash): null");
    }
}
