package com.xia.structe.basic_class_01;

import com.xia.structe.utils.SortTestHelper;

/**
 * 荷兰国旗 在10分钟 这里定义了两个区域 小于区和大于区
 */
public class NetherlandsFlag {

    /**
     * partition过程分区 根据num划分小于区和大于区
     *
     * @param arr
     */
    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1, more = r + 1;  //定义左右两个区的范围 就是小于区和大于区
        for (int i = 0; i < arr.length; i++) {
            if (arr[l] < num) {
                SortTestHelper.swap(arr, l, ++less);
            } else if (arr[l] > num) {
                SortTestHelper.swap(arr, l, --more);
            } else if (arr[l] == num) {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 10);
        partition(array, 0, array.length - 1, 5);
        SortTestHelper.printArray(array);
    }
}
