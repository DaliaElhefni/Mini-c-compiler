package Parser;

import Lexical.Token;

//while_stmt                   -> WHILE (expr) stmt
public class Rule13 implements Node {
    Token whileWord;
    Token rightRoundBracket;
    Rule19 rule19;
    Token leftRoundBracket;
    Rule11 rule11;

    public Rule13(Token whileWord, Token rightRoundBracket, Rule19 rule19, Token leftRoundBracket, Rule11 rule11) {
        this.whileWord = whileWord;
        this.leftRoundBracket = leftRoundBracket;
        this.rule19 = rule19;
        this.rightRoundBracket = rightRoundBracket;
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
        System.out.println(tabs + "Rule 13: while_stmt -> WHILE (expr) stmt");
        if(whileWord!=null) System.out.println(getTabs(number+1)+ "Terminal (WHILE): "+whileWord.type +" = "+ whileWord.value);
        if(rightRoundBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (\"(\"): "+rightRoundBracket.type +" = "
                + rightRoundBracket.value);
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
        System.out.println();
        if(leftRoundBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (\")\"): "+leftRoundBracket.type +" = "
                + leftRoundBracket.value);
        System.out.println();
        if(rule11!=null) rule11.printNode(number+1) ;
    }
}
