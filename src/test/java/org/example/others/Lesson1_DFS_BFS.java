package org.example.others;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * DFS BFS
 *
 *
 *
 */
public class Lesson1_DFS_BFS {

    public static String LEFT = "left";
    public static String RIGHT = "right";
    public static String UP = "up";
    public static String DOWN = "down";

    public static String dfs(String[][] matrix){
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        Deque<int[]> stack = new ArrayDeque<>();
        int[] nodo = {0,0};
        // ojo si lo agrego a el stack ya se considera visitado (si no puedo agregarlo dos veces)
        visited[nodo[0]][nodo[1]] = true;
        stack.push(nodo);
        String result = "";

        while(!stack.isEmpty()){
            nodo = stack.pop();
            result += " -->" + matrix[nodo[0]][nodo[1]];
            // obtain neighbors
            int[] leftNodo = getNeighbor(nodo,matrix,LEFT,visited);
            int[] rightNodo = getNeighbor(nodo,matrix,RIGHT,visited);
            int[] upNodo = getNeighbor(nodo,matrix,UP,visited);
            int[] downNodo = getNeighbor(nodo,matrix,DOWN,visited);

            if (upNodo != null) {
                stack.push(upNodo);
                visited[upNodo[0]][upNodo[1]] = true;
            }
            if (leftNodo != null) {
                stack.push(leftNodo);
                visited[leftNodo[0]][leftNodo[1]] = true;
            }
            if (rightNodo != null) {
                stack.push(rightNodo);
                visited[rightNodo[0]][rightNodo[1]] = true;
            }
            if (downNodo != null) {
                stack.push(downNodo);
                visited[downNodo[0]][downNodo[1]] = true;
            }


        }
        return  result;
    }



    public static String bfs(String[][] matrix){
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] nodo = {0,0};
        // ojo si lo agrego a el stack ya se considera visitado (si no puedo agregarlo dos veces)
        visited[nodo[0]][nodo[1]] = true;
        queue.offer(nodo);
        String result = "";

        while(!queue.isEmpty()){
            nodo = queue.poll();
            result += " -->" + matrix[nodo[0]][nodo[1]];
            // obtain neighbors
            int[] leftNodo = getNeighbor(nodo,matrix,LEFT,visited);
            int[] rightNodo = getNeighbor(nodo,matrix,RIGHT,visited);
            int[] upNodo = getNeighbor(nodo,matrix,UP,visited);
            int[] downNodo = getNeighbor(nodo,matrix,DOWN,visited);

            if (rightNodo!= null) {
                queue.offer(rightNodo);
                visited[rightNodo[0]][rightNodo[1]] = true;
            }
            if (leftNodo!= null) {
                queue.offer(leftNodo);
                visited[leftNodo[0]][leftNodo[1]] = true;
            }
            if (upNodo!= null) {
                queue.offer(upNodo);
                visited[upNodo[0]][upNodo[1]] = true;
            }
            if (downNodo!= null) {
                queue.offer(downNodo);
                visited[downNodo[0]][downNodo[1]] = true;
            }

        }
        return  result;
    }


    private static int[] getNeighbor(int[] nodo, String[][] matrix, String direction, boolean[][] visited) {
        int row = nodo[0];
        int col = nodo[1];
        int newRow=row, newCol=col;
        if (direction.equals(LEFT)) {
            newCol = col-1;
            if (newCol<0)
                return null;
        }
        if (direction.equals(RIGHT)) {
            newCol = col+1;
            if (newCol>matrix[0].length-1)
                return null;
        }
        if (direction.equals(UP)) {
            newRow = row-1;
            if (newRow<0)
                return null;
        }
        if (direction.equals(DOWN)) {
            newRow = row+1;
            if (newRow>matrix.length-1)
                return null;
        }
        if (!visited[newRow][newCol]){
            return new int[]{newRow, newCol};
        }

        return null;
    }





    public static void main(String[] args) {

        String [][] matrix = {{"A","B","C","D"},
                              {"F","G","H","I"},
                              {"J","K","L","X"},
                              {"M","N","O","P"}};
        System.out.println(dfs(matrix) + " expected a e i m n o p l h d c g k f b ");
        System.out.println(bfs(matrix)+ "  expected a b e c f i d g j m h k n l o p");
    }

}

