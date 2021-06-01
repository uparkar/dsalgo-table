package com.coding.competitive.dsalgo.array;

/**
 * Compute sum of a given range in an array; leverage PrefixSum technique
 */
public class SubArrayTotalWithPrefixSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,100,-10,1};

        int[] prefixSum = buildPrefixSumArr(arr);

        int rangeSum = calcRangeSum(2,4,prefixSum);
        System.out.println("Sum of range 2-4 is: "+rangeSum);
        rangeSum = calcRangeSum(3,6,prefixSum);
        System.out.println("Sum of range 3-6 is: "+rangeSum);
        rangeSum = calcRangeSum(1,4,prefixSum);
        System.out.println("Sum of range 1-4 is: "+rangeSum);

    }

    private static int[] buildPrefixSumArr(int[] input) {
        int[] prefixSum = new int[input.length];

        prefixSum[0] = input[0];
        for(int i=1;i<input.length;i++) {
            prefixSum[i] = input[i] + prefixSum[i-1];
        }

        return prefixSum;
    }

    private static int calcRangeSum(int from, int to, int[] prefixSum) {
        if(from<0 || to>prefixSum.length) {
            return Integer.MIN_VALUE;
        }

        if(from > 1)
            return prefixSum[to-1] - prefixSum[(from-1)-1];
        else
            return prefixSum[to-1];
    }
}
