package com.coding.competitive.dsalgo.array;

/**
 * Find contiguous subarray with max sum and return the max sum; leverage Kadance Algorithm
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {20,20,20,20,-80,-1000,-10};

        int maxSum = calcMaxSubArraySum(arr);
        System.out.println("Max subarray sum = "+maxSum);

        arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSum = calcMaxSubArraySum(arr);
        System.out.println("Max subarray sum = "+maxSum);
    }

    private static int calcMaxSubArraySum(int[] arr) {
        int result = Math.max(Integer.MIN_VALUE,arr[0]);
        int maxAtCurrIndex = 0;

        for(int i=0; i<arr.length; i++) {
            //maxAtCurrIndex = Math.max(arr[i],maxAtCurrIndex+arr[i]);
            maxAtCurrIndex += arr[i];
            if(maxAtCurrIndex < 0) {
                maxAtCurrIndex = 0;
            } else {
                result = Math.max(result, maxAtCurrIndex);
            }

        }

        return result;
    }
}
