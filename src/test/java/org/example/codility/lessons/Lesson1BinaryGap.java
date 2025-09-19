package org.example.codility.lessons;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/

/**
 * This algorithm finds the length of the longest binary gap in a positive integer `n`.
 * A binary gap is a maximal sequence of consecutive zeros surrounded by ones in the binary representation of `n`.
 *
 * Steps:
 * 1. Converts `n` to its binary representation as an array of digits.
 * 2. Iterates through the array, counting zeros between ones.
 * 3. Stores the lengths of gaps found.
 * 4. Returns the length of the longest gap, or 0 if none exist.
 */
public class Lesson1BinaryGap {

    public static int solution(int n) {
        int [] number = convertToBinaryNumber(n);
        TreeSet<Integer> set = new TreeSet<>();
        int ones =0;

        for (int i = 0; i < number.length; i++) {
            int count = 0;
            while (number[i] == 0 && i +1 < number.length  )  {
                count++;
                i++;
            }

            if(count > 0 && number[i] == 1)
                set.add(count);

            if(number[i]==1)
                ones++;
        }

        if(set.size() > 0 && ones > 1)
            return set.last();

        return 0;
    }


    private static int[] convertToArray(String x) {
        int n = x.length();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            // Convierte el carácter dígito en su valor entero
            numbers[i] = Character.getNumericValue(x.charAt(i));
        }
        return numbers;
    }

    private static int[] convertToBinaryNumber(Integer number) {
        String binaryString = Long.toBinaryString(number);
        return convertToArray(binaryString);
    }

    public static void main(String[] args) {

        //System.out.println(convertToBinaryNumber(9000000));
       // System.out.println(solution(51712));
      //  System.out.println(solution(1041));
        System.out.println(solution(5) + " excpected 1");
        System.out.println(solution(2147483647) + " excpected 1");
        // lecciones aprendidas:
        // testear casos extremos minimo y maximo (esto es si me piden un caso controlar en 20, tengo que controlar el punto 20 = 19,20,21 y el borde minimo y superior del rango  ej 0 y 100
        // testear camino feliz, binary gap bien formado 101, excepcion binary gap mal formado: 100, 11
        // al usar indices de vectores siempre controlar i<length (siempre) en todo momento
        // los contadores se incrementan al final del ciclo del bucle despues de ejecutar logica nunca antes y se resetean antes de inicar el ciclo
        // errores que tuve: no controle los gaps cerrados, o sea conte 100 como gap sin chequear el 1 detras 1001
        // confunid <= con <, en vez de poner x > 1 o x >= 2, puse x > 1

    }

}

