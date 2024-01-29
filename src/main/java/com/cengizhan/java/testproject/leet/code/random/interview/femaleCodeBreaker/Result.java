package com.cengizhan.java.testproject.leet.code.random.interview.femaleCodeBreaker;

import java.util.List;

class Result {

    /*
     * Complete the 'gcdArrays' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> gcdArrays(List<Integer> arr) {
        int gcd = 0;
        int count = 0;
        int temp = 0;
        for (int i = 0; i < arr.size()-1; i++) {
            if (findGcd(arr.get(i), arr.get(i + 1)) > gcd)
            {
                gcd = findGcd(arr.get(i), arr.get(i + 1));
            }
        }
        if (gcd == 0){
            return List.of(0, 0);
        }
        for (Integer integer : arr) {
            if (integer % gcd == 0) {
                temp++;
            } else {
                temp = 0;
            }
            count = Math.max(count, temp);
        }
        return List.of(gcd, count);
    }

    public static int findGcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(gcdArrays(List.of(1,2,3)));
    }

}
