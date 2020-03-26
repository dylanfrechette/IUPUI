import java.io.*;
import java.util.*;

public class BSTMain //extends BST
{
    public static void intoHash(HashMap<String, String> hm) throws FileNotFoundException, IOException
    {
        BufferedReader txtRead = new BufferedReader(new FileReader("test.txt"));
        // word you're presently reading
        String currentString = txtRead.readLine();
        // current line, starting at 1
        int currentLine = 1;
        //split line into individual strings, then provide line number as current string
        while (currentString != null) 
        {
            String[] word = currentString.split(" ");
            for (String s : word) 
            {
                String line=Integer.toString(currentLine);
                //Integer i = hm.get(s);
                hm.put(s, line);
            }
            currentString = txtRead.readLine();
            currentLine++;
        }
        txtRead.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        BST BinaryTree=new BST();
        HashMap<String, String> txtFileLine = new HashMap<String, String>();
        //calls intoHash() to insert strings into hashmap
        intoHash(txtFileLine);
        //convert hashmap into an arraylist of strings to insert properly into tree
        List<String> hmList=new ArrayList<String>(txtFileLine.keySet());
        for(String s: hmList)
        {
            //concatenate value and key to one string
            s=s+" "+txtFileLine.get(s);
            //removes punctuation from each string (, . # etc)
            s=s.replaceAll("\\p{Punct}","");
            //checks if current string contains alphabetical characters,
            //if not, passes to next string
            if(s.matches(".*[a-z].*"))
            {
            BinaryTree.insert(s);
            }
            else continue;
        }
        //prints all nodes in InOrder form
        BinaryTree.printInorder(BinaryTree.root);      
    }
}