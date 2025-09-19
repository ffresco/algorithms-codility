package org.example.others;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * DFS BFS
 *
 *
 *
 */
public class CodeSnippets {




    public static void main(String[] args) {

        //1-Extract a substring
        String text = "Hello World";
        String subtext = text.substring(0, 5); // "Hello" // substring(beginIndex, endIndex) where endIndex is exclusive


        //2-Convert comma-separated string to int array
        String numberStr = "1,2,3,4,5";
        String[] parts = numberStr.split(",");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        //3-Using streams
        int[] numbersStream = Arrays.stream(numberStr.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        //4- Create and iterate through a map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        // Using entrySet
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Using keySet
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        //5-Stream operations
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        //5-Filter and transform
                List<String> filtered = names.stream()
                        .filter(s -> s.length() > 3)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        // Numeric operations
                List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
                int sum = nums.stream().mapToInt(Integer::intValue).sum();
                OptionalInt max = nums.stream().mapToInt(Integer::intValue).max();


        //6-Define predicates
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<String> startsWithA = s -> s.startsWith("A");

        // Using predicates with streams
                List<Integer> numbersLists = Arrays.asList(1, 2, 3, 4, 5);
                List<Integer> evenNumbers = numbersLists.stream()
                        .filter(isEven)
                        .collect(Collectors.toList());

        // Combining predicates
                Predicate<Integer> greaterThan3 = n -> n > 3;
                List<Integer> evenAndGreaterThan3 = numbersLists.stream()
                        .filter(isEven.and(greaterThan3))
                        .collect(Collectors.toList());




    }

}

