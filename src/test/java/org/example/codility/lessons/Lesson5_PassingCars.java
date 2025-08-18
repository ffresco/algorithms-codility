package org.example.codility.lessons;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 * Autos que se pasan es cuantas veces un auto que va al este cruza otros que van al oeste [0,1,0,1,1] aca hay 5 cruces
 * (0=Este, 1=oeste) primer 0, con 3 unos que siguen, el segunod cero, con los 2 unos que siguen
 * esto no es valdo [1,1,0] No hay ningún 0 antes de los 1, así que no se cuentan cruces.
 *  Entonces, solo se cuentan cruces de Este a Oeste, o sea:
 */
public class Lesson5_PassingCars {

    /**
     * Vamos aplicar el metodo de ir viendo un caso simple y codear de poco visto en la leccion aprendida
     * [0,1] i1: totalEste=1, i2: cruce=true, totalCruces+=totaleste
     *
     *
     * Conclusion
     * Tu enfoque original:
     * Para cada 0, buscar los 1 que vienen después → repite trabajo O(n*m).
     * Es más intuitivo al principio, pero menos eficiente.
     *
     * Este enfoque:
     * Para cada 1, sumar los 0 ya vistos → O(N), una sola pasada.
     **/
    public static int solution(int[] A){

        int totalCruces =0;
        int totalEste=0;
        boolean hayCruce = false;


        for (int i = 0; i < A.length; i++) {
            hayCruce= A[i] == 1;
            if (A[i] == 0)
                totalEste++;

            if(hayCruce)
                totalCruces+=totalEste;

        }


        return totalCruces;

    }



    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,0,1,1}) + " expected 5");

        // Leccion aprendida
        // me falto considerar esto del enunciado The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
        // eso requiere que cheque la suma y si llego a ese numero retornar -1

    }

}
