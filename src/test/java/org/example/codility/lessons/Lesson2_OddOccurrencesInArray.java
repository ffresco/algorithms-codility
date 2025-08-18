package org.example.codility.lessons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * retornar el numero en el vector que queda con parera impar ejemplo: {9, 3, 9, 3, 9, 7 , 9}) + " expected 7"
 */
public class Lesson2_OddOccurrencesInArray {

    public static int solution(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < A.length; i++){
            if (map.containsKey(A[i]))
                map.put(A[i], map.get(A[i]) + 1);

            if (!map.containsKey(A[i]))
                map.put(A[i], 1);
        }

        int response = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            response = entry.getKey();
            if ((entry.getValue() % 2)!=0)
                break;

        }

        return response;
    }



        public static void main(String[] args) {



        System.out.println(solution(new int[]{9, 3, 9, 3, 9, 7 , 9}) + " expected 7");

        // lecciones aprendidas:


    }

}
