/**
 *The runner class that runs the program with an array datastructure
 * */
public class LSArrayApp
{
    /**
     *@param args takes at most 4 arguments in the format of 'stage day time fileLocation'. Note fileLocation is optional and no arguments can also be given
     * */
    public static void main(String[] args)
    {
	
	String fileLocation = "";
	if(args.length == 4)
	{	
		fileLocation = args[3];
	}
	else
	{
		fileLocation = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
	
	}
        
        LSArray arrayData = new LSArray(fileLocation);
        
        if(args.length >= 3)
        {
        	int comparisons =    arrayData.printAreas(args[0], args[1], args[2]);
		System.out.println("Carried out " + Integer.toString(comparisons) + " comparisons");
		System.out.println("Carried out " + Integer.toString(arrayData.getInsertionComparisons()) + " insertion comparisons");
		System.out.println("Total size is " + Integer.toString(arrayData.getSize()));

        }
        else if(args.length == 0)
        {
            arrayData.printAllAreas();

        }
        else
        {
            System.err.println("Usage: \njava LSApp \"Prints all the areas\"\njava LSAPP [stage] [day] [startTime] [fileLocation] \"Prints areas for the given condition. fileLocation is optional\""); 

        }
                       
    }
}
