public class LSArray
{
    private LSData lsData[];
    private int comparisons;
        
    public LSArray(String srcFileLocation)
    {
        comparisons = 0;
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
        comparisons = 0;
        
        for(int i = 0; i < lsData.length; i++)
        {
            comparisons += 2;
            if(searchKey.equals(lsData[i].getArea()))
            {
                System.out.println(lsData[i].getRegions());
                foundArea = true;
                break;
            }
        }
        
        comparisons++;
        if (!foundArea)
            System.out.println("Areas not found");
            
        try
        {    
            LSHelper.writeToFile("../output/LSArray_printAreas_Comparisons.txt",Integer.toString(comparisons));
        }
        catch(Exception e)
        {
            System.err.println("Could not write number of comparisons to file");
        } 
       
    }
    
    public void printAllAreas()
    {
        for(int i =0; i < lsData.length; i++)
        {
            System.out.println(lsData[i].toString());
        }
    }
    
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
