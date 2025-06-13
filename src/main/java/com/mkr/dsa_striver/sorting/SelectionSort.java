package com.mkr.dsa_striver.sorting;

import java.util.Arrays;

/**
 * Time complexity: O(n^2)
 * Space complexity: O(1) because it is an in-place sorting algorithm.
 * How it works:
 * 1. Find the minimum element in the unsorted array.
 * 2. Swap it with the first element of the unsorted array.
 * 3. Repeat the process for the rest.
 * 4. To handle duplicates, we use stable selection sort which maintains the relative order of equal elements.
 * 5. Edge cases:
 *   - If the array is empty or has only one element, it is already sorted.
 *   - If the array is sorted, it still will run O(n^2) time.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 12};

        // For ascending order
        System.out.println("-------- Ascending Order --------");
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(selectionSort(arr)));

        // For descending order
        // Resetting the array for demonstration
        arr = new int[]{64, 25, 12, 22, 11, 12};
        System.out.println("-------- Descending Order --------");
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(selectionSortDesc(arr)));

        // Exercise: Practice ascending selection sort
        selectionSortAscEx(arr);
        System.out.println("Selection sorted(asc) array: " + Arrays.toString(arr));

        // Exercise: Practice descending selection sort
        selectionSortDescEx(arr);
        System.out.println("Selection sorted(desc) array: " + Arrays.toString(arr));
    }

    // Selection sort algorithm - ascending order
    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element
            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }

            // Print the array after each iteration
            System.out.println("Iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }

        return arr;
    }

    // descending order
    public static int[] selectionSortDesc(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int maxIndex = i;

            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the found minimum with the first element
            if(maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }

            // Print the array after each iteration
            System.out.println("Iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }

        return arr;
    }

    // Exercise: Practice ascending selection sort
    public static void selectionSortAscEx(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element
            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            // Print the array after each iteration
            System.out.println("Iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    // Exercise: Practice descending selection sort
    public static void selectionSortDescEx(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;

            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the found minimum with the first element
            if(maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
            // Print the array after each iteration
            System.out.println("Iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }
}
