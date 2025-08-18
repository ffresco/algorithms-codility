package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 * retornar el numero en el vector que queda con parera impar ejemplo: {9, 3, 9, 3, 9, 7 , 9}) + " expected 7"
 */
public class Lesson4_FrogRiverOne {

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
