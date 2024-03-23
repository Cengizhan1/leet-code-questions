package com.cengizhan.java.testproject.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static String findLongestString(String input) {
        int arr[] = {1,2,3};
        int[] arr2 = {1,2,3};
        String[] words = input.split(" ");
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }


    public static void main(String[] args) {
//---> Generic Tanımlama İşlemi <--- \\
        List nonGenericList = new ArrayList(); // --> Non-Generic Tanımlaması.
        List<String> genericList = new ArrayList<>(); // --> Generic Tanımlaması.
        nonGenericList.add("String Bir Değer Atıyorum.");
        nonGenericList.add(100+" İstersem Integer Bir Değer, "+15.5+" İstersem Double Bir Değer Atıyabiliyorum.");
        genericList.add("Sadece String Bir Değer Atıyorum."); //--> Veri tipini belirttiğim için sadece o veri tipinde ekleme yapabiliyorum.
        genericList.add("<veriTipi> Yapısına Elmas'da Deniliyor.");
//---> Ekrana Yazdırma <--- \\
        System.out.println("----------------\n< Non-Generic Tanımlamalar >\n----------------\n-> "+nonGenericList.get(0) +"\n-> "+nonGenericList.get(1));
        System.out.println("----------------\n< Generic Tanımlamalar >\n----------------\n-> "+genericList.get(0) +"\n-> "+genericList.get(1)+"\n----------------");
    }
}
