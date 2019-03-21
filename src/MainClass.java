
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static String repeat(char character, Integer length){
        char[] chars = new char[length];
        Arrays.fill(chars, character);
        String substr = new String(chars);
        return substr;
    }

    static void sort(ArrayList<Token> tokens)
    {
        Collections.sort(tokens);
    }

    public static void main (String[] Args){
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
        for (int i=0 ; i<tokenTypes.size();i++)
        {
            pattern = Pattern.compile(tokenTypes.get(i).tokenExpression);
            matcher = pattern.matcher(data);
            while (matcher.find())
            {
                Token token = new Token(tokenTypes.get(i).tokenName, matcher.group(), matcher.start());
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
                Token token = new Token("<ERROR>", matcher.group(), matcher.start());
                String substr = repeat(' ',(matcher.end() - matcher.start()));
                String newData = data.substring(0, matcher.start())+substr+data.substring(matcher.end());
                data = newData;
                tokens.add(token);
            }
        }
        sort(tokens); // sort tokens w.r.t start_index

        for (int i=0;i<tokens.size();i++){
            System.out.println(tokens.get(i).type+": "+tokens.get(i).value+"\t"+tokens.get(i).startIndex);
        }
    }
}
