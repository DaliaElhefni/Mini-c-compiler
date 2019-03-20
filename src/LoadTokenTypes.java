import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadTokenTypes {
    public static ArrayList<TokenTypes> readTokenTypesFromFile(String filePath)throws Exception
    {
        ArrayList<TokenTypes> tokenTypes= new ArrayList<>();
        File file = new File(filePath);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine())
            {
                String nxtline = sc.nextLine();
                Scanner scanner = new Scanner(nxtline);
                TokenTypes NewTT=new TokenTypes(scanner.next(), scanner.next());
                tokenTypes.add(NewTT);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tokenTypes;
    }
}
