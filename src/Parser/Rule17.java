package Parser;

import Lexical.Token;

//if_stmt_dash                 -> ELSE stmt | empty
public class Rule17 implements Node {
    Token elseWord;
    Rule11 rule11;

    public Rule17(Token elseWord, Rule11 rule11) {
        this.elseWord = elseWord;
        this.rule11 = rule11;
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
        System.out.println(tabs + "Rule 17: if_stmt_dash -> ELSE stmt | empty");
        System.out.println();
        if(elseWord!=null) System.out.println(getTabs(number+1)+ "Terminal (ELSE): "+elseWord.type +" = "+ elseWord.value);
        System.out.println();
        if(rule11!=null) rule11.printNode(number+1) ;
    }
}
