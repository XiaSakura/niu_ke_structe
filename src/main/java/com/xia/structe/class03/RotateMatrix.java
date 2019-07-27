package com.xia.structe.class03;

import com.xia.structe.utils.SortTestHelper;

/**
 * 旋转矩阵
 */
public class RotateMatrix {

    private static void rotate(int[][] matrix) {
        int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dR - tR;
        for (int i = 0; i != times; i++) {
            int tmp = matrix[tR][tC + i];
            //13先和1 交换
            matrix[tR][tC + i] = matrix[dR - i][tC];
            //16和13交换
            matrix[dR - i][tC] = matrix[dR][dC - i];
            //4和16交换
            matrix[dR][dC - i] = matrix[tR + i][dC];
            //1和4交换
            matrix[tR + i][dC] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate(matrix);
        printMatrix(matrix);
    }
}
