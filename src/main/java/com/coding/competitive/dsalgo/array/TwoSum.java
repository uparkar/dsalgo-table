package com.coding.competitive.dsalgo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] input = {2,11,7,15};
        int[] result = twoSum(input, 10);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {-1,-1};
        Map<Integer,Integer> diffMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(diffMap.get(nums[i]) != null) {
                result[0] = i;
                result[1] = diffMap.get(nums[i]);
                return result;
            }
            diffMap.put(target - nums[i],i);

        }
        return result;
    }
}


