package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 * Aca modifique el algoritmo de kadane para que ademas de calcular la suma maxima, me de el mejor momento para comprar y vender una accion
 *
 */
public class Lesson9_MaximumSliceProblem_A_Kadane {

    public static int solution(int[] A){
        // la mejor opcion
        int maxProfit=0;
        int diaCompra=0;
        int diaVenta=0;

        // el intermedio
        int precioMinimo =A[0];
        int posibleMejorDiaCompra=0;

        for (int i=1; i<A.length; i++){
            int profitEndingHere=A[i]-precioMinimo;

            if (profitEndingHere>maxProfit){
                maxProfit=profitEndingHere;
                diaVenta=i;
                diaCompra=posibleMejorDiaCompra;
            }

            if(A[i] < precioMinimo){
                precioMinimo=A[i];
                posibleMejorDiaCompra=i;
            }
        }
        return  maxProfit;
    }



    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}) + " expected 5");
    }

}
