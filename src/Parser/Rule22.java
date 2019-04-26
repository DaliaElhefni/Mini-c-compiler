package Parser;

import Lexical.Token;

//expr3                        -> OR expr | EQ expr | NE expr | LE expr | < expr | GE expr | > expr | AND expr | + expr | - expr | * expr |
//                                  / expr | % expr
public class Rule22 implements Node {
    Token token;
    Rule19 rule19;

    public Rule22(Token token, Rule19 rule19) {
        this.token = token;
        this.rule19 = rule19;
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
        System.out.println(tabs + "Rule 22: expr3 -> OR expr | EQ expr | NE expr | LE expr | < expr | GE expr | > expr | AND expr | + expr |" +
                " - expr | * expr | / expr | % expr");
        System.out.println();
        if(token!=null) System.out.println(getTabs(number+1)+ "Terminal ("+ token.type.substring(1,token.type.length()-1)+"): "
                +token.type +" = "+ token.value);
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
    }
}
