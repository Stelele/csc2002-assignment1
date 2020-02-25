public class LSBSTApp
{
    public static void main(String[] args)
    {
        String fileName = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
        
        LSBSTree tree = new LSBSTree(fileName);     

	if(args.length == 3)
        {
            tree.printAreas(args[0], args[1], args[2]);
        }
        else if(args.length == 0)
        {
            tree.inOrder();
        }
        else
        {
            System.err.println("Usage: \njava LSApp \"Prints all the areas\"\njava LSAPP [stage] [day] [startTime] \"Prints areas for the given condition\"");
        }

    }
}
