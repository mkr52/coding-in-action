package com.mkr.dsa_striver.sorting;

import java.util.Arrays;

/**
 * TC: O(n^2)
 * SC: O(1)
 * How it works:
 * 1. Start from the second element (index 1) and compare it with the elements before it.
 * 2. If the current element is smaller than the previous elements, shift the larger elements to the right.
 * 3. Insert the current element at its correct position.
 * 4. Repeat the process for all elements in the array.
 */

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 12};

        // For ascending order
        System.out.println("-------- Ascending Order --------");
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(insertionSort(arr)));

        // For descending order
        // Resetting the array for demonstration
        arr = new int[]{64, 25, 12, 22, 11, 12};
        System.out.println("-------- Descending Order --------");
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(insertionSortDesc(arr)));

        insertionSortAscEx(arr);
        System.out.println("Sorted array (asc): " + Arrays.toString(arr));

        insertionSortDescEx(arr);
        System.out.println("Sorted array (desc): " + Arrays.toString(arr));
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && temp < arr[j]) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                System.out.println("Swapped " + arr[j] + " and " + arr[j+1]);
                j--;
            }
            // Print after each iteration
            System.out.println("Iteration " + (i) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    public static int[] insertionSortDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && temp > arr[j]) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                System.out.println("Swapped " + arr[j] + " and " + arr[j+1]);
                j--;
            }
            // Print after each iteration
            System.out.println("Iteration " + (i) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    public static void insertionSortAscEx(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && temp < arr[j]) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                System.out.println("Swapped " + arr[j] + " and " + arr[j+1]);
                j--;
            }
        }
    }

    public static void insertionSortDescEx(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && temp > arr[j]) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                System.out.println("Swapped " + arr[j] + " and " + arr[j+1]);
                j--;
            }
        }
    }

}
