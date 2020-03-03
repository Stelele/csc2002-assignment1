/**
 *The class used to represent the array data stracture
 * */
public class LSArray
{
    private LSData lsData[];
    private int comparisons;
    private int insertionComparisons;

    /**
     *@param srcFileLocation The file location locating the data to be loaded into class instance
     * */
    public LSArray(String srcFileLocation)
    {
        comparisons = 0;
	insertionComparisons = 0;

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
    
    /**
     *@return size <code>int</code> representing total number of elements in array
     * */
    public int getSize()
    {
	return lsData.length;
    }

    /**
     *@return insertionComparisons <code>int</code> representing the total number of comparisons carried out when adding elements to array
     * */
    public int getInsertionComparisons()
    {
	return insertionComparisons;
    }

    /**
     *function that searches for the chosen regions give a specific key 
     *@param stage <code>String</code> representing Load Shedding scheduling stage
     *@param day <code>String</code> representing day of the month
     *@param startTime <code>String</code> representing the starting hour of the day
     *@return comparisons <code>int</code> representing the total comparisons carried out whilst searching for key value
     * */    
    public int printAreas(String stage, String day, String startTime)
    {
        String searchKey = stage + "_" + day + "_" + startTime;
        boolean foundArea = false;
        comparisons = 0;
        
        for(int i = 0; i < lsData.length; i++)
        {
            comparisons++;
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
    
	return comparisons;	
    }
    
    /**
     *function that prints all the regions in the array data stracture
     * */
    public void printAllAreas()
    {
        for(int i =0; i < lsData.length; i++)
        {
            System.out.println(lsData[i].toString());
        }
    }
}
