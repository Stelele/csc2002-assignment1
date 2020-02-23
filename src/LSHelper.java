import java.nio.file.*;

public class LSHelper
{
    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        
        return data;
    }    
}