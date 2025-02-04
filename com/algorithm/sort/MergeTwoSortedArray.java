package com.algorithm.sort;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int a[] = {1,3,4};
        int b[] = {2,3,4};
        int c[] = new int[a.length+b.length];

        int i=0,j =0, k=0;

        while(i<a.length && j<b.length){
            if(a[i]<b[i]){
                c[k++] = a[i];
                i++;
            } else {
                c[k++] = b[j];
                j++;
            }
        }

        System.out.println(Arrays.toString(c));

        //String.join(",", Arrays.stream(c).map(x -> (char)x).toArray()); // charcter required  int
    }
}
