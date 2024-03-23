package com.cengizhan.java.testproject.test;

import java.util.Arrays;
import java.util.Comparator;

public class Dog extends Animal{
    public static void main(String[] args) {
//        System.out.println(super.toString());
        test();
    }

    public static int returnMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static String[] sortStrings(String[] args) {
        String[] arr = {"A1", "B5", "C3", "D2", "E4"};
        Arrays.sort(arr, (s1, s2) -> {
            int num1 = Character.getNumericValue(s1.charAt(1));
            int num2 = Character.getNumericValue(s2.charAt(1));
            return Integer.compare(num1, num2);
        });
        return arr;
    }

    public static void test(){
        int i = 0;
        i = i + ++i;
        System.out.println(i);
    }
}
