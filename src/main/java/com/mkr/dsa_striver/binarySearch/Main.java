package com.mkr.dsa_striver.binarySearch;

public class Main {
    /*
    Let min = 0 and max = n − 1.

    If max<min, then stop; target is not present in array. Return -1.

    Compute guess as the average of max and min, rounded down so that it is an integer.

    If array[guess] equals target, then stop. You found it! Return guess.

    If the guess was too low, that is, array[guess] < target, then set min = guess + 1.

    Otherwise, the guess was too high. Set max = guess - 1.

    Go back to step two.
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 25, 35, 46, 67, 70, 85, 99};
        int target = 67;
        int result = binarySearch(arr, target);
        System.out.println("Target: " + binarySearch(arr, target));
    }

    private static int binarySearch(int[] arr, int target){
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int guess = min + (max-min)/2; // compute guess should be inside loop coz we are changing min and max

            if(arr[guess] == target) {
                return guess;
            }
            if(arr[guess] < target) {
                min = guess + 1;
            } else {
                max = guess -1;
            }
        }

        return -1; //target not found
    }

}
