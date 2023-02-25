package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[] newMatrixOne = new int[matrix[0].length];
        int[][] newMatrixTwo = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrixOne[j] = matrix[i][j];
            }
            for (int k = 0; k < matrix[0].length; k++) {
                newMatrixTwo[k][i] = newMatrixOne[k];
            }
        }
        return newMatrixTwo;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
