package com.coding.competitive.dsalgo.array;

/**
 * Search in an almost sorted array
 */
public class AlmostSorted {

    public static void main(String[] args) {
        int arr[] = {3, 2, 10, 4, 40};

        int elem = 4;
        int result = binarySearch(arr, 0, arr.length - 1, 4);
        if (result == Integer.MIN_VALUE)
            System.out.println("Element not in the given array");
        else
            System.out.println("Element is present at index " +
                    result);
    }

    private static int binarySearch(int arr[], int sI, int eI, int elem) {
        if (eI >= sI) {
                int mid = eI + (eI - sI) / 2;

                //NOTE: the key to remember is check middle as well as the immediate neighbours of mid
                // because the array is (almost) unsorted need to perform the check
                if (arr[mid] == elem)
                    return mid;
                if (mid > sI && arr[mid - 1] == elem)
                    return (mid - 1);
                if (mid < eI && arr[mid + 1] == elem)
                    return (mid + 1);

                // If element is smaller than mid, then
                // it can only be present in left subarray
                if (arr[mid] > elem)
                    return binarySearch(arr, sI, mid - 2, elem);

                // Else the element can only be present
                // in right subarray
                return binarySearch(arr, mid + 2, eI, elem);
            }

        return Integer.MIN_VALUE;
    }
}