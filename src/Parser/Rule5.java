package Parser;

import Lexical.Token;

//fun_decl                     -> type_spec IDENT (params) compound_stmt
//type_spec                    -> VOID | BOOL | INT | FLOAT
public class Rule5 implements Node {
    Token type;
    Token identifier;
    Token rightRoundBracket;
    Rule6 rule6;
    Token leftRoundBracket;
    Rule14 rule14;


    public Rule5(Token type, Token identifier, Token rightRoundBracket, Rule6 rule6, Token leftRoundBracket, Rule14 rule14) {
        this.type = type;
        this.identifier = identifier;
        this.leftRoundBracket = leftRoundBracket;
        this.rule6 = rule6;
        this.rightRoundBracket = rightRoundBracket;
        this.rule14 = rule14;
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
        System.out.println(tabs + "Rule 5: fun_decl -> type_spec IDENT (params) compound_stmt");
        System.out.println();
        if(type!=null) System.out.println(getTabs(number+1)+ "Rule 27(type_spec): "+type.type +" = "+ type.value);
        if(identifier!=null) System.out.println(getTabs(number+1)+ "Terminal (IDENT): "+identifier.type +" = "+ identifier.value);
        if(rightRoundBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (\"(\"): "+rightRoundBracket.type +" = "+ rightRoundBracket.value);
        System.out.println();
        if(rule6!=null) rule6.printNode(number+1) ; else System.out.println(getTabs(number+1)+ "Rule 6(params): null");
        System.out.println();
        if(leftRoundBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (\")\"): "+leftRoundBracket.type +" = "+ leftRoundBracket.value);
        System.out.println();
        if(rule14!=null) rule14.printNode(number+1) ;
    }
}
