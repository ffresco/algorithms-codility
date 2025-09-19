package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * This code solves the Tape Equilibrium problem using a prefix sum approach.
 * It is a standard algorithmic technique for efficiently calculating sums of subarrays and their differences.
 * Prefix sums are commonly used in array partitioning and equilibrium problems.
 * So yes, it uses a well-known algorithmic method.
 */
public class Lesson3_TapeEquilibrium_A_prefixSum {

    public static int solution(int[] A) {
        // Compute total sum using a larger type to avoid overflow
        long totalSum = 0;
        for (int value : A) {
            totalSum += value;
        }

        long minDiff = Long.MAX_VALUE;    // start with a very large difference
        long leftSum = 0;

        // Iterate through possible split points 1 <= P < N (i.e., index 0 to N-2)
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];               // add current element to left part
            long rightSum = totalSum - leftSum;
            long diff = Math.abs(leftSum - rightSum);  // absolute difference for this split
            if (diff < minDiff) {
                minDiff = diff;            // update min difference if smaller
                if (minDiff == 0) {
                    // We found the smallest possible difference, can exit early
                    break;
                }
            }
        }

        return (int) minDiff;  // cast back to int, safe because diff is within int range
    }



        public static void main(String[] args) {



        System.out.println(solution(new int[]{3,1,2,4,3}) + " expected 1");

        // lecciones aprendidas:


    }

    /**
     * Leccion aprendida Fer
     * 1-si tengo que partir, no puedo contar el ultimo elemento porque no hay nada del lado derecho
     * 2-Diff, iniciar siempre bien grande para que cualquier diferencia entre al iff
     * 3-Long para asegurar que la suma de Integers no de overFlow
     */


    /**
     * Key fixes in this code:
     * 1-We loop only until i < A.length - 1, so the right part always has at least one element. This avoids the invalid scenario of an empty right side
     * stackoverflow.com
     * .
     * 2-minDiff is initialized to a very large value (Long.MAX_VALUE), ensuring any real difference will be smaller. Alternatively, we could initialize minDiff to the difference of the first valid split (after the first iteration) – both approaches prevent the negative/zero initialization issue
     * medium.com
     * . We also use a long type for minDiff, leftSum, and totalSum to guard against overflow with extreme inputs.
     * 2-We calculate diff using Math.abs(...) to ensure it is non-negative, and we update minDiff properly. The result returned is cast to int because the minimal difference will always be within the range of 0 to a value well below the 32-bit integer limit (under problem constraints, the worst-case difference is around 100 million
     * medium.com
     * , which is safely an int).
     */

}
