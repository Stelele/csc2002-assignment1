public class LSBSTree
{
    private LSBSTreeNode root;
    private int comparisons;
    
    public LSBSTree(String fileName)
    {
        comparisons = 0;
        
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
    
    public void add(LSBSTreeNode node)
    {
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
}












