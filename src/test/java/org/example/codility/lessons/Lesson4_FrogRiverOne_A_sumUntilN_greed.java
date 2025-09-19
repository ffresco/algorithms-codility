package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 *
 * This code solves the Frog River One problem from Codility.
 *
 * **How it works:**
 * - It uses a boolean array to track which positions (from 1 to X) have been covered by leaves.
 * - It calculates the target sum of all positions using the formula for the sum of the first X natural numbers.
 * - As leaves fall, it marks positions and adds their value to the sum.
 * - When the sum matches the target, all positions are covered, and it returns the earliest time.
 *
 * **Algorithms used:**
 * - **Tracking unique elements with a boolean array**
 * - **Sum of arithmetic progression (formula: X \* (X + 1) / 2)**
 * - **Greedy approach** (find earliest time all positions are covered)
 */
public class Lesson4_FrogRiverOne_A_sumUntilN_greed {

    public static int solution(int X, int[] A) {
        boolean[] path = new boolean[X + 1];
        int sum = 0;
        int target = X * (X + 1) / 2;

        if (X>=A.length)
            return -1;
        for (int i = 0; i < A.length; i++) {
            int pos = A[i];
            if (pos <= X && !path[pos]) {
                path[pos] = true;
                sum += pos;
                if (sum == target) {
                    return i;
                }
            }
        }

        return -1;
    }



        public static void main(String[] args) {



        System.out.println(solution(5,new int[]{1,3,1,4,2,3,5,4}) + " expected 6");

        // lecciones aprendidas:
        // un arrayh int[N], tendra length N y indice de 0 a N-1
            //El length lo uso al crear, me dice cuántos hay,
            //pero al recorrer doy un paso atrás y paro antes del final.


    }



}
/**
 * The Frog River One problem asks:
 * Given a river of width `X`, and an array `A` where each element represents a leaf falling at position `A[i]` at time `i`, find the earliest time when all positions from `1` to `X` are covered by leaves so the frog can cross.
 * If it's never possible, return `-1`.
 * The goal is to determine the minimum index `i` such that every position from `1` to `X` has at least one leaf.
 */