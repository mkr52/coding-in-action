package com.mkr.dsa_striver.twopointers;

public class PalindromeDemo {
    public static void main(String[] args) {
        String str = "ma D am";
        int num = 1221;
        System.out.println("Is the string (" + str + ") a palidrome ? " + detectPalindrome(str));
        System.out.println("Is the number (" + num + ") a palidrome ? " + detectIntPalindrome(num));
        System.out.println("Is the string (" + str + ") a palidrome ? " + detectPalindromeString(str));
    }

    public static boolean detectPalindrome(Object item) {
        if(item instanceof String) {
            String str = ((String) item).toLowerCase();
            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if(str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        } else if(item instanceof Integer) {
            int num = (Integer) item;
            return detectIntPalindrome(num);
        }
        return true;
    }

    public static boolean detectIntPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while(num > 0) {
            int digit = num % 10;
            reversedNum = (reversedNum * 10) + digit;
            num /= 10;
        }

        return reversedNum == originalNum;
    }

    public static boolean detectPalindromeString(String str) {

        // initialize first pointer
        int left = 0;

        // initialize second pointer
        int right = str.length() - 1;

        // loop until the pointers meet
        while(left < right) {
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }

            // move the pointers
            while(left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            left++;
            right--;
        }

        return true;
    }
}


