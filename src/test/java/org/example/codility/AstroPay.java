package org.example.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Dadas dos cadenas numéricas S y T de la misma longitud, queremos transformar S en T mediante la siguiente operación:
 *
 * Elegir una posición i (0 ≤ i < n−1) y sumar 1 (mod 10) tanto al dígito S[i] como al dígito S[i+1].
 *
 * El objetivo es determinar la mínima cantidad de operaciones necesarias para que S se convierta en T.
 * Si no es posible, devolver -1.
 *
 * Ejemplo con tu caso
 * S = "2233"
 * T = "5566"
 *
 *
 * Operaciones en (0,1) → 2233 → 3343 → 4453 → 5563.
 *
 * Operaciones en (2,3) → 5563 → 5564 → 5565 → 5566.
 *
 * Total = 6 operaciones.
 *
 */
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

//algoritmo se comporta como greedy porque:
//En cada posición i solo intenta resolver localmente ese par (i, i+1).
//Nunca vuelve atrás ni reconsidera decisiones anteriores.
//Avanza linealmente, confiando en que resolver localmente cada par llevará a la solución global.
//Eso es la definición de greedy: resolver el problema paso a paso tomando la mejor decisión local inmediata.
