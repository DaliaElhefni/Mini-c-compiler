package Parser;

import Lexical.Token;

//return_stmt                  -> RETURN expr_stmt
public class Rule18 implements Node {
    Token returnWord;
    Rule12 rule12;

    public Rule18(Token returnWord, Rule12 rule12) {
        this.returnWord = returnWord;
        this.rule12 = rule12;
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
        System.out.println(tabs + "Rule 18: return_stmt -> RETURN expr_stmt");
        System.out.println();
        if(returnWord!=null) System.out.println(getTabs(number+1)+ "Terminal (RETURN): "+returnWord.type +" = "+ returnWord.value);
        System.out.println();
        if(rule12!=null) rule12.printNode(number+1) ;
    }
}
