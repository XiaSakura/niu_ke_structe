package com.xia.structe.basic_class_01;

import com.xia.structe.utils.SortTestHelper;

/**
 * 归并排序
 * 先使用递归进行拆分 再归并
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        __mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 先进行递归拆分 再进行merge
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void __mergeSort(int[] arr, int l, int r) {
        //结束条件
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        __mergeSort(arr, l, mid);
        __mergeSort(arr, mid + 1, r);
        //真正的归并过程 当已经拆分到不能拆的时候 调用
        __merge(arr, l, mid, r);
    }

    private static void __merge(int[] arr, int l, int mid, int r) {
        //我们需要利用aux辅助数组 先将arr[l,r]里面拷贝一份 便于之后的操作
        int[] aux = new int[r - l + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = arr[l + i];
        }
        //我们需要获取 aux左边的数组 从i开始 aux右边的数组 从j开始
        int i = l, j = mid + 1;

        //给arr[l,r]里面 进行外排
        for (int k = l; k <= r; k++) {
            //还需要先判断是否越界
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {//说明左边的数组 比右边的数组小
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        SortTestHelper.testSort("归并排序", MergeSort.class, "mergeSort", array);
    }

}
