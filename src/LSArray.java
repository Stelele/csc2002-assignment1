public class LSArray
{
    private LSData[] lsData;
    
    
    public LSArray(String srcFileLocation)
    {
        string lsData[] = ReadTextAsString.readFileAsString(srcFileLocation).split("\n");
        
        lsData = new LSData [lsData.length];
        
        
                    
    }
}