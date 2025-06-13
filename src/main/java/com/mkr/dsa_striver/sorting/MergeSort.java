package com.mkr.dsa_striver.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5, 6, 7};

        System.out.println("---- Merging sorted arrays ----");
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Combined array: " + Arrays.toString(merge(arr1, arr2)));

        System.out.println("---- Merge Sort ----");
        int[] arr = {64, 25, 12, 22, 11, 13};
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(mergeSort(arr)));

        System.out.println("---- Merge Sort Asc ----");
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(mergeSortAscEx(arr)));

        System.out.println("---- Merge Sort Desc ----");
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(mergeSortDescEx(arr)));



    }

    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                combined[index++] = arr1[i++];
            } else {
                combined[index++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combined[index++] = arr1[i++];
        }

        while (j < arr2.length) {
            combined[index++] = arr2[j++];
        }

        return combined;
    }

    // Exercise: Merge two sorted arrays
    public static int[] mergeAscEx(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0; // to track the index of the combined array
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                combined[index++] = arr1[i++];
            } else {
                combined[index++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combined[index++] = arr1[i++];
        }

        while (j < arr2.length) {
            combined[index++]  =arr2[j++];
        }

        return combined;
    }

    public static int[] mergeDescEx(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0; // to track the index of the combined array
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] > arr2[j]) {
                combined[index++] = arr1[i++];
            } else {
                combined[index++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combined[index++] = arr1[i++];
        }

        while (j < arr2.length) {
            combined[index++]  =arr2[j++];
        }

        return combined;
    }

    public static int[] mergeSortAscEx(int[] arr) {
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = mergeSortAscEx(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSortAscEx(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeAscEx(left, right);
    }

    public static int[] mergeSortDescEx(int[] arr) {
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = mergeSortDescEx(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSortDescEx(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeDescEx(left, right);
    }
}
