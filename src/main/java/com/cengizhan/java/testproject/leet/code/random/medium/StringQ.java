package com.cengizhan.java.testproject.leet.code.random.medium;

public class StringQ {

    int start = 0;
    int end = 0;
    private void palindrome(char[] ch, int i){
        int a = i;
        int b = i;
        int n = ch.length;
        if(i >= n -1) return;
        while(b < n-1 && ch[b] == ch[b+1]){
            b++;
        }
        i = b;
        while(a > 0 && b < n - 1 && ch[a-1] == ch[b+1]){
            a--;
            b++;
        }
        if((end - start) < (b-a)){
            end = b;
            start = a;
        }
        palindrome(ch,i+1);
    }
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        palindrome(ch,0);
        return s.substring(start,end+1);

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public int lengthOfLastWord(String s) {
        int length = s.length();
        while (length > 0 && s.charAt(length - 1) == ' ') {
            length--;
        }
        int i = length - 1;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return length - 1 - i;
    }

    public static void main(String[] args) {

        StringQ stringQ = new StringQ();
        System.out.println(stringQ.longestPalindrome("babad"));
        System.out.println(stringQ.convert("PAYPALISHIRING", 3));
        System.out.println(stringQ.lengthOfLastWord("Hello World"));
    }
}
