package com.xia.structe.test;

public class Test01 {
    public static void main(String[] args) {
//        int divide = divide(1, 5);
//        System.out.println("divide = " + divide);
        int[] arr = new int[]{1, 2};
        arr[0] = (arr[0] | (1 << 16));
        System.out.println(arr[0]);
    }

    public static int divide(int l, int r) {
        //首先构造l..r范围的数
        StringBuffer str = new StringBuffer("");
        int count = 0; //记录需要区间内能被3整除的数
        for (int i = 1; i <= r; i++) {
            //如果 1~l之间
            if (i < l) {
                str.append(i);
            } else {
                //l~r之间
                str.append(i);
                Integer integer = Integer.valueOf(str.toString());
                if (integer % 3 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}