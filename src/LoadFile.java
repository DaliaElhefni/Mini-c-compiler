import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadFile {
    public static String readFileAsString(String filePath)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        return data;
    }
}
