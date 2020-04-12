import java.io.*;
import java.util.*;

public class SortMain extends Sorts
{
    //random number generator for array values 
    public static void randomNumbers(Integer[] arr)
    {
        for(int i=0;i<arr.length;i++)
            arr[i]=1+(int)(Math.random()*20000);
    }
    // public static void printArray(Integer[] arr) 
    // {
    //     if (arr.length <= 100) 
    //     {
    //         for (int i = 0; i < arr.length; i++) 
    //         {
    //             System.out.println(arr[i]);
    //         }
    //     }
    // }
    public static void main(String [] args)
    {
        int[] listSizes={100, 500, 1000, 2000, 5000, 8000, 10000};
        for(int i=0;i<listSizes.length;i++)
        {
            //declaring variables to get times of each method
            int quickStart, quickStop, quickTime, insertionStart, insertionStop
            ,insertionTime, mergeStart, mergeStop, mergeTime, heapStart, heapStop, heapTime
            ,sortQuickStart, sortQuickStop, sortQuickTime, sortInsertionStart, sortInsertionStop
            ,sortInsertionTime, sortMergeStart, sortMergeStop, sortMergeTime, sortHeapStart, sortHeapStop, sortHeapTime;
            quickStart=quickStop=quickTime=insertionStart=insertionStop=insertionTime=
            mergeStart=mergeStop=mergeTime=heapStart=heapStop=heapTime=
            sortQuickStart=sortQuickStop=sortQuickTime=sortInsertionStart=sortInsertionStop=sortInsertionTime=
            sortMergeStart=sortMergeStop=sortMergeTime=sortHeapStart=sortHeapStop=sortHeapTime=0;
            int arrLen=listSizes[i];
            Integer[] sortingArr= new Integer[arrLen];
            randomNumbers(sortingArr);
            //create a copy array to reset unsorted after each sort
            Integer[] storedArr = new Integer[arrLen];
            for (int itr = 0; itr < storedArr.length; itr++) 
                storedArr[itr] = sortingArr[itr];
            //run quicksort and record time
            quickStart=(int)System.currentTimeMillis();
            quick(sortingArr);
            quickStop=(int)System.currentTimeMillis();
            quickTime=quickStop-quickStart;
            System.out.println("Time for "+ listSizes[i]+" values for unsorted quicksort: "+quickTime + "\n");
            sortQuickStart = (int) System.currentTimeMillis();
            quick(sortingArr);
            sortQuickStop = (int) System.currentTimeMillis();
            sortQuickTime = sortQuickStop - sortQuickStart;
            System.out.println("Time for " + listSizes[i] + " values for sorted quicksort: " + sortQuickTime + "\n");
            //reset sorted array
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
            //run insertion sort and record time
            insertionStart=(int)System.currentTimeMillis();
            insertion(sortingArr);
            insertionStop=(int)System.currentTimeMillis();
            insertionTime=insertionStop-insertionStart;
            System.out.println("Time for " + listSizes[i] + " values for unsorted insertion sort: " + insertionTime + "\n");
            sortInsertionStart = (int) System.currentTimeMillis();
            insertion(sortingArr);
            sortInsertionStop = (int) System.currentTimeMillis();
            sortInsertionTime = sortInsertionStop - sortInsertionStart;
            System.out.println("Time for " + listSizes[i] + " values for sorted insertion sort: " + sortInsertionTime + "\n");
            // reset sorted array
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
            //run heapsort and record time
            heapStart=(int)System.currentTimeMillis();
            heapSort(sortingArr);
            heapStop=(int)System.currentTimeMillis();
            heapTime=heapStop-heapStart;
            System.out.println("Time for " + listSizes[i] + " values for unsorted heapsort: " + heapTime+ "\n");
            sortHeapStart = (int) System.currentTimeMillis();
            heapSort(sortingArr);
            sortHeapStop = (int) System.currentTimeMillis();
            sortHeapTime = sortHeapStop - sortHeapStart;
            System.out.println("Time for " + listSizes[i] + " values for sorted heapsort: " + sortHeapTime + "\n");
            // reset sorted array
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
            //run mergesort and record time
            mergeStart=(int)System.currentTimeMillis();
            merge(sortingArr);
            mergeStop=(int)System.currentTimeMillis();
            mergeTime=mergeStop-mergeStart;
            System.out.println("Time for " + listSizes[i] + " values for unsorted mergesort: " + mergeTime+"\n");
            sortMergeStart = (int) System.currentTimeMillis();
            merge(sortingArr);
            sortMergeStop = (int) System.currentTimeMillis();
            sortMergeTime = sortMergeStop - sortMergeStart;
            System.out.println("Time for " + listSizes[i] + " values for sorted mergesort: " + sortMergeTime + "\n");
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
        }
    }
}