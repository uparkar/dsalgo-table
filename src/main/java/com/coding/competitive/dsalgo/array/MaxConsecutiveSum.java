package com.coding.competitive.dsalgo.array;

import java.util.Arrays;

/**
 * Max sum of k consecutive elements - using Sliding Window
 */
public class MaxConsecutiveSum {

    public static void main(String[] args) {
        int[] arr = new int[] {3,5,-2,90,-4,18,4};

        System.out.println("Input: "+ Arrays.toString(arr));
        int maxSum = calcMaxConsSum(arr,3);
        System.out.println("Max 3 consecutive sum = "+maxSum);
        maxSum = calcMaxConsSum(arr,6);
        System.out.println("Max 6 consecutive sum = "+maxSum);
        maxSum = calcMaxConsSum(arr,7);
        System.out.println("Max 7 consecutive sum = "+maxSum);
        maxSum = calcMaxConsSum(arr,11);
        System.out.println("Max 11 consecutive sum = "+maxSum);

        arr = new int[] {-3,-5,-2,-90,-4,-18,-4};  //all -ve values
        System.out.println("Input: "+ Arrays.toString(arr));
        maxSum = calcMaxConsSum(arr,3);
        System.out.println("Max 3 consecutive sum = "+maxSum);


    }

    private static int calcMaxConsSum(int[] arr, int kConsecutive) {

        if(kConsecutive > arr.length) {
            return Integer.MIN_VALUE;  // indicate incorrect value of argument
        }
        if(kConsecutive == arr.length) {
            System.out.println("Will return sum of entire array...");
            //shortcut to for-loop and add each element, although many online code editors might not have way to import Arrays.
            return Arrays.stream(arr).sum();
        }

        int maxSum = Integer.MIN_VALUE;
        int currConsecutiveSum = 0;
        for(int i=0;i<kConsecutive;i++) {
            currConsecutiveSum += arr[i];
        }
        maxSum = Math.max(currConsecutiveSum,maxSum);
        int loopUntil = kConsecutive==arr.length-1?arr.length-kConsecutive:arr.length-kConsecutive-1;

        //this loop is the key logic of moving the sliding window and subtract one elem and add another element for max sum calculation
        for(int i=0; i<loopUntil; i++) {
            int nextConsecutiveSum = (currConsecutiveSum + arr[i+kConsecutive]) - arr[i];
            maxSum = Math.max(nextConsecutiveSum,maxSum);
            currConsecutiveSum = nextConsecutiveSum;
        }

        return maxSum;
    }
}
