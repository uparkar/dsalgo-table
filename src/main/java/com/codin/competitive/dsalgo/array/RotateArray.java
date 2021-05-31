package com.codin.competitive.dsalgo.array;

import java.util.Arrays;

/**
 * Array rotation k times
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        //                 1 2 3 4 5 6 7
        // left rotation = 4 5 6 7 1 2 3  => 3 2 1 7 6 5 4
        // rigt rotation = 5 6 7 1 2 3 4  => 4 3 2 1 7 6 5
        System.out.println("Original: "+ Arrays.toString(arr));
        rotate(arr,10,'B');
        System.out.println("Rotated: "+ Arrays.toString(arr));

    }

    private static void rotate(int[] arr, int noOfRotations, char direction) {
        if(noOfRotations > arr.length)
            noOfRotations = noOfRotations % arr.length;

        int left = 0, right = noOfRotations-1;
        reverseArray(arr,left, right);

        left = noOfRotations; right=arr.length-1;
        reverseArray(arr,left, right);

        left = 0; right = arr.length-1;
        reverseArray(arr, left, right);
    }

    private static void reverseArray(int[] arr, int left, int right) {
        while(left<right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] =temp;

            left++; right--;
        }
    }
}
