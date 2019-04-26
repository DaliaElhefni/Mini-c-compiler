package Parser;

import Lexical.LexicalAnalyzer;
import Lexical.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Parser {
    private Queue<Token> tokens;

    public Parser(){
        tokens = getTokens();
    }

    private Queue<Token>getTokens(){
        LexicalAnalyzer la = new LexicalAnalyzer();
        return la.Lexical();
    }

    private Rule1 parse(){
        return rule1Fun();
    }

    private Rule1 rule1Fun(){
        StringBuilder error= new StringBuilder();
        Rule3 rule3 = rule3Fun(error);
        if(!error.toString().equals("")){
            System.out.println(error);
            return null;
        }
        if (rule3==null){
            System.out.println("There is nothing to parse!");
            return null;
        }
        Rule2 rule2 = rule2Fun(error);
        if (!error.toString().equals("")){
            System.out.println(error);
            return null;
        }
        return new Rule1(rule3,rule2);
    }

    private Rule2 rule2Fun(StringBuilder error){
        Rule3 rule3 = rule3Fun(error);
        if (rule3 == null){
            return null;
        }
        Rule2 rule2 = rule2Fun(error);
        if (!error.toString().equals("")){
            return null;
        }
        return new Rule2(rule3,rule2);
    }

    private Rule3 rule3Fun(StringBuilder error){
        StringBuilder path1Error =  new StringBuilder(), path2Error = new StringBuilder();
        Token type = rule27Fun(error);
        if (type == null){
            return null;
        }
        Token identifier = IDENT(error);
        if (identifier == null){
            return null;
        }
        Rule4 rule4 = rule4Fun(path1Error, type, identifier);
        if(rule4 == null){
            Rule5 rule5 = rule5Fun(path2Error, type, identifier);
            if (path2Error.toString().contains("(")){
                error.delete(0, error.length());
                error.append(path1Error.toString());
                return null;
            }
            else if(!path2Error.toString().equals("")){
                error.delete(0, error.length());
                error.append(path2Error.toString());
                return null;
            }
            return new Rule3(rule5);
        }
        return new Rule3(rule4);
    }

    private Rule4 rule4Fun(StringBuilder error, Token type, Token identifier){
        Rule4 rule28 = rule28Fun(error);
        if (rule28 == null){
            return null;
        }
        return new Rule4(type, identifier, rule28);
    }

    private Rule5 rule5Fun(StringBuilder error, Token type, Token identifier){
        Token rightRoundBracket = rightRoundBracket(error);
        if(rightRoundBracket == null){
            return null;
        }
        Rule6 rule6 = rule6Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        Token leftRoundBracket = leftRoundBracket(error);
        if(leftRoundBracket == null){
            return null;
        }
        Rule14 rule14 = rule14Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule5(type, identifier, rightRoundBracket, rule6, leftRoundBracket, rule14);
    }

    private Rule6 rule6Fun(StringBuilder error){
        Rule7 rule7 = rule7Fun(error);
        if(rule7 == null){
            return null;
        }
        return new Rule6(rule7);
    }

    private Rule7 rule7Fun(StringBuilder error){
        Rule9 rule9 = rule9Fun(error);
        if(rule9 == null){
            return null;
        }
        Rule8 rule8 = rule8Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule7(rule9, rule8);
    }

    private Rule8 rule8Fun(StringBuilder error){
        Token comma = tokens.peek();
        if(comma == null || !comma.type.equals("<COMMA>")){
            return null;
        }
        tokens.poll();
        Rule9 rule9 = rule9Fun(error);
        if (rule9 == null){
            return null;
        }
        Rule8 rule8 = rule8Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule8(comma, rule9, rule8);
    }

    private Rule9 rule9Fun(StringBuilder error){
        Token type = rule27Fun(error);
        if (type == null){
            error.delete(0, error.length());
            return null;
        }
        Token identifier = IDENT(error);
        if (identifier == null){
            return null;
        }
        Rule9 rule29 = rule29Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        if(rule29 != null){
            return new Rule9(type, identifier, rule29.rightSquareBracket, rule29.leftSquareBracket);
        }
        return new Rule9(type, identifier);
    }

    private Rule10 rule10Fun(StringBuilder error){
        Rule11 rule11 = rule11Fun(error);
        if (rule11 == null){
            return null;
        }
        Rule10 rule10 = rule10Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule10(rule11, rule10);
    }

    private Rule11 rule11Fun(StringBuilder error){
        Rule12 rule12 = rule12Fun(error);
        if(rule12 != null){
            return new Rule11(rule12);
        }
        if(!error.toString().equals("")){
            return null;
        }
        Rule14 rule14 = rule14Fun(error);
        if(error.toString().contains("{")){
            error.delete(0,error.length());
        }
        if(rule14 != null){
            return new Rule11(rule14);
        }
        if(!error.toString().equals("")){
            return null;
        }
        Rule16 rule16 = rule16Fun(error);
        if(rule16 != null){
            return new Rule11(rule16);
        }
        if(!error.toString().equals("")){
            return null;
        }
        Rule13 rule13 = rule13Fun(error);
        if(rule13 != null){
            return new Rule11(rule13);
        }
        if(!error.toString().equals("")){
            return null;
        }
        Rule18 rule18 = rule18Fun(error);
        if(rule18 != null){
            return new Rule11(rule18);
        }
        if(!error.toString().equals("")){
            return null;
        }
        return rule30Fun(error);
    }

    private Rule12 rule12Fun(StringBuilder error){
        Rule19 rule19 = rule19Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        Token token = tokens.peek();
        if(token != null && token.type.equals("<SEMICOLON>")){
            tokens.poll();
        }
        else if (rule19 != null) {                          // must return an error if rule19 exists
            error.append("Syntax Error: Expected ; ");
            return null;
        }
        else {                                              // won't return an error to explore other paths
            return null;
        }
        return new Rule12(rule19, token);
    }

    private Rule13 rule13Fun(StringBuilder error){
        Token whileWord = tokens.peek();
        if(whileWord == null || !whileWord.type.equals("<WHILE>")){
            return null;
        }
        tokens.poll();
        Token rightRoundB = rightRoundBracket(error);
        if(rightRoundB == null){
            return null;
        }
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        Token leftRoundB = leftRoundBracket(error);
        if(leftRoundB == null){
            return null;
        }
        Rule11 rule11 = rule11Fun(error);
        if(rule11 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Statement Expected");
            }
            return null;
        }
        return new Rule13(whileWord, rightRoundB, rule19, leftRoundB, rule11);
    }

    private Rule14 rule14Fun(StringBuilder error){
        Token rightCurlyBracket = tokens.peek();
        if(rightCurlyBracket == null || !rightCurlyBracket.type.equals("<RIGHT_CURLY_B>")){
            error.append("Syntax Error: Expected { ");
            return null;
        }
        tokens.poll();
        Rule15 rule15 = rule15Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        Rule10 rule10 = rule10Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        Token leftCurlyBracket = tokens.peek();
        if(leftCurlyBracket == null || !leftCurlyBracket.type.equals("<LEFT_CURLY_B>")){
            error.append("Syntax Error: Expected } ");
            return null;
        }
        tokens.poll();
        return new Rule14(rightCurlyBracket, rule15, rule10, leftCurlyBracket);
    }

    private Rule15 rule15Fun(StringBuilder error){
        Token type = rule27Fun(error);
        if (type == null){
            if(error.toString().contains("Identifier Type")){
                error.delete(0, error.length());
            }
            return null;
        }
        Token identifier = IDENT(error);
        if (identifier == null){
            return null;
        }
        Rule4 rule4 = rule4Fun(error, type, identifier);
        if(rule4 ==  null){
            return null;
        }
        Rule15 rule15 = rule15Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule15(rule4, rule15);
    }

    private Rule16 rule16Fun(StringBuilder error){
        Token ifWord = tokens.peek();
        if(ifWord == null || !ifWord.type.equals("<IF>")){
            return null;
        }
        tokens.poll();
        Token rightRoundB = rightRoundBracket(error);
        if(rightRoundB == null){
            return null;
        }
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        Token leftRoundB = leftRoundBracket(error);
        if(leftRoundB == null){
            return null;
        }
        Rule11 rule11 = rule11Fun(error);
        if(rule11 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Statement Expected");
            }
            return null;
        }
        Rule17 rule17 = rule17un(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule16(ifWord, rightRoundB, rule19, leftRoundB, rule11, rule17);
    }

    private Rule17 rule17un(StringBuilder error){
        Token elseWord = tokens.peek();
        if(elseWord ==  null || !elseWord.type.equals("<ELSE>")){
            return null;
        }
        tokens.poll();
        Rule11 rule11 = rule11Fun(error);
        if(rule11 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Statement Expected");
            }
            return null;
        }
        return new Rule17(elseWord, rule11);
    }

    private Rule18 rule18Fun(StringBuilder error){
        Token returnWord = tokens.peek();
        if(returnWord == null || !returnWord.type.equals("<RETURN>")){
            return null;
        }
        tokens.poll();
        Rule12 rule12 = rule12Fun(error);
        if(rule12 ==  null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expected ; ");
            }
            return null;
        }
        return new Rule18(returnWord, rule12);
    }

    private Rule19 rule19Fun(StringBuilder error){
        Token token = tokens.peek();
        if(token == null){
            return null;
        }
        switch (token.type){
            case "<ID>":
                tokens.poll();
                return caseID(error, token);
            case "<not>":
            case "<MINUS>":
            case "<PLUS>":
                tokens.poll();
                return caseNotPlusMinus(error, token);
            case "<BOOL_LIT>":
            case "<INTEGRAL_LITERAL>":
            case "<FLOAT_LITERAL>":
                tokens.poll();
                Rule20 rule20 = rule20Fun(error);
                if(!error.toString().equals("")){
                    return null;
                }
                return new Rule19(token, rule20);
            case "<NEW>":
                tokens.poll();
                return caseNew(error, token);
        }
        return null;
    }

    private Rule20 rule20Fun(StringBuilder error){
        Rule22 rule22 = rule22Fun(error);
        if(rule22 == null){
            return null;
        }
        Rule20 rule20 = rule20Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule20(rule22, rule20);
    }

    private Rule21 rule21Fun(StringBuilder error){
        Token token = tokens.peek();
        if(token == null){
            return null;
        }
        switch (token.type){
            case "<ASSIGN_OPERATOR>":
                tokens.poll();
                return caseAssignOperator(error, token);
            case "<RIGHT_SQUARE_B>":
                tokens.poll();
                return caseRightSquareB(error, token);
            case "<RIGHT_ROUND_B>":
                tokens.poll();
                return caseRightRoundB(error, token);
            case "<dot>":
                tokens.poll();
                Token sizeWord = tokens.peek();
                if(sizeWord == null || !sizeWord.type.equals("<SIZE>")){
                    error.append("Syntax Error: Expected Token");
                    return null;
                }
                tokens.poll();
                return new Rule21(token,sizeWord);
        }
        return null;
    }

    private Rule22 rule22Fun(StringBuilder error){
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("<OR>", "<EQUAL>", "<NOT_EQUAL>", "<LESS_EQ>", "<LESSTHAN>",
                "<GREAT_EQ>", "<GREATERTHAN>", "<AND>", "<PLUS>", "<MINUS>", "<ASTERISK>", "<DIVIDE>", "<MOD>"));
        Token token = tokens.peek();
        if(token != null && temp.contains(token.type)){
            tokens.poll();
            Rule19 rule19 = rule19Fun(error);
            if(rule19 == null){
                if(error.toString().equals("")){
                    error.append("Syntax Error: Expression Expected");
                }
                return null;
            }
            return new Rule22(token, rule19);
        }
        return null;
    }

    private Rule23 rule23Fun(StringBuilder error){
        Rule19 rule19 = rule19Fun(error);
        if(rule19 ==  null){
            return null;
        }
        return new Rule23(rule19);
    }

    private Rule24 rule24Fun(StringBuilder error){
        Rule19 rule19 = rule19Fun(error);
        if(rule19== null){
            return null;
        }
        Rule25 rule25 = rule25Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule24(rule19, rule25);
    }

    private Rule25 rule25Fun(StringBuilder error){
        Token comma = tokens.peek();
        if(comma == null || !comma.type.equals("<COMMA>")){
            return null;
        }
        tokens.poll();
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        Rule25 rule25 = rule25Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule25(comma, rule19, rule25);
    }

    private Rule26 rule26Fun(StringBuilder error){
        Rule24 rule24 = rule24Fun(error);
        if (rule24 == null){
            return null;
        }
        return new Rule26(rule24);
    }

    private Token rule27Fun(StringBuilder error){
        Token type = tokens.peek();
        if (type != null){
            if(type.type.equals("<VOID>") || type.type.equals("<BOOL>") || type.type.equals("<INT>") || type.type.equals("<FLOAT>")){
                return tokens.poll();
            }
            error.append("Syntax Error: Expected Identifier Type");
        }
        return null;
    }

    private Rule4 rule28Fun(StringBuilder error){
        Token token = rightSquareBracket(error);
        Token token2= null , token3;
        error.delete(0, error.length());
        if (token != null) {
            token2 = leftSquareBracket(error);
            if (token2 == null) {
                return null;
            }
        }
        token3 = tokens.peek();
        if(token3 != null && token3.type.equals("<SEMICOLON>")){
            tokens.poll();
        }
        else {
            error.append("Syntax Error: Expected ; ");
            return null;
        }
        return new Rule4(token, token2, token3);
    }

    private Rule9 rule29Fun(StringBuilder error){
        Token token = rightSquareBracket(error);
        Token token2;
        error.delete(0, error.length());
        if (token != null) {
            token2 = leftSquareBracket(error);
            if (token2 == null) {
                return null;
            }
        }
        else {
            return null;
        }
        return new Rule9(null, null, token, token2);
    }

    private Rule11 rule30Fun(StringBuilder error){
        Token breakWord = tokens.peek();
        if(breakWord != null && breakWord.type.equals("<BREAK>")){
            tokens.poll();
            Token semicolon = tokens.peek();
            if(semicolon != null && semicolon.type.equals("<SEMICOLON>")){
                tokens.poll();
                return  new Rule11(breakWord, semicolon);
            }
            else {
                error.append("Syntax Error: Expected ;");
            }
        }
        return null;
    }

    private Token IDENT(StringBuilder error){
        Token identifier = tokens.peek();
        if (identifier != null &&identifier.type.equals("<ID>")) {
            return tokens.poll();
        }
        error.append("Syntax Error: Expected Identifier");
        return null;
    }

    private Token rightRoundBracket(StringBuilder error){
        Token rightRoundBracket = tokens.peek();
        if(rightRoundBracket != null && rightRoundBracket.type.equals("<RIGHT_ROUND_B>")){
            return tokens.poll();
        }
        error.append("Syntax Error: Expected ( ");
        return null;
    }

    private Token leftRoundBracket(StringBuilder error){
        Token leftRoundBracket = tokens.peek();
        if(leftRoundBracket != null && leftRoundBracket.type.equals("<LEFT_ROUND_B>")){
            return tokens.poll();
        }
        error.append("Syntax Error: Expected ) ");
        return null;
    }

    private Token rightSquareBracket(StringBuilder error){
        Token rightSquareBracket = tokens.peek();
        if(rightSquareBracket != null && rightSquareBracket.type.equals("<RIGHT_SQUARE_B>")){
            return tokens.poll();
        }
        error.append("Syntax Error: Expected [ ");
        return null;
    }

    private Token leftSquareBracket(StringBuilder error){
        Token leftSquareBracket = tokens.peek();
        if(leftSquareBracket != null && leftSquareBracket.type.equals("<LEFT_SQUARE_B>")){
            return tokens.poll();
        }
        error.append("Syntax Error: Expected ] ");
        return null;
    }

    private Rule19 caseID(StringBuilder error, Token token){
        Rule21 rule21 = rule21Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        Rule20 rule20 = rule20Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule19(token, rule21, rule20);
    }

    private Rule19 caseNotPlusMinus(StringBuilder error, Token token){
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        Rule20 rule20 = rule20Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule19(token, rule19, rule20);
    }

    private Rule19 caseNew(StringBuilder error, Token token){
        Token type = rule27Fun(error);
        if(type == null){
            error.delete(0, error.length()); // making sure that it will return with error even if the queue is empty
            error.append("Syntax Error: Expected Identifier Type");
            return null;
        }
        Token rightSquareB = rightSquareBracket(error);
        if(rightSquareB == null){
            return null;
        }
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        Token leftSquareB = leftSquareBracket(error);
        if(leftSquareB == null){
            return null;
        }
        Rule20 rule20 = rule20Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule19(token, type, rightSquareB, rule19, leftSquareB, rule20);
    }

    private Rule21 caseAssignOperator(StringBuilder error, Token token){
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        return new Rule21(token, rule19);
    }

    private Rule21 caseRightSquareB(StringBuilder error, Token token){
        Rule19 rule19 = rule19Fun(error);
        if(rule19 == null){
            if(error.toString().equals("")){
                error.append("Syntax Error: Expression Expected");
            }
            return null;
        }
        Token leftSquareB = leftSquareBracket(error);
        if(leftSquareB == null){
            return null;
        }
        Rule23 rule23 = rule23Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        return new Rule21(token, rule19, leftSquareB, rule23);
    }

    private Rule21 caseRightRoundB(StringBuilder error, Token token){
        Rule26 rule26 = rule26Fun(error);
        if(!error.toString().equals("")){
            return null;
        }
        Token leftRoundB = leftRoundBracket(error);
        if(leftRoundB == null){
            return null;
        }
        return new Rule21(token, rule26, leftRoundB);
    }

    public static void main(String[] args) {
        Parser p = new Parser();
//        for (Token token : p.tokens) {
//            System.out.println(token.type+": "+token.value+"\t"+token.startIndex);
//        }
        Rule1 root = p.parse();
        if(root != null){
            root.printNode(0);
        }
    }
}
