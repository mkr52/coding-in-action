package com.mkr.dsa_striver.twopointers;

public class PalindromeDemo {
    public static void main(String[] args) {
        String str = "ma D am";
        int num = 1221;
        System.out.println("Is the string (" + str + ") a palidrome ? " + detectPalindrome(str));
        System.out.println("Is the number (" + num + ") a palidrome ? " + detectIntPalindrome(num));
        System.out.println("Is the string (" + str + ") a palidrome ? " + detectPalindromeString(str));
//
        // More test cases for string
        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
        };

        for (String test : testCases) {
            System.out.println("Is the string (" + test + ") a palidrome ? " + detectPalindromeString(test));
        }
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

    public static boolean detectPalindromeString(String s) {

        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}


