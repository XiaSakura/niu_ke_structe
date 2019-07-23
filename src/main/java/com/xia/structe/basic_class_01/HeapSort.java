package com.xia.structe.basic_class_01;

import com.xia.structe.utils.SortTestHelper;

/**
 * 堆排序 大根堆
 * 建立大根堆的过程 就是进行堆排序 但是这是从大到小
 * 注意此大根堆的数组索引是从0开始的
 * 左节点 2*i+1
 * 右节点 2*i+2
 * 父节点 (index-1)/2
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //首先构造大根堆0~i之间 注意构造出来的大根堆是无序的
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //我们利用heapify 将堆顶arr[0]和 arr[heapSize-1]进行交换 这样最大的就排到数组的后面 从小到大
        int heapSize = arr.length;
        while (heapSize > 0) {
            SortTestHelper.swap(arr, 0, heapSize-1);
            heapify(arr, 0, --heapSize);
        }


    }

    /**
     * heapify就是 当数组当中某个值变小 往下沉 怎么重新转换成大根堆
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        //得到该节点的左孩子
        int left = index * 2 + 1;
        while (left < heapSize) {
            //比较左孩子和右孩子谁大
            int right = left + 1;
            int largest;
            if (right >= heapSize) {
                largest = left;
            } else {
                largest = arr[left] >= arr[right] ? left : right;
            }
            if (arr[index] < arr[largest]) {
                //交换
                SortTestHelper.swap(arr, index, largest);
                //更新index
                index = largest;
                left = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 向上插入的过程 如果当前节点比父节点大就交换
     *
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        //当其节点大于他的父节点时 交换
        while (arr[index] > arr[(index - 1) / 2]) {
            SortTestHelper.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        SortTestHelper.testSort("堆排序", HeapSort.class, "heapSort", array);
    }
}
