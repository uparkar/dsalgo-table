package com.coding.competitive.dsalgo.array;

/**
 * Given an array of integers arr and two integers k and threshold.
 *
 * Return the number of sub-arrays of size k and average greater than or equal to threshold.
 */
public class MaxContinousAvgAboveThr {

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        System.out.printf("Sub-arrays = %d",numOfSubarrays(arr,3,4));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currKSum = 0;
        int nextKSum = 0;

        for(int i=0;i<k;i++) {
            currKSum += arr[i];
        }

        if(avgGreaterThanThreshold(currKSum, k, threshold))
            count++;

        for(int i=k; i<arr.length; i++) {
            nextKSum = currKSum + arr[i] - arr[i-k];
            if(avgGreaterThanThreshold(nextKSum, k, threshold))
                count++;
            currKSum = nextKSum;
        }

        return count;
    }

    public static boolean avgGreaterThanThreshold(int sum, int k, int threshold) {
        boolean isGreater = ((sum/k) >= threshold)?true:false;
        return isGreater;

    }
}
