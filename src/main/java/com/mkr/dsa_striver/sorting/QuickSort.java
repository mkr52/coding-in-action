package com.mkr.dsa_striver.sorting;

import java.util.Arrays;

// TC(Best case): O(n log n); for out of order array
// TC(Worst case): O(n^2); for already sorted array; better to use merge sort or insertion sort for such cases
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 7, 3, 2, 5};
        System.out.println("Original array: " + Arrays.toString(arr));
//        int returnedIndex = pivot(arr, 0, arr.length - 1);
        quickSort(arr);
//        System.out.println("Pivot index returned: " + returnedIndex);
//        System.out.println("Array after pivoting: " + Arrays.toString(arr));
        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }

    // Pivot
    public static int pivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for(int i = pivotIndex + 1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pivotIndex, swapIndex);
        return swapIndex;
    }

    // Quick sort helper
    public static void quickSortHelper(int[] arr, int left, int right) {
        // Base case: if the array is already sorted or has one element
        if (left < right) {
            // Find the pivot index
            int pivotIndex = pivot(arr, left, right);

            // Recursively sort left and right subarrays
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    // Add common swap method
    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
