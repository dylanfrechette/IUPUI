import java.io.*;
import java.util.*;

public class BSTMain //extends BST
{
    public static void intoHash(HashMap<String, Integer> hm) throws FileNotFoundException, IOException
    {
        BufferedReader txtRead = new BufferedReader(new FileReader("test.txt"));
        // word you're presently reading
        String currentString = txtRead.readLine();
        // current line, starting at 1
        int currentLine = 1;
        //is giving line numbers properly, now need to format and push into tree
        while (currentString != null) 
        {
            String[] word = currentString.split(" ");
            for (String s : word) 
            {
                //Integer i = hm.get(s);
                hm.put(s, currentLine);
            }
            currentString = txtRead.readLine();
            currentLine++;
        }
        txtRead.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        BST BinaryTree=new BST();
        HashMap<String, Integer> txtFileLine = new HashMap<String, Integer>();
        intoHash(txtFileLine);
        //having issues here
        List<String> hmList=new ArrayList<String>(txtFileLine.keySet());
        for(String s: hmList)
        {
            BinaryTree.insert(s);
        }
        BinaryTree.printInorder(BinaryTree.root);
        //System.out.println(txtFileLine);        
    }
}