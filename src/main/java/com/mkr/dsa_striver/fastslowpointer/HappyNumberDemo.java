package com.mkr.dsa_striver.fastslowpointer;

/**
 * Happy Number is a number whose sum of squares eventually reaches 1.
 * If it reaches a cycle that does not include 1, it is not a happy number.
 * Time Complexity: O(log n), where n = number of digits in a number -> log(n) = Ceiling(O(log10(n))) ~ 2.234 = 3
 */
public class HappyNumberDemo {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Is " + n + " a happy number? " + isHappy(n));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int findSquare(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
