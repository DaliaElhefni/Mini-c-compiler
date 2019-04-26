package Parser;

import Lexical.Token;

//expr2                        -> =expr | [expr] expr4 | (args) | .size | empty
public class Rule21 implements Node {
    Token token;
    Token token2;
    Rule19 rule19;
    Rule23 rule23;
    Rule26 rule26;

    public Rule21(Token token, Rule19 rule19) {
        this.token = token;
        this.rule19 = rule19;
        this.token2 = null;
        this.rule23 = null;
        this.rule26 = null;
    }

    public Rule21(Token token, Rule19 rule19, Token token2, Rule23 rule23) {
        this.token = token;
        this.rule19 = rule19;
        this.token2 = token2;
        this.rule23 = rule23;
        this.rule26 = null;
    }

    public Rule21(Token token, Rule26 rule26, Token token2) {
        this.token = token;
        this.rule19 = null;
        this.token2 = token2;
        this.rule23 = null;
        this.rule26 = rule26;
    }

    public Rule21(Token token, Token token2) {
        this.token = token;
        this.rule19 = null;
        this.token2 = token2;
        this.rule23 = null;
        this.rule26 = null;
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
        System.out.println(tabs + "Rule 21: expr2 -> =expr | [expr] expr4 | (args) | .size | empty");
        System.out.println();
        if(token!=null) System.out.println(getTabs(number+1)+ "Terminal ("+ token.type.substring(1,token.type.length()-1)+"): "
                +token.type +" = "+ token.value);
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
        System.out.println();
        if(rule26!=null) rule26.printNode(number+1) ;
        System.out.println();
        if(token2!=null) System.out.println(getTabs(number+1)+ "Terminal ("+ token2.type.substring(1,token2.type.length()-1)+"): "
                +token2.type +" = "+ token2.value);
        System.out.println();
        if(rule23!=null) rule23.printNode(number+1) ;
    }
}
