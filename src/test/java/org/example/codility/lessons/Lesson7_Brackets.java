package org.example.codility.lessons;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/
 */
public class Lesson7_Brackets {

    public static int solution(String A){
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            int val = convertToNumber(c);
            int diff = 0;
            if(val > 0)
                stack.push(val);

            if(val < 0 && stack.isEmpty())
                return 0;

            if(val < 0){
                int popped = stack.pop();
                diff = popped + val;
            }

            if(diff != 0) {
                return 0;
            }
        }

        if(stack.isEmpty())
            return 1;

        return 0;
    }

    private static int convertToNumber(char c) {
        switch (c) {
            case '{': return 3;
            case '[': return 2;
            case '(': return 1;
            case ')': return -1;
            case ']': return -2;
            case '}': return -3;
            default: return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("{[(A)(XW)]}") + " expected 1");
        System.out.println(solution("{}(A)(XW)]}") + " expected 0");

        //Leccion aprendida
        // Al usar colas, al igual que vectores controlar el size, o sea no hacer pop de un size 0












    }

}
