package com.xia.structe.class03;

/**
 * 之字形打印矩阵
 */
public class ZigZagPrintMatrix {

    public static void zigZagPrint(int[][] arr) {
        //设置两个点 a b 一开始都是在(0,0)
        int ax = 0; //a的横坐标
        int ay = 0;//a的纵坐标
        int bx = 0;
        int by = 0;
        //结束点
        int endY = arr.length - 1;
        int endX = arr[0].length - 1;
        boolean fromUp = false;//是否从上方开始打印
        while (ay != endY + 1) {
            printLevel(arr, ay, ax, by, bx, fromUp);
            ax = ax == endX ? ax : ax + 1;
            ay = ax == endX ? ay + 1 : ay;
            bx = by == endY ? bx + 1 : bx;
            by = by == endY ? by : by + 1;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        zigZagPrint(matrix);
    }
}
