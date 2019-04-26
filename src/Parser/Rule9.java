package Parser;

import Lexical.Token;

//param                        -> type_spec IDENT param_dash
//type_spec                    -> VOID | BOOL | INT | FLOAT
//param_dash                   -> [ ] | ε
public class Rule9 implements Node {
    Token type;
    Token identifier;
    Token rightSquareBracket;
    Token leftSquareBracket;

    public Rule9(Token type, Token identifier) {
        this.type = type;
        this.identifier = identifier;
        this.rightSquareBracket = null;
        this.leftSquareBracket = null;
    }

    public Rule9(Token type, Token identifier, Token rightSquareBracket, Token leftSquareBracket) {
        this.type = type;
        this.identifier = identifier;
        this.rightSquareBracket = rightSquareBracket;
        this.leftSquareBracket = leftSquareBracket;
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
        System.out.println(tabs + "Rule 9: param -> type_spec IDENT param_dash");
        System.out.println();
        if(type!=null) System.out.println(getTabs(number+1)+ "Rule 27 (type_spec): "+type.type +" = "+ type.value);
        if(identifier!=null) System.out.println(getTabs(number+1)+ "Terminal (IDENT): "+identifier.type +" = "+ identifier.value);
        if(rightSquareBracket!=null) System.out.println(getTabs(number+1)+ "Terminal ([): "+rightSquareBracket.type +" = "+ rightSquareBracket.value);
        if(leftSquareBracket!=null) System.out.println(getTabs(number+1)+ "Terminal (]): "+leftSquareBracket.type +" = "+ leftSquareBracket.value);
    }
}
