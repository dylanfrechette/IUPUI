import java.io.*;
import java.util.*;

public class BST
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
    //insert data into tree
    public void insert(Comparable x)
    {
        root=insertHelp(root, x);
    }
    //extra function called to help in inserting
    private TreeNode insertHelp(TreeNode r, Comparable x)
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
            return r;
        }
        else
        {
            r.right=insertHelp(r.right,x);
            return r;
        }
    }
    //run an inorder traversal to printout values
    public void printInorder(TreeNode x) 
    { 
        if (x == null) 
            return; 
        /*recur on left child */
        printInorder(x.left);   
        /*print the data of node */
        System.out.print(x.data + "\n"); 
        /*recur on right child */
        printInorder(x.right); 
    } 
}