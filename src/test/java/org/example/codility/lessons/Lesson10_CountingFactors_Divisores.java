package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 * Explicacion: dado un numero ejempo 16, la raiz cuadrada = 4, esto me da el maximo divisor independiente, a partir de ese punto simetrico, al dividir, obtengo del otro lado del igual
 * Un dividor mayor que surge del divisor meno
 */
public class Lesson10_CountingFactors_Divisores {

    public static int solution(int N){
        int numberOfDivisors = 0;
        int nSqrt = (int) Math.sqrt(N);

        for(int i=1;i<=nSqrt;i++){
            int remainder = N%i;
            if(remainder==0){
                int increment = i*i==N?1:2;
                numberOfDivisors+=increment;
            }
        }

        return  numberOfDivisors;
    }



    public static void main(String[] args) {
        System.out.println(solution(2) + " expected 2");
        System.out.println(solution(24) + " expected 8");
    }

}
