package com.coding.competitive.dsalgo.array;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {

        int[] nums1 = {4,6,8,10,0,0,0};
        int[] nums2 = {-9,-7,-2};

        mergeSorted(nums1,nums1.length-nums2.length,nums2,nums2.length);
        System.out.println("New Merged array: "+java.util.Arrays.toString(nums1));
    }

    private static void mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int totalLen = m+n - 1;
        int i = m-1, j= n-1;

        while(i>=0 && j>=0) {
            if(nums1[i] > nums2[j]) {
                nums1[totalLen--] = nums1[i];
                i--;
            } else {
                nums1[totalLen--] = nums2[j];
                j--;
            }
        }

        if(i>=0){
            while(i>=0) {
                nums1[totalLen--] = nums1[i--];
            }
        }

        if(j>=0) {
            while (j>=0) {
                nums1[totalLen--] = nums2[j--];
            }
        }

        System.out.println("Current Status: "+ Arrays.toString(nums1)+"i="+i+" j= "+j+" totlen= "+totalLen);
    }
}
