package org.example.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstUnique {
    public static int solution(int[] a) {
            Map<Integer, Integer> count = new HashMap<>();

            for (int i = 0; i < a.length; i++) {
                if (count.containsKey(a[i])) {
                    Integer val = count.get(a[i]);
                    val++;
                    count.put(a[i], val);
                } else {
                    count.put(a[i], 1);
                }
            }

            for (int i = 0; i < a.length; i++) {
                Integer val = count.get(a[i]);
                if (val == 1)
                    return a[i];
            }

            return -1;
        }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1};

        System.out.println("Solution for a: " + solution(a)); // Expected: -1
        System.out.println("Solution for b: " + solution(b)); // Expected: 1
    }

}
