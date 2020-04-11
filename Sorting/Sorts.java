import java.io.*;
import java.util.*;
import java.math.*;

public class Sorts
{
    public static void merge(Comparable [] list)
	{
		mergehelp(list,0,list.length-1);
	}
		
	private static void mergehelp(Comparable [] list,
		int start, int stop)
	    {
			// base cases
			if(stop<=start) return; // size is 0 or 1
			if(start+1==stop) // size 2
			{
				if(list[start].compareTo(list[stop])>0)
					swap(list,start,stop);
				return;
			}
			// recursion
	    	int mid=(start+stop)/2;
		    mergehelp(list,start,mid);
		    mergehelp(list,mid+1,stop);
		    domerge(list,start,mid,stop);
		}
		
	private static void domerge(Comparable [] list,
		int start, int mid, int stop)
		{
	    	Comparable [] compareNums=new Comparable[stop-start+1];
			int left=start;
			int right=mid+1;
			for(int i=0; i<compareNums.length; i++)
			{
				// right is empty OR left is not empty and left is smaller
				if(right>stop || left<=mid && 
					list[left].compareTo(list[right])<=0)
					compareNums[i]=list[left++];
				else
					compareNums[i]=list[right++];
			}
			for(int i=0; i<compareNums.length; i++)
				list[start+i]=compareNums[i];
		}
}