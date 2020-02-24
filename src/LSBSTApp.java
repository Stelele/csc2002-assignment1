public class LSBSTApp
{
    public static void main(String[] args)
    {
        String fileName = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";
        
        LSBSTree tree = new LSBSTree(fileName);
        
        tree.inOrder();
    }
}