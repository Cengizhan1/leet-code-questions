package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Array {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int diff = 0;
        int result =0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i-1]< prices[i]) {
                    diff = Math.max(diff, prices[i]-minValue);
            } else {
                minValue = prices[i];
                result+=diff;
                diff=0;
            }
        }
        return result+diff;
    }
    public int[] rotate(int[] nums, int k) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
        return nums;
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Array array = new Array();
//        System.out.println(array.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(Arrays.toString(array.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
//        System.out.println(array.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
