package Parser;

import Lexical.Token;

//stmt                         -> expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt | break_stmt
//break_stmt                   -> break;
public class Rule11 implements Node {
    Rule12 rule12;
    Rule14 rule14;
    Rule16 rule16;
    Rule13 rule13;
    Rule18 rule18;
    Token breakWord;
    Token semicolon;

    public Rule11(Rule12 rule12) {
        this.rule12 = rule12;
        this.rule14 = null;
        this.rule16 = null;
        this.rule13 = null;
        this.rule18 = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public Rule11(Rule14 rule14) {
        this.rule14 = rule14;
        this.rule12 = null;
        this.rule16 = null;
        this.rule13 = null;
        this.rule18 = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public Rule11(Rule16 rule16) {
        this.rule16 = rule16;
        this.rule12 = null;
        this.rule14 = null;
        this.rule13 = null;
        this.rule18 = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public Rule11(Rule13 rule13) {
        this.rule13 = rule13;
        this.rule12 = null;
        this.rule14 = null;
        this.rule16 = null;
        this.rule18 = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public Rule11(Rule18 rule18) {
        this.rule18 = rule18;
        this.rule12 = null;
        this.rule14 = null;
        this.rule16 = null;
        this.rule13 = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public Rule11(Token breakWord, Token semicolon) {
        this.breakWord = breakWord;
        this.semicolon = semicolon;
        this.rule12 = null;
        this.rule14 = null;
        this.rule16 = null;
        this.rule13 = null;
        this.rule18 = null;
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
        System.out.println(tabs + "Rule 11: stmt -> expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt | break_stmt");
        System.out.println();
        if(rule12!=null) rule12.printNode(number+1) ;
        if(rule14!=null) rule14.printNode(number+1) ;
        if(rule16!=null) rule16.printNode(number+1) ;
        if(rule13!=null) rule13.printNode(number+1) ;
        if(rule18!=null) rule18.printNode(number+1) ;
        if(breakWord!=null) System.out.println(getTabs(number+1)+ "Rule 30 (break_stmt): "+breakWord.type +" = "+ breakWord.value);
        if(semicolon!=null) System.out.println(getTabs(number+1)+ "Rule 30 (break_stmt): "+semicolon.type +" = "+ semicolon.value);
    }
}
