package com.matrix;

public class MatrixTrace {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int trace = 0;

        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        System.out.println("Trace of the matrix is: " + trace);
    }
}