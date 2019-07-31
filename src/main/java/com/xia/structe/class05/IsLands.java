package com.xia.structe.class05;

/**
 * 岛问题
 */
public class IsLands {

    public static int countIslands(int[][] matrix) {
        int row = matrix.length;//得到行
        int col = matrix[0].length;//得到列
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    //感染函数
                    infect(matrix, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 感染函数 将小岛周围感染成2
     *
     * @param matrix
     * @param i
     * @param j
     */
    private static void infect(int[][] matrix, int i, int j) {
        //感染上下左右的位置为2 注意防止越界 而且只感染==1的
        //baseCase
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1) {
            return;
        }
        matrix[i][j]=2;
        //将 上下左右如果==1的区域 感染为2
        infect(matrix, i + 1, j);
        infect(matrix, i -1, j);
        infect(matrix, i , j+1);
        infect(matrix, i, j-1);

    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));
    }

}
