package org.example.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Code Challenge

 Question:
 Given a string s, find the length of the longest substring without duplicate characters.
 Note: Considering ignoring case sensitive.

 Example 1:
 Input: s = "abcABCbb"
 Output: 3
 Explanation: The answer is "abc" or “ABC”, with the length of 3.

 Example 2:
 Input: s = "bbBbB”
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: s = "pwWkew"
 Output: 3
 Explanation: The answer is “Wke” or “kew”, with length of 3.

 TEST

 s                   a   b   c   A   B   C   b   b
 current             0   1   2   3   4   5   6   7
 currentChar         a   b   c   a   b   c   b   b
 startSubstring      0   0   0   4   5   6   7   8
 currentSubLength    1   2   3   0   0.  0   0   0
 maximo              1   2   3   3.  3.  3   3   3
 */
public class EntrevisataBonzzuCountLetters {

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        System.out.println(solution("abcABCbb") + "  expected 3");
        System.out.println(solution("bbBbB") + "  expected 1");
        System.out.println(solution("pwWkew") + "  expected 3");

    }

    public static int solution(String s){
        s = s.toUpperCase();
        int maximo = 0;
        int startSubstring = 0;

        Map<Character, Integer> charMap = new HashMap<>();

        for(int current = 0; current < s.length(); current++){
            //tomo el caracter
            char currentChar = s.charAt(current);
            if(charMap.containsKey(currentChar) && charMap.get(currentChar) >= startSubstring){
                startSubstring = charMap.get(currentChar) + 1;
            }
            charMap.put(currentChar,current);

            int currentSubstringLength = (current + 1) - startSubstring;
            if(currentSubstringLength > maximo )
                maximo = currentSubstringLength;


        }

        return maximo;

    }



}
