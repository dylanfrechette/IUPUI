public class BST // binary search tree
{
    //create TreeNode class
    private class TreeNode
    {
        Comparable data;
        TreeNode left;
        TreeNode right;
    }
    TreeNode root;
    //create new empty BST
    public BST()
    {
        root=null;
    }
    //empty BST, shouldn't need
    public void emptyTree()
    {
        root=null;
    }
    //insert data into tree
    public void insert(Comparable x)
    {
        root=inserthelp(root, x);
    }
    //extra function called to help in inserting
    private Node insertHelp(TreeNode r, Comparable x)
    {
        if(r==null)
        {
            TreeNode newNode=new TreeNode();
            newNode.data=x;
            newNode.left=newNode.right=null;
            return newNode;
        }
        if(x.compareTo(r.data)<0)
        {
            r.left=insertHelp(r.left,x);
        }
        else
        {
            r.right=insertHelp(r.right,x);
        }
    }
    //search for a value in tree, don't think I'll need, but just in case
    public Comparable search(Comparable x)
    {
        return searchHelp(root, x);
    }
    //function to assist in search
    private Comparable searchHelp(TreeNode r, Comparable x)
    {
        if(r==null) return null;
        if(x.compareTo(r.data)==0) return r.data;
        if(x.compareTo(r.data)<0) return searchHelp(r.left,x);
        else return searchHelp(r.right,x);
    }
    //run an inorder traversal to printout values
    public void inOrder(TreeNode x) {
        if (x != null) {
            inOrder(x.left);
            // Visit the node by Printing the node data
            System.out.printf("%d ", x.data);
            inOrder(x.right);
        }
    }
}