public class LSBSTree
{
    private LSBSTreeNode root;
    private int comparisons;
    private int insertionComparisons;

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
   
    public int getInsertionComparisons()
    {
	return insertionComparisons;
    }

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
    
    public void visit(LSBSTreeNode node)
    {
        System.out.println(node.toString());
    }
    
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
    
    public void preOrder(LSBSTreeNode node)
    {
        if(node != null)
        {
            visit(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
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
    
    public void inOrder(LSBSTreeNode node)
    {
        if(node != null)
        {
            inOrder(node.getLeft());
            visit(node);
            inOrder(node.getRight());
        }
    }
    
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
    
    public void postOrder(LSBSTreeNode node)
    {
        if(node != null)
        {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            visit(node);
            
        }
    }

    public int getHeight()
    {
	return getHeight(root);
    }

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

    public int printAreas(String stage, String day, String startTime)
    {
	String searchKey = stage + "_" + day + "_" + startTime;
	
	comparisons = 0;
	printAreas(searchKey, root);

	return comparisons;
    }

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

    public int getSize()
    {
	return getSize(root);
    }

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

    public void printAllAreas()
    {
	inOrder();
    }
	
}












