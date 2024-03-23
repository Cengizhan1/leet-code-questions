package com.cengizhan.java.testproject.hacker.rank;

import java.util.Arrays;

public class Main {

    public static int[] intArray(int[] input) {
        int[] result = new int[input.length];
        int temp =0;
        for(int i =0; i<input.length; i++){
            result[i] = input[i] + temp;
            temp += input[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intArray(new int[]{1, 2, 3, 4, 5})));
    }
}
