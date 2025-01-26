package com.algorithm.others;

import java.util.Arrays;
import java.util.Scanner;

public class SlidingWindow {

    /*
    * Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
    * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();

        System.out.println("Enter k");
        int k = sc.nextInt();
        int sum = 0;
        int max = 0;
        int[] arr = new int[n];

         for (int i = 0; i < n; i++) {
             arr[i] = sc.nextInt();
             if(i<k){
                 sum+=arr[i];
             }
         }

        System.out.println("Array is: " + Arrays.toString(arr));
        System.out.println("Sum is: " + sum);

         for(int i=k; i<n; i++){

             sum = sum + arr[i] - arr[i-k];
             if(sum>= max){
                 max = sum;
             }
         }

        System.out.println(sum);
    }
}
