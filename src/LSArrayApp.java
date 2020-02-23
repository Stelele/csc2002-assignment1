public class LSArrayApp
{
    public static void main(String[] args)
    {
        String fileLocation = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
        
        LSArray arrayData = new LSArray(fileLocation);
        
        arrayData.printAreas("20","11","06");
        
                
    }
}