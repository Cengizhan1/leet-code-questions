package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection;

import java.util.*;

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
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                diff = Math.max(diff, prices[i] - minValue);
            } else {
                minValue = prices[i];
                result += diff;
                diff = 0;
            }
        }
        return result + diff;
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

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }


    public static void main(String[] args) {
        Array array = new Array();
//        System.out.println(array.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(Arrays.toString(array.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
//        System.out.println(array.containsDuplicate(new int[]{1, 2, 3, 1}));
//        System.out.println(array.singleNumber(new int[]{4, 1, 2, 1, 2})););
//        System.out.println(Arrays.toString(array.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));;
        System.out.println(Arrays.toString(array.plusOne(new int[]{9})));
    }
}
