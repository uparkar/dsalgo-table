package com.coding.competitive.dsalgo.stacks;

import java.util.Arrays;
import java.util.Stack;

public class GreaterThanElement {

    public static void main(String[] args) {
        int[] arr = {5,3,1,10,8,5,9,8,7};

        int[] result = buildGTIndexArray(arr);

        System.out.println("GTInput = "+Arrays.toString(arr));
        System.out.println("GTResult = "+Arrays.toString(result));

    }

    private static int[] buildGTIndexArray(int[] input) {
        int[] result = new int[input.length];
        Stack<Pair> stk = new Stack<>();

        for(int i=0; i<input.length; i++) {
            while(!stk.isEmpty() && input[i] > stk.peek().value) {
                Pair popped = stk.pop();
                result[popped.index] = i;
            }

            stk.push(new Pair(i,input[i]));
        }

        // if any remaining elems in stack indicates no greater than element available for it
        while(!stk.isEmpty()) {
            result[stk.pop().index] = -1;
        }

        return result;
    }

    private static class Pair {
        public int index;
        public int value;

        Pair(int index,int value) {
            this.index = index;
            this.value = value;
        }
    }
}
