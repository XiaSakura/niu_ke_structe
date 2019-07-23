package com.xia.structe.basic_class_01;

import com.xia.structe.utils.SortTestHelper;

/**
 * @author q9826 插入排序
 * 0-0 是可以不用排的 0-1进行排 小的放左边,然后0-2之间的数进行比较  2位置上的数 先和1位置的数比较如果小就交换 0和1 继续比较
 * 就相当于 手上有一副已经排好的牌 需要再拿一张新的牌  挨个进行比较 插进去
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];//记录当前需要插入的值
            int j; //需要保留最后要插入的位置
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }
            //找到需要插入的位置了 就是j
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(1000, 1, 10);
        SortTestHelper.testSort("插入排序", InsertSort.class, "insertSort", array);
    }

}
