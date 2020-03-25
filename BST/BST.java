import java.io.*;
import java.util.*;

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
    public void printInorder(TreeNode x) 
    { 
        if (x == null) 
            return; 
  
        /* first recur on left child */
        printInorder(x.left); 
  
        /* then print the data of node */
        System.out.print(x.data + "\n"); 
  
        /* now recur on right child */
        printInorder(x.right); 
    } 
}