import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    static boolean isMatched(HashMap<Integer, Integer> matched_list, Integer index){
        for (Integer i : matched_list.keySet()) {
            if(index >= i && index <= matched_list.get(i)){
                return true;
            }
        }
        return false;
    }

    static void sort(ArrayList<Token> tokens){
        // sort tokens with respect to start_index
    }
    public static void main (String[] Args){
        String data = null; // load data here
        try {
            data = LoadFile.readFileAsString("Test.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, String> tokenTypes = null; // load token_types here
        try {
            tokenTypes = LoadTokenTypes.readTokenTypesFromFile("Token_Types.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Token> tokens=new ArrayList();
        HashMap<Integer, Integer> matchedTokensIndexes = new HashMap<Integer, Integer>();
        Pattern pattern;
        Matcher matcher;
        for (String i : tokenTypes.keySet()) {
            pattern = Pattern.compile(tokenTypes.get(i));
            matcher = pattern.matcher(data);
            while (matcher.find())
            {
                Token token = new Token(i, matcher.group(), matcher.start());
                if(!isMatched(matchedTokensIndexes, matcher.start())){
                    tokens.add(token);
                    matchedTokensIndexes.put(matcher.start(), matcher.end());
                }
            }
        }
        sort(tokens); // sort tokens w.r.t start_index
        for (int i=0;i<tokens.size();i++){
            System.out.println(tokens.get(i).type+": "+tokens.get(i).value+"\t"+tokens.get(i).startIndex);
        }
    }
}
