package Lexical;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main (String[] Args){
        LexicalAnalyzer la = new LexicalAnalyzer();
        Queue<Token> tokens = la.Lexical();
        for (Token token : tokens) {
            System.out.println(token.type+": "+token.value+"\t"+token.startIndex);
        }
    }
}
