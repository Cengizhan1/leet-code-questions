package com.cengizhan.java.testproject.leet.code.random.medium;

import java.util.Arrays;

public class ArrayQ {
    public int[][] divideArray(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i+2]-nums[i] > k || nums[i+2] - nums[i+1] > k || nums[i+1] - nums[i] > k) {
                return new int[][]{};
            }
        }
        return partitionArray(nums);
    }
    public static int[][] partitionArray(int[] array) {
        int arrayLength = array.length;
        int numberOfPartitions =arrayLength / 3;
        int[][] resultArray = new int[numberOfPartitions][];
        for (int i = 0; i < numberOfPartitions; i++) {
            int start = i * 3;
            int end = Math.min((i + 1) * 3, arrayLength);
            resultArray[i] = Arrays.copyOfRange(array, start, end);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        ArrayQ arrayQ = new ArrayQ();
        System.out.println(Arrays.deepToString(arrayQ.divideArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3)));
    }
}
