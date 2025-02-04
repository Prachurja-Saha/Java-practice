package com.algorithm.sort;

/**
 *  Divide and Conquer algorithm
 */
public class MergerSort {

    /*
    *   Here’s a step-by-step explanation of how merge sort works:
        Divide: Divide the list or array recursively into two halves until it can no more be divided.
        Conquer: Each subarray is sorted individually using the merge sort algorithm.
        Merge: The sorted subarrays are merged back together in sorted order.
               The process continues until all elements from both subarrays have been merged.
    * */
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int middlePoint = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, middlePoint); // -> arr = same , l = 0, r --> 5,2,1   middle point -> 2,1,0
            sort(arr, middlePoint + 1, r); // arr = same, l = (0+1), r -> 1, (1<1)= false -> back mp=0, r =1, l=0
                                             // 1st call merge(arr, 0, 0,1)

            // Merge the sorted halves
            merge(arr, l, middlePoint, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
