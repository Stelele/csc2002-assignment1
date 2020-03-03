/**
 *Runner class that uses Binary Search Tree Data Stracture
 * */
public class LSBSTApp
{
    /**
     *@param args accepts at most 4 arguments in the for of 'stage day time fileLocation'. Note fileLocation can be null and no arguments may be provided to print everything
     * */
    public static void main(String[] args)
    {
       
	String fileName = "";

   	if(args.length == 4)
	{
		fileName = args[3];
	}	
	else
	{
       		fileName = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";

	}

        LSBSTree tree = new LSBSTree(fileName);     

	if(args.length >= 3)
        {
		int comparisons = tree.printAreas(args[0], args[1], args[2]);
		System.out.println("Carried out " + Integer.toString(comparisons) + " comparisons");
		System.out.println("Carried out " + Integer.toString(tree.getInsertionComparisons()) + " total insertion comparisons");
		System.out.println("Total size is " + Integer.toString(tree.getSize()));
        }
        else if(args.length == 0)
        {
	    System.out.println("The height is " + Integer.toString(tree.getHeight()));
	    System.out.println("The size is " + Integer.toString(tree.getSize()));
            tree.printAllAreas();

        }
        else
        {
            System.err.println("Usage: \njava LSApp \"Prints all the areas\"\njava LSAPP [stage] [day] [startTime] [fileLocation] \"Prints areas for the given condition. Note fileLocation is optional\"");

        }

    }
}
