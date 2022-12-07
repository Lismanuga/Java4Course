package com.example.lab1;

import java.util.*;

public class Task5 {

    static ArrayList<Character> findCharcter(char[] strA, char[] strB) {
        ArrayList<Character> stringResult = new ArrayList<>();


        for (char chA : strA){
            for (char chB : strB){
                if (chA == chB){
                    if (!stringResult.contains(chA)){
                        stringResult.add(chA);
                    }
                }
            }
        }

        return stringResult;
    }

        public static void main (String[]args){
            char[] str1 = "abcda".toCharArray();
            char[] str2 = "cbdae".toCharArray();
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(findCharcter(str1, str2));
        }
    }
