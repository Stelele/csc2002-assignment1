import java.nio.file.*;

public class ReadTextAsString
{
    public static String readFileAsString(String fileName) throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        
        return data;
    }
    
    public static void main(String[] args) throws Exception 
    { 
	String data = readFileAsString("/home/gift/Documents/CSC2001F/Assignment1/data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"); 
	System.out.println(data); 
    }
}