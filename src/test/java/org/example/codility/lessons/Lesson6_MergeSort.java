package org.example.codility.lessons;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/
 */
public class Lesson6_MergeSort {

    public static int[] solution(int[] A){
        return sort(A);
    }

    private static int[] sort(int[] a) {
        if(a == null || a.length == 1) return a;

        int mid = a.length/2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        int[] sortedLeft = sort(left);
        int[] sortedRight = sort(right);
        int[] merged = merge(sortedLeft,sortedRight);
        return merged;

    }

    private static int[] merge(int[] sortedLeft, int[] sortedRight) {
        int[] merged = new int[sortedLeft.length + sortedRight.length];
        int i = 0, j = 0, x=0;
        while(i < sortedLeft.length && j < sortedRight.length) {
            if(sortedLeft[i] <= sortedRight[j]) {
                merged[x] = sortedLeft[i];
                i++;
            }else{
                merged[x] = sortedRight[j];
                j++;
            }
            x++;
        }
        while(i < sortedLeft.length) {
            merged[x] = sortedLeft[i];
            i++;
            x++;
        }
        while(j < sortedRight.length) {
            merged[x] = sortedRight[j];
            j++;
            x++;
        }
        return merged;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5,3,10,9,4,2,1})) + " expected ordenada");


    }

}
