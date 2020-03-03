/**
 * class that represents the tree node
 * */
public class LSBSTreeNode
{
    private LSData lsData;
    private LSBSTreeNode left;
    private LSBSTreeNode right;
    
    /**
     * @param area <code>String</code> represents the key field of the entry
     * @param regions <code>String</code> represents the areas receieving load shedding for the specified key
     * */
    public LSBSTreeNode(String area, String regions)
    {
        lsData = new LSData<String>(area, regions);
        left = null;
        right = null;
    }

    /**
     * @return left <code>LSBSTreeNode</code> represents the left child of the node
     * */
    public LSBSTreeNode getLeft()
    {
        return left;
    } 
    
    /**
     * @return right <code>LSBSTreeNode</code> represents the right child of the node
     * */
    public LSBSTreeNode getRight()
    {
        return right;
    }
    
    /**
     * @param node <code>LSBSTreeNode</code> represents new left node
     * */
    public void setLeft(LSBSTreeNode node)
    {
        left = node;
    }
    
    /**
     * @param node <code>LSBSTreeNode</code> represents new right node
     * */
    public void setRight(LSBSTreeNode node)
    {
        right = node;
    }
    
    /**
     * @return output <code>String</code> represents String representation of the node data
     * */
    public String toString()
    {
        return lsData.toString();
    }
    
    /**
     * function that implements custom compareTo method to compare only the data fields 
     * @param node <code>LSBSTreeNode</code> represents the node to be compared to with
     * @return value <code>int</code> result of comparison carried out
     * */
    public int compareTo(LSBSTreeNode node)
    {
        return lsData.compareTo(node.lsData);
    }

    /**
     * @return data <code>LSData</code> represents the data property stored in the node
     * */
    public LSData getData()
    {
	return lsData;
    }

    /**
     * @param data <code>LSData<code> represents the new data to be stored in the node
     * */
    public void setData(LSData data)
    {
	lsData = data;
    }
}
