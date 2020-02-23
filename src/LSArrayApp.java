public class LSArrayApp
{
    public static void main(String[] args)
    {
        String fileLocation = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
        
        LSArray arrayData = new LSArray(fileLocation);
        
        if(args.length == 3)
        {
            arrayData.printAreas(args[0], args[1], args[2]);
        }
        else if(args.length == 0)
        {
            arrayData.printAllAreas();
        }
        else
        {
            System.err.println("Usage: \njava LSApp \"Prints all the areas\"\njava LSAPP [stage] [day] [startTime] \"Prints areas for the given condition\""); 
        }
                       
    }
}