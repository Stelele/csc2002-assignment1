public class LSBSTreeNode
{
    private LSData lsData;
    private LSBSTreeNode left;
    private LSBSTreeNode right;
    
    public LSBSTreeNode(String area, String regions)
    {
        lsData = new LSData<String>(area, regions);
        left = null;
        right = null;
    }

    public LSBSTreeNode getLeft()
    {
        return left;
    } 
    
    public LSBSTreeNode getRight()
    {
        return right;
    }
    
    public void setLeft(LSBSTreeNode node)
    {
        left = node;
    }
    
    public void setRight(LSBSTreeNode node)
    {
        right = node;
    }
    
    public String toString()
    {
        return lsData.toString();
    }
    
    public int compareTo(LSBSTreeNode node)
    {
        return lsData.compareTo(node.lsData);
    }

    public LSData getData()
    {
	return lsData;
    }

    public void setData(LSData data)
    {
	lsData = data;
    }
}
