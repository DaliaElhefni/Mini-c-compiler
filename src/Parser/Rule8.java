package Parser;

import Lexical.Token;

//param_list_dash              -> , param param_list_dash | empty
public class Rule8 implements Node {
    Token comma;
    Rule9 rule9;
    Rule8 rule8;

    public Rule8(Token comma, Rule9 rule9, Rule8 rule8) {
        this.comma = comma;
        this.rule9 = rule9;
        this.rule8 = rule8;
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
        System.out.println(tabs + "Rule 8: param_list_dash -> , param param_list_dash | empty");
        System.out.println();
        if(comma!=null) System.out.println(getTabs(number+1)+ "Terminal (,): "+comma.type +" = "+ comma.value);
        System.out.println();
        if(rule9!=null) rule9.printNode(number+1) ;
        System.out.println();
        if(rule8!=null) rule8.printNode(number+1) ; else System.out.println(getTabs(number+1)+ "Rule 8(param_list_dash): null");
    }
}
