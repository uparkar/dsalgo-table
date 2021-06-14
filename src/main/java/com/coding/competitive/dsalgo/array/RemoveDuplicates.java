package com.coding.competitive.dsalgo.array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,1,1,1,1,1,1,2,2,3};

        int len = removeDuplicates(arr);
        for(int i=0;i<len;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static int removeDuplicates(int[] nums) {
        int j = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] > nums[j-1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

}
