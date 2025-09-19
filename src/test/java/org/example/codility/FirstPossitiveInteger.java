package org.example.codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This algorithm finds the smallest positive integer that does not appear in the input array. It does this by:
 *
 *
 * Adding all positive numbers from the array to a HashSet.
 * Starting from 1, it checks each integer to see if it is missing from the set.
 * Returns the first missing positive integer.
 * This solves the "First Missing Positive" problem.
 */
public class FirstPossitiveInteger {
    public static int solution(int[] A) {
        // 1) Mete todos los números positivos en un HashSet
        Set<Integer> seen = new HashSet<>(A.length);
        for (int x : A) {
            if (x > 0) {
                seen.add(x);
            }
        }

        // 2) A partir de 1, busca el primer entero que no esté en el Set
        int missing = 1;
        while (true) {
            if (!seen.contains(missing)) {
                return missing;
            }
            missing++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        System.out.println("Solution for a: " + solution(a)); // Expected: 11
        System.out.println("Solution for b: " + solution(b)); // Expected: numero faltante siguiente el 12
    }

}
