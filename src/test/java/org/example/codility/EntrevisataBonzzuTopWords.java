package org.example.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Code Challenge

 Description:
 Write a function that takes a string text as input, which may contain multiple sentences, and returns a list of the three most frequently occurring words in the entire text, ordered from most frequent to least frequent.

 Test Case 1:
 - Input: "Hello world hello WORLD hello. Good morning world!"
 - Output: ["hello", "world", "good"]
 Test Case 2:
 - Input: "The quick brown fox jumps over the lazy fox. The fox is quick."
 - Output: ["the", "fox", "quick"]
 Test Case 3:
 - Input: "one two three one two one. Three two one."
 - Output: ["one", "two", "three"]
 Test Case 4:
 - Input: "a a a b b c c c d d e. e d c b a"
 - Output: ["a", "c", "b"]

 */
public class EntrevisataBonzzuTopWords {
    public static List<String> top3Words_usingPriorityQueue(String[] words) {
        // 1. Contar frecuencias
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // 2. PriorityQueue para ordenar por frecuencia
        // Usamos un min-heap de tamaño 3
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(entry);  // insertamos
            if (pq.size() > 3) {
                pq.poll();   // eliminamos el menor
            }
        }

        // 3. Extraer los resultados (van a estar de menor a mayor, por eso damos vuelta la lista)
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

    public static List<String> top3Words_usingMap(String[] words) {
        // 1. Contar frecuencias
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // 2. Pasar las entradas del mapa a una lista
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());

        // 3. Ordenar por valor (frecuencia) de mayor a menor
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 4. Tomar solo los primeros 3 (o menos si no hay tantas palabras)
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            result.add(list.get(i).getKey());
        }

        return result;
    }


    public static void main(String[] args) {
        String[] words = {"perro", "gato", "perro", "pepe", "perro", "gato", "perro", "pepe", "J","J","J", "J"};
        System.out.println(top3Words_usingPriorityQueue(words)); // [perro, gato, pepe]

        // Ejemplo de una priority Queue

        // Crear un max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Agregar elementos
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);
        maxHeap.offer(1);

        // Eliminar elementos en orden de prioridad
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // 20, 10, 5, 1
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    }


}
