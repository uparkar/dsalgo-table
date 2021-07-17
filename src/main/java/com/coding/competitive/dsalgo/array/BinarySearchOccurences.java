package com.coding.competitive.dsalgo.array;

/**
 * Count occurrences of a number in a sorted array with duplicates
 *
 */
public class BinarySearchOccurences {

    public static void main(String[] args) {

        int[] arr = {1,1,2, 5, 5, 5, 6, 8, 9, 9, 9};
        int elemToFind = 5;

        int firstOccurence = findOccurences(arr, elemToFind,true);
        int lastOccurence = findOccurences(arr, elemToFind,false);

        if(firstOccurence == Integer.MIN_VALUE)
            System.out.println("No element found");
        else {
            int cnt = lastOccurence - firstOccurence + 1;
            System.out.printf("\n%d occured %d times",elemToFind,cnt);
        }
        
    }

    private static int findOccurences(int[] arr, int elemToFind, boolean backwards) {

        int left = 0;
        int right = arr.length - 1;

        int result = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (elemToFind == arr[mid])
            {
                result = mid;

                // go on searching towards the left (lower indices)
                if (backwards) {
                    right = mid - 1;
                }
                // go on searching towards the right (higher indices)
                else {
                    left = mid + 1;
                }
            }


            else if (elemToFind < arr[mid]) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return result;
    }
}
