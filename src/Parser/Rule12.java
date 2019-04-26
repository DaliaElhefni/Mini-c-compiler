package Parser;

import Lexical.Token;

//expr_stmt                    -> expr ; | ;
public class Rule12 implements Node {
    Rule19 rule19;
    Token semicolon;

    public Rule12(Rule19 rule19, Token semicolon) {
        this.rule19 = rule19;
        this.semicolon = semicolon;
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
        System.out.println(tabs + "Rule 12: expr_stmt -> expr ; | ;");
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
        System.out.println();
        if(semicolon!=null) System.out.println(getTabs(number+1)+ "Terminal (;): "+semicolon.type +" = "+ semicolon.value);
    }
}
