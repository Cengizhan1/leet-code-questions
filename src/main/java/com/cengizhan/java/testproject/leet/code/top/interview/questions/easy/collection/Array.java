package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection;

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

    public static int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        ;
    }
}
