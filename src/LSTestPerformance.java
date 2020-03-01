class LSTestPerformance
{      
	public static void main(String[] args)
	{
		try
		{
			String fileLocation = "/home/gift/Documents/CSC2001F/Assignment1/input/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt";

			LSBSTree binTree = new LSBSTree(fileLocation);
			LSArray array = new LSArray(fileLocation);

			String data[] = LSHelper.readFileAsString(fileLocation).split("\n");

			int dataPoints = 10;

			int separation = (int)data.length / dataPoints;

			for(int i = 0 ; i < data.length; i += separation)
			{
				String key = data[i].split(" ",2)[0];
				String entry[] =key.split("_");

				System.out.println("For entry:" + key +"\tPosition: " + i + "\nAreas are:"); 

				int binTreeComparisons = binTree.printAreas(entry[0],entry[1],entry[2]);
				int arrayComparisons = array.printAreas(entry[0],entry[1],entry[2]);
				
				System.out.println("\nArray: " + arrayComparisons +"\tBinary Tree: " + binTreeComparisons+ "\n");
			}
		}
		catch(Exception e)
		{
			System.out.println("File not found");
		}
	}
}
