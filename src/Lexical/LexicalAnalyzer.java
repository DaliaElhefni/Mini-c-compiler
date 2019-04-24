package Lexical;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
    public LexicalAnalyzer(){}
    private String repeat(char character, Integer length){
        char[] chars = new char[length];
        Arrays.fill(chars, character);
        String substr = new String(chars);
        return substr;
    }

    private void sort(ArrayList<Token> tokens)
    {
        Collections.sort(tokens);
    }

    private ArrayList<Token> checkOverLappedTokens(ArrayList<Token> tokens){
        ArrayList<Token> newTokens = new ArrayList();
        for(int i=0;i<tokens.size();i++){
            boolean noOverlap = true;
            for(int j=0; j<tokens.size();j++){
                if(tokens.get(i).startIndex >= tokens.get(j).startIndex && tokens.get(i).startIndex <= tokens.get(j).endIndex
                        && !tokens.get(i).type.equals(tokens.get(j).type)){
                    noOverlap = false;
                }
            }
            if(!newTokens.contains(tokens.get(i)) && noOverlap==true){
                newTokens.add(tokens.get(i));
            }
        }
        return newTokens;
    }
    private String removeMatchedTokens(ArrayList<Token> tokens, String data){
        for(int i=0;i<tokens.size();i++){
            String substr = repeat(' ',(tokens.get(i).endIndex - tokens.get(i).startIndex));
            String newData = data.substring(0, tokens.get(i).startIndex)+substr+data.substring(tokens.get(i).endIndex);
            data = newData;
        }
        return data;
    }

    public Queue<Token> Lexical(){
        String data = null; // load data here
        try {
            data = LoadFile.readFileAsString("Test.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<TokenTypes> tokenTypes = null; // load token_types here
        try {
            tokenTypes = LoadTokenTypes.readTokenTypesFromFile("Token_Types.txt");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<Token> tokens=new ArrayList();
        Pattern pattern;
        Matcher matcher;
        for (int i=0 ; i<3;i++)
        {
            pattern = Pattern.compile(tokenTypes.get(i).tokenExpression);
            matcher = pattern.matcher(data);
            while (matcher.find())
            {
                Token token = new Token(tokenTypes.get(i).tokenName, matcher.group(), matcher.start(), matcher.end());
                tokens.add(token);
            }
        }

        tokens = checkOverLappedTokens(tokens);

        data = removeMatchedTokens(tokens, data);

        for (int i=3 ; i<tokenTypes.size();i++)
        {
            pattern = Pattern.compile(tokenTypes.get(i).tokenExpression);
            matcher = pattern.matcher(data);
            while (matcher.find())
            {
                Token token = new Token(tokenTypes.get(i).tokenName, matcher.group(), matcher.start(), matcher.end());
                String substr = repeat(' ',(matcher.end() - matcher.start()));
                String newData = data.substring(0, matcher.start())+substr+data.substring(matcher.end());
                data = newData;
                tokens.add(token);
            }
        }
        String[] splited = data.split("\\s+");
        for (int i=1 ; i<splited.length ; i++)
        {
            String target="\\b"+splited[i]+"\\b";
            pattern = Pattern.compile(target);
            matcher = pattern.matcher(data);
            if(matcher.find())
            {
                Token token = new Token("<ERROR>", matcher.group(), matcher.start(), matcher.end());
                String substr = repeat(' ',(matcher.end() - matcher.start()));
                String newData = data.substring(0, matcher.start())+substr+data.substring(matcher.end());
                data = newData;
                tokens.add(token);
            }
        }
        sort(tokens); // sort tokens w.r.t start_index
        for (int i =0;i<tokens.size();i++){
            System.out.println(tokens.get(i).type+": "+tokens.get(i).value+"\t"+tokens.get(i).startIndex);
        }
        System.out.println();
        System.out.println();
        Queue<Token> tokensQueue = new LinkedList<>();
        tokensQueue.addAll(tokens);
        return tokensQueue;
    }

}
