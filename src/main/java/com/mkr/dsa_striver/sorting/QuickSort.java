package com.mkr.dsa_striver.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 7, 3, 2, 5};
        int returnedIndex = pivot(arr, 0, arr.length - 1);
        System.out.println("Pivot index returned: " + returnedIndex);
        System.out.println("Array after pivoting: " + Arrays.toString(arr));
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

    // Add common swap method
    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
