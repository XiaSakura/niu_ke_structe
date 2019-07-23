package com.xia.structe.basic_class_01;

import com.xia.structe.utils.SortTestHelper;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        __quickSort(arr, 0, arr.length - 1);
    }

    private static void __quickSort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        //我们需要知道 范围 因为这里是需要知道 大于区 小于区所在的范围
        //p[0]=less   p[1]=more
        int[] p = partition(arr, l, r);
        __quickSort(arr, l, p[0]);
        __quickSort(arr, p[1], r);
    }

    /**
     * 小于区 arr[l+1,less] 等于区arr[less+1,more-1] 大于区 arr[more,r];
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] partition(int[] arr, int l, int r) {
        //这里先使用 普通快速排序 以arr[l]为基点
        int v = arr[l];
        int i = l + 1; //i是当前正在考察的元素
        int less = l, more = r + 1;
        //定义i
        while (i < more) {
            if (arr[i] > v) {
                SortTestHelper.swap(arr, i, --more);
            } else if (arr[i] < v) {
                SortTestHelper.swap(arr, i++, ++less);
            } else if (arr[i] == v) {
                i++;
            }
        }
        //最后将 第一个位置 和在less位置进行交换
        SortTestHelper.swap(arr, l, less);
        return new int[]{less - 1, more};
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        SortTestHelper.testSort("快速排序", QuickSort.class, "quickSort", array);
    }
}
