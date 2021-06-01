package com.coding.competitive.dsalgo.array;

/**
 * Find if equilibrium point(index) exist for an array
 * left sum and right sum of the index should be equal to call it Equilibrium point
 */
public class EquilibriumPoint {

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};

        int eqIndex = findEquilibriumPoint(arr);
        System.out.println("The Eq index for the arr is: "+eqIndex);

    }

    private static int findEquilibriumPoint(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (rightSum == leftSum) {
                return i;
            }

            leftSum = leftSum + arr[i];
        }
        return -1;
    }


}
