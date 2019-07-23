package com.xia.structe.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SortTestHelper {

    /**
     * 生成具有n个长度的数组 其每个元素范围为[l,R]
     *
     * @param n 数组长度
     * @param L 左边
     * @param R 右边
     * @return 创建的数组
     */
    public static int[] generateRandomArray(int n, int L, int R) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (L + Math.random() * (R - L + 1));
        }
        return arr;
    }

    // 拷贝 深度克隆
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相同
     * 这里是为了 对比该排序算法是否正确
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较器
     * 利用牛皮的算法 进行排序 对比我们的排序算法
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static <T> void testSort(String sortName, Class<T> clazz, String methodName, int[] arr) {
        try {
            T instance = clazz.newInstance();
            Method method = clazz.getMethod(methodName, int[].class);
            long startTime = System.nanoTime();
            method.invoke(clazz, arr);
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.println(sortName + "算法花费了" + time / 1000 + "ms");
            int[] copyArray = copyArray(arr);
            comparator(copyArray);
            boolean equal = isEqual(arr, copyArray);
            if (!equal) {
                System.out.println("该算法出错");
            } else {
                System.out.println("该算法正确");
            }
            printArray(arr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
