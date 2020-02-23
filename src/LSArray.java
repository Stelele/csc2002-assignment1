public class LSArray
{
    private LSData lsData[];
        
    public LSArray(String srcFileLocation)
    {
        try
        {
            String fileData[] = LSHelper.readFileAsString(srcFileLocation).split("\n");
        
            lsData = new LSData[fileData.length];
            
            for(int i = 0; i < fileData.length; i++)
            {
                String entryDetails[] = fileData[i].split(" ",2);
                
                lsData[i] = new LSData<String>(entryDetails[0], entryDetails[1]);
            }
        }
        catch(Exception e)
        {
            lsData = null;
        }
        
                    
    }
    
    public void printAreas(String stage, String day, String startTime)
    {
        String searchKey = stage + "_" + day + "_" + startTime;
        boolean foundArea = false;
        
        for(int i = 0; i < lsData.length; i++)
        {
            if(searchKey.equals(lsData[i].getArea()))
            {
                System.out.println(lsData[i].getRegions());
                foundArea = true;
                break;
            }
        }
        
        if (!foundArea)
            System.out.println("Areas not found");
    }
    
    public void printAllAreas()
    {
        for(int i =0; i < lsData.length; i++)
        {
            System.out.println(lsData[i].toString());
        }
    }
    
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}