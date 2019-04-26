package Parser;

import Lexical.Token;

//var_decl                     -> type_spec IDENT var_decl_dash
//type_spec                    -> VOID | BOOL | INT | FLOAT
//var_decl_dash                -> ; | [] ;
public class Rule4 implements Node {
    Token type;
    Token identifier;
    Token semiColon;
    Token rightSquareBracket;
    Token leftSquareBracket;


    public Rule4(Token type, Token identifier, Rule4 rule4) {
        this.type = type;
        this.identifier = identifier;
        if(rule4 != null){
            this.semiColon = rule4.semiColon;
            this.rightSquareBracket = rule4.rightSquareBracket;
            this.leftSquareBracket = rule4.leftSquareBracket;
        }
    }

    public Rule4(Token rightSquareBracket, Token leftSquareBracket, Token semiColon) {
        this.type = null;
        this.identifier = null;
        this.rightSquareBracket = rightSquareBracket;
        this.leftSquareBracket = leftSquareBracket;
        this.semiColon = semiColon;
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
        System.out.println(tabs + "Rule 4: var_decl -> type_spec IDENT var_decl_dash");
        System.out.println();
        if(type!=null) System.out.println(getTabs(number+1)+ "Rule 27(type_spec): "+type.type +" = "+ type.value);
        if(identifier!=null) System.out.println(getTabs(number+1)+ "Terminal (IDENT): "+identifier.type +" = "+ identifier.value);
        if(rightSquareBracket!=null) System.out.println(getTabs(number+1)+ "Rule 28 (var_decl_dash): "+rightSquareBracket.type +" = "+ rightSquareBracket.value);
        if(leftSquareBracket!=null) System.out.println(getTabs(number+1)+ "Rule 28 (var_decl_dash): "+leftSquareBracket.type +" = "+ leftSquareBracket.value);
        if(semiColon!=null) System.out.println(getTabs(number+1)+ "Rule 28 (var_decl_dash): "+semiColon.type +" = "+ semiColon.value);
    }
}
