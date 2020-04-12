import java.io.*;
import java.util.*;
import java.math.*;

public class Sorts
{
    //general swap method for use in sorts
    private static void swap(Object[] list, int x, int y)
    {
        Object tmp = list[x];
        list[x] = list[y];
        list[y] = tmp;
    }
    //method for insertion sort
    public static void insertion(Comparable[] list) 
    {
        for (int i = 1; i < list.length; i++) 
        {
            Comparable itemtoinsert = list[i];
            int j;
            for (j = i - 1; j >= 0 &&
            list[j].compareTo(itemtoinsert) > 0; j--) 
            {
                list[j + 1] = list[j];
            }
            list[j + 1] = itemtoinsert;
        }
    }
    //methods for quicksort
    public static void quick(Comparable[] list) 
    {
        quickhelp(list, 0, list.length - 1);
    }

    private static void quickhelp(Comparable[] list, int start, int stop) {
        // base cases
        if (stop <= start)
            return; // size is 0 or 1
        if (start + 1 == stop) // size 2
        {
            if (list[start].compareTo(list[stop]) > 0)
                swap(list, start, stop);
            return;
        }
        // recursive case
        int pivotpos = partition(list, start, stop);
        quickhelp(list, start, pivotpos - 1);
        quickhelp(list, pivotpos + 1, stop);
    }

    private static int partition(Comparable[] list, int start, int stop) 
    {
        Comparable pivot = list[stop];
        int fr = start;
        for (int i = start; i < stop; i++) 
        {
            if (list[i].compareTo(pivot) < 0) 
            {
                swap(list, i, fr);
                fr++;
            }
        }
        swap(list, fr, stop);
        return fr;
    }
    //methods for heapsort
    public static void heapSort(Integer[] arr) 
    {
        int arrayLen = arr.length;
        // Build heap
        for (int i = arrayLen / 2 - 1; i >= 0; i--)
            heapify(arr, arrayLen, i);
        // One by one extract elements from heap
        for (int i = arrayLen - 1; i > 0; i--) 
        {
            // Move current root to end of array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(Integer[] arr, int n, int root) 
    {
        //set largest to root
        int greatest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        // If left is larger than root
        if (left < n && arr[left] > arr[greatest])
            greatest = left;
        // If right is larger than current greatest
        if (right < n && arr[right] > arr[greatest])
            greatest = right;
        // If largest is not root
        if (greatest != root) {
            int swap = arr[root];
            arr[root] = arr[greatest];
            arr[greatest] = swap;
            // Recursively heapify sub-tree
            heapify(arr, n, greatest);
        }
    }
    //methods for mergesort
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