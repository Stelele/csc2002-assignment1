import java.nio.file.*;
import java.io.FileWriter;

public class LSHelper
{
    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        
        return data;
    }
    
    public static void writeToFile(String fileName,String text) throws Exception
    {
        FileWriter newFile = new FileWriter(fileName);
        newFile.write(text);
        newFile.close();
    }    
}