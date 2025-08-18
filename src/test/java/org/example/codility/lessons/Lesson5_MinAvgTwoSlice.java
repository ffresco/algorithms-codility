package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * Dado un vector, tenes que ver tomando es slices de minimo 2 elementos hasta to do el largo del vector cual es el sllice, con promedio mas bajo
 *
 */
public class Lesson5_MinAvgTwoSlice {

    /**
     * uno hacer manualmente una tabla viendo el promedio tomanod slice de 2 pares y luego otra tomando slice de 3 pares
     * Con esto demuestro que cubro todos los casos, por que cuqquier slice mas grande, puede ser formado por sublice de 2 o 3, ejemplo
     * Slice de 4, son dos sublice, de 2 y dos de 3 dejando fuera un elemento, Entonces no puede haber un menor
     *
     *  cualquier slice más largo (de 4 o más elementos) puede ser subdividido en slices de 2 o 3 elementos, y al menos uno de esos sub-slices tendrá un promedio menor o igual que el promedio total.
     *
     * Pregunta entrevistas conclusion
     * 🔹 Buscar solo en slices de tamaño 2 y 3 garantiza el resultado correcto.
     *
     * 🔹 No hace falta revisar tamaños mayores.
     *
     * 🔹 Esto permite una solución eficiente: O(N).
     *
     * Métrica	Complejidad
     * Tiempo	O(N)
     * Espacio	O(1)
     **/
    public static int solution(int[] A){

        int minIndex = 0;
        double minAvg = (A[0] + A[1]) / 2.0;

        for (int i = 0; i < A.length - 1; i++) {
            // promedio de 2
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minIndex = i;
            }

            // promedio de 3
            if (i < A.length - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < minAvg) {
                    minAvg = avg3;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }



    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,2,2,5,1,5,8}) + " expected 1");
        System.out.println(solution(new int[] {10, 10, -10, -10, 10}) + " este es un caso donde el slice minimo fue de 3 elementos, expected 2");
    }

}
