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
            ,insertionTime, mergeStart, mergeStop, mergeTime, heapStart, heapStop, heapTime;
            quickStart=quickStop=quickTime=insertionStart=insertionStop=insertionTime=
            mergeStart=mergeStop=mergeTime=heapStart=heapStop=heapTime=0;
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
            System.out.println("Time for "+ listSizes[i]+" values for quicksort: "+quickTime);
            //reset sorted array
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
            //run insertion sort and record time
            insertionStart=(int)System.currentTimeMillis();
            insertion(sortingArr);
            insertionStop=(int)System.currentTimeMillis();
            insertionTime=insertionStop-insertionStart;
            System.out.println("Time for " + listSizes[i] + " values for insertion sort: " + insertionTime);
            // reset sorted array
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
            //run heapsort and record time
            heapStart=(int)System.currentTimeMillis();
            heapSort(sortingArr);
            heapStop=(int)System.currentTimeMillis();
            heapTime=heapStop-heapStart;
            System.out.println("Time for " + listSizes[i] + " values for heapsort: " + heapTime);
            // reset sorted array
            for (int itr = 0; itr < storedArr.length; itr++)
                sortingArr[itr] = storedArr[itr];
            //run mergesort and record time
            mergeStart=(int)System.currentTimeMillis();
            merge(sortingArr);
            mergeStop=(int)System.currentTimeMillis();
            mergeTime=mergeStop-mergeStart;
            System.out.println("Time for " + listSizes[i] + " values for mergesort: " + mergeTime);
        }
    }
}