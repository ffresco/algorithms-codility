package org.example.codility.lessons;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * This class provides two methods to rotate the elements of an integer array `A` to the right by `K` positions.
 * Each element is moved to a new index calculated by `(current index + K) % array length`, so the array wraps around in a circular fashion.
 * The result is a new array with the elements shifted right by `K` places.
 */
public class Lesson2_CyclicRotation {

    public static int [] solution(int[] A, int K) {
        int [] result = new int[A.length];

        for (int i = 0; i < A.length; i++){
            int newIndex = i + K;
            int rotation = getRotatedIndex(newIndex,A.length);
            result[rotation] = A[i];
        }
        return result;
    }

    private static int getRotatedIndex(int newIndex, int length) {
        if(newIndex >= length) {
            newIndex = newIndex - length;
            newIndex = getRotatedIndex(newIndex,length);
        }
        return newIndex;
    }

    // version mas limpia
    // usando divicsion de moduloz`
    // Con %, las posiciones giran en círculo y nunca se salen del array.”
    // array de lenth 5
    // Mover cada elemento K=2 lugares a la derecha:
    // 10 (posición 0) → (0 + 2) % 5 = 2 → va a posición 2
    // 20 (posición 1) → (1 + 2) % 5 = 3 → va a posición 3
    // 50 (posición 4) → (4 + 2) % 5 = 1 → va a posición 1
    public static int[] solution2(int[] A, int K) {
        int[] result = new int[A.length];
        int n = A.length;

        if (n == 0) return result; // evitar división por 0

        for (int i = 0; i < n; i++) {
            int rotatedIndex = (i + K) % n;
            result[rotatedIndex] = A[i];
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)) + " expected [9, 7, 6, 3, 8]");

        // lecciones aprendidas:


    }

}
