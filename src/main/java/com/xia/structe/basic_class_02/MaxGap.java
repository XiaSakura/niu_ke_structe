package com.xia.structe.basic_class_02;

import com.xia.structe.utils.SortTestHelper;

import java.util.Arrays;
import java.util.Collections;

/**
 * 如果排序之后,相邻两数的最大差值 使用桶结构
 */
public class MaxGap {

    /**
     * 返回相邻两数的最大差值
     *
     * @param arr
     * @return
     */
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找到最大和最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        //如果最大和最小相同 直接返回
        if (max == min) {
            return 0;
        }
        //创建三个N+1的数组
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            //我们需要知道arr[i]需要放到具体哪一个桶内 才好存放到相应的 数组里面
            int bucket = bucket(arr[i], len, min, max);
            maxs[bucket] = hasNum[bucket] ? Math.max(maxs[bucket], arr[i]) : arr[i];
            mins[bucket] = hasNum[bucket] ? Math.min(mins[bucket], arr[i]) : arr[i];
            hasNum[bucket] = true;
        }
        //计算出两桶最大差值
        int res = 0;
        int lastMax = maxs[0]; //我们需要拿到前一个桶的最大值 和后一个桶的最小值
        //遍历整个桶
        for (int i = 1; i <= len; i++) {
            //跳过空桶
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(int num, int len, int min, int max) {
        //范围 max-min
        return ((num - min) * (len)) / (max - min);
    }


    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, 1, 100);
        int maxGap = maxGap(array);
        Arrays.sort(array);
        SortTestHelper.printArray(array);
        System.out.println("maxGap = " + maxGap);
    }
}
