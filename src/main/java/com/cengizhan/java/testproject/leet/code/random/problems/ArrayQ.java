package com.cengizhan.java.testproject.leet.code.random.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayQ {
    public int[][] divideArray(int[] nums, int k) {
        if (nums.length % 3 != 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k || nums[i + 2] - nums[i + 1] > k || nums[i + 1] - nums[i] > k) {
                return new int[][]{};
            }
        }
        return partitionArray(nums);
    }

    public static int[][] partitionArray(int[] array) {
        int arrayLength = array.length;
        int numberOfPartitions = arrayLength / 3;
        int[][] resultArray = new int[numberOfPartitions][];
        for (int i = 0; i < numberOfPartitions; i++) {
            int start = i * 3;
            int end = Math.min((i + 1) * 3, arrayLength);
            resultArray[i] = Arrays.copyOfRange(array, start, end);
        }

        return resultArray;
    }

    public boolean isMatch(String s, String p) {
        if (p.length() < s.length() && p.charAt(p.length() - 1) != '*') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) == '*') return true;
            if (p.charAt(i) == '.') continue;
            if (p.charAt(i) != s.charAt(i)) return false;
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int temp = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    set.clear();
                    break;
                }
                set.add(s.charAt(j));
                if (set.size() > temp) {
                    temp = set.size();
                }
            }
        }

        return temp;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] new_arr = new int[n];
        int i=0, j=0, k=0;
        while (i<=n1 && j<=n2) {
            if (i == n1) {
                while(j<n2) new_arr[k++] = nums2[j++];
                break;
            } else if (j == n2) {
                while (i<n1) new_arr[k++] = nums1[i++];
                break;
            }
            if (nums1[i] < nums2[j]) {
                new_arr[k++] = nums1[i++];
            } else {
                new_arr[k++] = nums2[j++];
            }
        }
        if (n%2==0) return (float)(new_arr[n/2-1] + new_arr[n/2])/2;
        else return new_arr[n/2];
    }

    public int maxProfit2(int[] prices) {
        int minValue = prices[0];
        int len = prices.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            minValue = Math.min(minValue,prices[i]);
            result = Math.max(result, prices[i]-minValue);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayQ arrayQ = new ArrayQ();
//        System.out.println(Arrays.deepToString(arrayQ.divideArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3)));
//        System.out.println(arrayQ.isMatch("aa", "a"));
//        System.out.println(arrayQ.lengthOfLongestSubstring("jbpnbwwd"));
        System.out.println(arrayQ.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
