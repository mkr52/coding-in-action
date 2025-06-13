package com.mkr.dsa_striver.sorting;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2)
 * SC: O(1)
 * How it works:
 * 1. Compare adjacent elements and swap them if they are in the wrong order.
 * 2. Repeat for the entire array.
 * 3. The largest element bubbles up to the end of the array.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 12};
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        // For ascending order
        System.out.println("-------- Ascending Order --------");
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(bubbleSort(arr)));

        // For descending order
        // Resetting the array for demonstration
        arr = new int[]{64, 25, 12, 22, 11, 12};
        System.out.println("-------- Descending Order --------");
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(bubbleSortDesc(arr)));

        // Exercise: Practice ascending bubble sort
        bubbleSortAsc(arr);
        System.out.println("Bubble sort(asc): " + Arrays.toString(arr));
        bubbleSortDescEx(arr2);
        System.out.println("Bubble sort(desc): " + Arrays.toString(arr2));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) { // Outer loop is decreasing instead of increasing coz we are running the outer loop for n-1 times
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Swapped " + arr[j] + " and " + arr[j+1]);
                }
            }
            // Print after each iteration
            System.out.println("Iteration " + (arr.length - i) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    // For descending order
    public static int[] bubbleSortDesc(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Swapped " + arr[j] + " and " + arr[j+1]);
                }
            }
            // Print after each iteration
            System.out.println("Iteration " + (arr.length - i) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    // practice asc bubble sort
    // sorting the array in-place
    // comparing the adjacent elements and swapping them if they are in the wrong order(as or desc).
    // TC: O(n^2); SC: O(1)
    public static void bubbleSortAsc(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDescEx(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
