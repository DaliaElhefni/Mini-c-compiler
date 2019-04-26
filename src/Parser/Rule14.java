package Parser;

import Lexical.Token;

//compound_stmt                -> {local_decls stmt_list}
public class Rule14 implements Node {
    Token rightCurlyBracket;
    Rule15 rule15;
    Rule10 rule10;
    Token leftCurlyBracket;

    public Rule14(Token rightCurlyBracket, Rule15 rule15, Rule10 rule10, Token leftCurlyBracket) {
        this.leftCurlyBracket = leftCurlyBracket;
        this.rule15 = rule15;
        this.rule10 = rule10;
        this.rightCurlyBracket = rightCurlyBracket;
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
        System.out.println(tabs + "Rule 14: compound_stmt -> {local_decls stmt_list}");
        System.out.println();
        if(rightCurlyBracket!=null) System.out.println(getTabs(number+1)+ "Terminal ({): "+rightCurlyBracket.type +" = "+
                rightCurlyBracket.value);
        System.out.println();
        if(rule15!=null) rule15.printNode(number+1) ; else System.out.println(getTabs(number+1)
                + "Rule 15(local_decls): null");
        System.out.println();
        if(rule10!=null) rule10.printNode(number+1) ; else System.out.println(getTabs(number+1)
                + "Rule 10(stmt_list): null");
        System.out.println();
        if(leftCurlyBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (}): "+leftCurlyBracket.type +" = "
                + leftCurlyBracket.value);
    }
}
