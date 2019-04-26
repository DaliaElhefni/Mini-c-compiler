package Parser;

import Lexical.Token;

//arg_list_dash                -> , expr arg_list_dash | empty
public class Rule25 implements Node {
    Token comma;
    Rule19 rule19;
    Rule25 rule25;

    public Rule25(Token comma, Rule19 rule19, Rule25 rule25) {
        this.comma = comma;
        this.rule19 = rule19;
        this.rule25 = rule25;
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
        System.out.println(tabs + "Rule 25: arg_list_dash -> , expr arg_list_dash | empty");
        System.out.println();
        if(comma!=null) System.out.println(getTabs(number+1)+ "Terminal (,): "+comma.type +" = "+ comma.value);
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
        System.out.println();
        if(rule25!=null) rule25.printNode(number+1) ; else System.out.println(getTabs(number+1)
                + "Rule 25(arg_list_dash): null");
    }
}
