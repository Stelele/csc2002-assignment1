/**
 *class that represents the Binary Search Tree Data Stracture
 * */
public class LSBSTree
{
    private LSBSTreeNode root;
    private int comparisons;
    private int insertionComparisons;

    /**
     *@param fileName <code>String</code> represents location of file containing data to be loaded into data stracture
     *@see #add(LSBSTreeNode)
     * */
    public LSBSTree(String fileName)
    {
        comparisons = 0;
        insertionComparisons = 0;     
        try
        {        
            String data[] = LSHelper.readFileAsString(fileName).split("\n");
            
            for(int i = 0; i < data.length; i++)
            {
                String entry[] = data[i].split(" ",2);
                
                LSBSTreeNode node = new LSBSTreeNode(entry[0], entry[1]);
                
                add(node);
                
            }
        }
        catch(Exception e)
        {
            root = null;
        }        
    }
   
    /**
     *@return insertionComparisons <code>int</code> represents total number of insertion comparisons carried out to add dataset
     * */
    public int getInsertionComparisons()
    {
	return insertionComparisons;
    }

    /**
     *function to add new node starting at the root
     *@param node <code>LSBSTreeNode</code> represents a new tree node to be added to data stratucture
     * */
    public void add(LSBSTreeNode node)
    {
	insertionComparisons++;
        if(root == null)
        {
            root = node;
        }
        else
        {
            add(node, root);
        }
    }
    
    /**
     * function to add new node starting from specified node
     * @param node <code>LSBSTreeNode</code> represents node branch to be added to data stratucure
     * @param root <code>LSBSTreeNode</code> represents parent node to which new node is to be appended to
     * */
    public void add(LSBSTreeNode node,LSBSTreeNode root)
    {
	insertionComparisons++;
        if(root.compareTo(node) <= 0)
        {
            if(root.getLeft() == null)
            {
                root.setLeft(node);
            }
            else
            {
                add(node, root.getLeft());
            }
        }
        else
        {
            if(root.getRight() == null)
            {
                root.setRight(node);
            }
            else
            {
                add(node, root.getRight());
            }
        }
    }
    
    /**
     *function that performs a certain operation at every node by default prints contents of node
     * */
    public void visit(LSBSTreeNode node)
    {
        System.out.println(node.toString());
    }
    
    /**
     * function that performs a preOrder traversal from root
     * */
    public void preOrder()
    {
        if(root == null)
        {
            System.out.println("No entries");
        }
        else
        {
            preOrder(root);
        }
    }
    
    /**
     * function that performs a preOrder traversal from specified node
     * @param node <code>LSBSTreeNode</code> represents node to begin from 
     * */
    public void preOrder(LSBSTreeNode node)
    {
        if(node != null)
        {
            visit(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    /**
     * function that performs an inOrder traversal from the root node
     * */
    public void inOrder()
    {
        if(root == null)
        {
            System.out.println("No entries");
        }
        else
        {
            inOrder(root);
        }
    }
    
    /**
     * function that performs an inOrder traversal from specified node
     * @param node <code>LSBSTreeNode</code> represents node to begin from
     * */
    public void inOrder(LSBSTreeNode node)
    {
        if(node != null)
        {
            inOrder(node.getLeft());
            visit(node);
            inOrder(node.getRight());
        }
    }
    
    /**
     * function that performs a postOrder traversal from root node
     * */
    public void postOrder()
    {
        if(root == null)
        {
            System.out.println("No entries");
        }
        else
        {
            postOrder(root);
        }
    }
    
    /**
     * function that performs a postOrder traversal from specified node
     * @param node <code>LSBSTreeNode</code> represents the node to begin from
     * */
    public void postOrder(LSBSTreeNode node)
    {
        if(node != null)
        {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            visit(node);
            
        }
    }

    /**
     * @return height <code>int</code> represents the maximum height of the entire tree data stratucure
     * */
    public int getHeight()
    {
	return getHeight(root);
    }

    /**
     * @param node <code>LSBSTreeNode</code> represents the node to begin from
     * @return height <code>int</code> represents the maximum height of the specified node
     * */
    public int getHeight(LSBSTreeNode node)
    {
	if(node == null)
	{
		return -1;
	}
	else
	{
		return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}
    }

    /**
     * function that finds the specified regions for given stage, day and startTime
     * @param stage <code>String</code> represents the specified Load Shedding Stage
     * @param day <code>String</code> represents the day of the month
     * @param startTime <code>String</code> represents the starting hour of the day
     * @return comparisons <code>int</code> represents the total number of comparisons carried out
     * */
    public int printAreas(String stage, String day, String startTime)
    {
	String searchKey = stage + "_" + day + "_" + startTime;
	
	comparisons = 0;
	printAreas(searchKey, root);

	return comparisons;
    }

    /**
     * function that looks for the specified region given a sepecific searchKey
     * @param searchKey <code>String</code> represents the key to look for in the form of 'stage_day_startTime'
     * @param node <code>LSBSTreeNode</code> represents node to start from
     * */
    public void printAreas(String searchKey, LSBSTreeNode node)
    {
 	comparisons++;
    	if(node == null)
	{
		System.out.println("Areas not found");
	}
	else
	{	
		comparisons++;
		int check = searchKey.compareTo((String)node.getData().getArea());
		if(check == 0)
		{
			System.out.println(node.getData().getRegions());
		}
		else if(check < 0)
		{
			printAreas(searchKey, node.getLeft());
		}
		else
		{
			printAreas(searchKey, node.getRight());
		}
	}
    }

    /**
     * @return size <code>int</code> represents total number of elements in the data stracture
     * */
    public int getSize()
    {
	return getSize(root);
    }

    /**
     * @param node <code>LSBSTreeNode</code> represents the node to start from
     * @return size <code>int</code> represents the total number of elements for the specified subTree
     * */
    public int getSize(LSBSTreeNode node)
    {
	if(node == null)
    	{
		return 0;
	}
	else
	{
		return 1 + getSize(node.getLeft()) + getSize(node.getRight()); 
	}
    }

    /**
     * function that prints all the elements in the tree via an inOrder traversal
     * */
    public void printAllAreas()
    {
	inOrder();
    }
	
}












