package org.example.codility.lessons;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
 *
 * This file solves the Max Counters problem:
 *
 * **Problem:**
 * You have `N` counters, all starting at 0.
 * You get a sequence of operations in array `A`:
 * - If `A[i]` is between `1` and `N`, increase counter `A[i]` by 1.
 * - If `A[i]` is `N + 1`, set all counters to the current maximum value.
 *
 * **Example:**
 * Let `N = 5` and `A = [3, 4, 4, 6, 1, 4, 4]`.
 *
 * Step-by-step:
 * 1. Increase counter 3: `[0, 0, 1, 0, 0]`
 * 2. Increase counter 4: `[0, 0, 1, 1, 0]`
 * 3. Increase counter 4: `[0, 0, 1, 2, 0]`
 * 4. Set all to max (which is 2): `[2, 2, 2, 2, 2]`
 * 5. Increase counter 1: `[3, 2, 2, 2, 2]`
 * 6. Increase counter 4: `[3, 2, 2, 3, 2]`
 * 7. Increase counter 4: `[3, 2, 2, 4, 2]`
 *
 * **Final result:** `[3, 2, 2, 4, 2]`
 */
public class Lesson4_MaxCounters_A_LazyUpdate {


    // caso 1 a[0] = 3 = [0,0,1,0,0] - la posicion 2 del vector (3-1) va a 1 index==i
    // caso 2 a[3] = 6 = [1,1,1,1,1] - todos las posiciones del vector se setean al maximo
    public static int[] solution(int N, int[] A) throws InterruptedException {
        Thread.sleep(1000);
        int response[] = new int[N];
        int maxCounter = 0;
        for(int i=0; i < A.length; i++ ) {
            int index=A[i]-1;
            if (index == N) {
                Arrays.fill(response, maxCounter);
                continue;
            }
           response[index]++;
           if(maxCounter<response[index])
              maxCounter=response[index];
        }
        return response;
    }


  //version mejorada con lazy update

    /**
     * Problema esto tiene complejidad O(N)
     * Arrays.fill(response, maxCounter);  // O(N) cada vez
     *
     *1 En vez de actualizar todos los contadores cada vez que hay un maxCounter, solo recordás el valor mínimo que deberían tener con una variable lastUpdate.
     *2 Al hacer maxCounter, en lugar de hacer Arrays.fill, actualizás lastUpdate = currentMax.
     *3 Cada vez que incrementás un contador, te fijás si está "atrasado" (counters[i] < lastUpdate).
     *
     * Al final, hacés un for para actualizar los que no se tocaron más.
      *
     */

    public int[] solution2(int N, int[] A) {
        int[] counters = new int[N];
        int currentMax = 0;       // El valor actual más alto
        int lastUpdate = 0;       // El valor que deberían tener todos por defecto

        for (int i = 0; i < A.length; i++) {
            int index = A[i] - 1;

            if (A[i] == N + 1) {
                // No actualizo counters aún
                lastUpdate = currentMax;
            } else {
                // Aplico lazy update si no estaba al día
                if (counters[index] < lastUpdate) {
                    counters[index] = lastUpdate;
                }

                counters[index]++;
                if (counters[index] > currentMax) {
                    currentMax = counters[index];
                }
            }
        }

        // Final lazy update
        for (int i = 0; i < N; i++) {
            if (counters[i] < lastUpdate) {
                counters[i] = lastUpdate;
            }
        }

        return counters;
    }





        public static void main(String[] args) throws InterruptedException {

        System.out.println(Arrays.toString(solution(5,new int[]{3,4,4,6,1,4,4})) + " expected [3, 2, 2, 4, 2],");

        // conviene cuanod hay varios casos conviene poner un ejemplo de uno como arriba y escribir solo codigo para ese
        // Otra cosa que confundi el lenght del vector A, con el mas pequeno, en la linea 17
        // por ultimo confundi, el indice i, del vector A grande, con el la posicion en el vector pequeno que viene dada por el valor index
        // otra leccion importante es no asumir simpre recorrer un vector de izquierda a derecha, pensarlo tambien al revez (usar lateral)


    }

    /**
     * Lazy Update algorithms
     *
     * The second solution uses the lazy update technique, a well-known optimization for range updates.
     * Instead of updating all counters immediately, it tracks the minimum value they should have and updates only when necessary.
     */


}
