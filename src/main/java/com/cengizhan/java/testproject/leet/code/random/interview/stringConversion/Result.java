package com.cengizhan.java.testproject.leet.code.random.interview.stringConversion;

class Result {

    /*
     * Complete the 'getMinimumOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING binaryStr as parameter.
     */

    public static int getMinimumOperations(String binaryStr) {
        int count = 0;
        for (int i = 0; i < binaryStr.length() - 1; i++) {
            if (binaryStr.charAt(i) == '1') {
                if (binaryStr.charAt(i + 1) == '0') {
                    count = count + 2;
                    i++;
                } else {
                    count = count + 1;
                    i++;
                }
            } else {
                if (binaryStr.charAt(i + 1) == '1') {
                    if (binaryStr.charAt(i + 2) == '1') {
                        count = count + 1;
                        i = i + 2;
                        continue;
                    }
                    count = count + 2;
                    i++;
                }
            }
        }
        return count;
    }

}
