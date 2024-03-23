package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection;

import java.util.Arrays;

public class StringQ {

    public char[] reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        return s;
    }

    public int reverse(int x) {
        int sign = (x >= 0) ? 1 : -1;
        x = Math.abs(x);
        long reversedX = 0;
        while (x > 0) {
            int digit = x % 10;
            reversedX = reversedX * 10 + digit;
            x /= 10;
        }
        reversedX *= sign;
        if (reversedX < Integer.MIN_VALUE || reversedX > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) reversedX;
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static String findFrequency() {
        String input = "apple";
        int count = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == 'a') {
                count++;
            }

        }
        return String.valueOf(count);

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() < 1) return true;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String str) {
        if (str.length() <= 1) return true;
        String cleanStr = str.replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        int i = 0, j = cleanStr.length() - 1;
        while (i < j) {
            if (Character.toLowerCase(cleanStr.charAt(i)) != Character.toLowerCase(cleanStr.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public int[] findLargestAndSubstract(int[] arr) {

        Arrays.sort(arr);
        int[] result = new int[2];
        result[0] = arr[arr.length - 1];
        result[1] = arr[arr.length - 2] - arr[arr.length - 1];
        return result;
    }

    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = Character.getNumericValue(s.charAt(index));
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return result * sign;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        StringQ stringQ = new StringQ();

//        System.out.println(stringQ.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}));
//        System.out.println(stringQ.reverse(-123));
//        System.out.println(stringQ.firstUniqChar("leetcode"));
//        System.out.println(stringQ.isAnagram("anagram", "nagaram"));
//        System.out.println(stringQ.isPalindrome("0P"));
//        System.out.println(stringQ.myAtoi("42"));
        System.out.println(stringQ.strStr("hello", "ell"));
    }
}
