package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection;

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

    public static void main(String[] args) {
        StringQ stringQ = new StringQ();

//        System.out.println(stringQ.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}));
//        System.out.println(stringQ.reverse(-123));
//        System.out.println(stringQ.firstUniqChar("leetcode"));
        System.out.println(stringQ.isAnagram("anagram", "nagaram"));
    }
}
