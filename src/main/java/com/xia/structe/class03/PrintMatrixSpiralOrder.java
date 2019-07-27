package com.xia.structe.class03;

/**
 * 转圈打印矩阵
 */
public class PrintMatrixSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }

    private static void spiralOrderPrint(int[][] arr) {
        //得到一开始的左上角的点和右下角的点
        int tR = 0, tC = 0, dR = arr.length - 1, dC = arr[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    //打印外圈 需要给我们左上角和右上角的两个点
    private static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            //处于同一行是一条横
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][dC] + " ");
            }
        } else {
            //真正的转圈打印矩阵
            //得到开始节点
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][curC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[curR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][curC] + " ");
                curR--;
            }
        }
    }
}
