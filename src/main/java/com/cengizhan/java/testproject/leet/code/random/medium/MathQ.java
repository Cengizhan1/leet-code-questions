package com.cengizhan.java.testproject.leet.code.random.medium;

import java.util.Map;

public class MathQ {
    public Map<Character, Integer> romanValues = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i + 1))) {
                result -= romanValues.get(s.charAt(i));
            } else {
                result += romanValues.get(s.charAt(i));
            }
        }
        return result;
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < roman.length; i++) {
            while (num >= values[i]) {
                sb.append(roman[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        MathQ mathQ = new MathQ();
//        System.out.println(mathQ.romanToInt("MIV"));
        System.out.println(mathQ.intToRoman(1994));
    }
}
