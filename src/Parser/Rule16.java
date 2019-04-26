package Parser;

import Lexical.Token;

//if_stmt                      -> IF ( expr ) stmt if_stmt_dash
public class Rule16 implements Node {
    Token ifWord;
    Token rightRoundBracket;
    Rule19 rule19;
    Token leftRoundBracket;
    Rule11 rule11;
    Rule17 rule17;

    public Rule16(Token ifWord, Token rightRoundBracket, Rule19 rule19, Token leftRoundBracket, Rule11 rule11, Rule17 rule17) {
        this.ifWord = ifWord;
        this.leftRoundBracket = leftRoundBracket;
        this.rule19 = rule19;
        this.rightRoundBracket = rightRoundBracket;
        this.rule11 = rule11;
        this.rule17 = rule17;
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
        System.out.println(tabs + "Rule 16: if_stmt -> IF ( expr ) stmt if_stmt_dash");
        System.out.println();
        if(ifWord!=null) System.out.println(getTabs(number+1)+ "Terminal (IF): "+ifWord.type +" = "+ ifWord.value);
        if(rightRoundBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (\"(\"): "+rightRoundBracket.type +" = "
                + rightRoundBracket.value);
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
        System.out.println();
        if(leftRoundBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (\")\"): "+leftRoundBracket.type +" = "
                + leftRoundBracket.value);
        System.out.println();
        if(rule11!=null) rule11.printNode(number+1) ;
        System.out.println();
        if(rule17!=null) rule17.printNode(number+1) ; else System.out.println(getTabs(number+1)
                + "Rule 17(if_stmt_dash): null");
    }
}
