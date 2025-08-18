package org.example.codility;

import java.util.HashMap;
import java.util.Map;
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public class AstroPay {
    public static int solution(String S, String T) {
        // Validación básica de igual longitud
        if (S == null || T == null || S.length() != T.length()) {
            return -1;
        }

        int[] s = convertToArray(S);
        int[] t = convertToArray(T);

        int count = 0;
        int n = S.length();

        // Recorremos cada par adyacente (i, i+1)
        for (int i = 0; i < n - 1; i++) {
            int p1 = s[i];
            int p2 = s[i + 1];
            int t1 = t[i];
            int t2 = t[i + 1];

            int attempts = 0;
            // Intentamos como máximo 10 incrementos circulares
            while (attempts < 10) {
                if (p1 == t1 && p2 == t2) {
                    break;
                }
                p1 = increment(p1);
                p2 = increment(p2);
                count++;
                attempts++;
            }

            if (attempts >= 10) {
                return -1;
            }
        }

        return count;
    }

    private static int increment(int x) {
        return (x == 9) ? 0 : x + 1;
    }

    private static int[] convertToArray(String x) {
        int n = x.length();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            // Convierte el carácter dígito en su valor entero
            numbers[i] = Character.getNumericValue(x.charAt(i));
        }
        return numbers;
    }

    public static void main(String[] args) {

        System.out.println(solution("12","23")); // Expected: 1
        System.out.println(solution("1234", "1234")); // 0, ya son iguales
        System.out.println(solution("0000", "0009")); // -1, no se puede con pares
        System.out.println(solution("89", "01"));     // 2 operaciones: 89→(90,00)→(01,11). De hecho aquí n=2, primer paso: delta=(0−8+10)%10=2, aplicamos 2 ops.
        System.out.println(solution("555", "777"));   // 4 ops:
        int delta = (5 - 1 + 10) % 10;
        System.out.println( delta);

    }

}
