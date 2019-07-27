package com.xia.structe.basic_class_02;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import lombok.Data;

/**
 * 利用数组实现队列
 * start和end一开始都指向0位置
 * end代表新加 如果新加入一个数 我们需要把这个数放到哪个位置上
 * start代表如果拿取一个数 需要把哪个数给用户
 * size约束 end和start  就是例如整个数组长度为3
 * 如果size<3 那么就将新加入的数放到end上去
 * 如果size!=0 那么就把start指的数 给用户
 */
@Data
public class ArrayQueue {
    private int[] arr;
    private int start;
    private int end;
    private int size;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("数组初始化长度要大于0");
        }
        arr = new int[initSize];
        start = end = size = 0;
    }

    /**
     * 插入操作
     *
     * @param num
     */
    public void push(int num) {
        if (size >= 3) {
            throw new ArrayIndexOutOfBoundsException("队列已满 请勿继续插入");
        }
        arr[end++] = num;
        size++;
        //当end已经到了 数组的末尾 转向
        if (end == arr.length ) {
            end = 0;
        }
    }

    public int pop() {
        if (size <= 0) {
            throw new ArrayIndexOutOfBoundsException("队列为空");
        }
        int i = arr[start++];
        size--;
        if (start == arr.length) {
            start = 0;
        }
        return i;
    }

    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("queue = " + queue);
        while (!queue.isEmpty()) {
            int pop = queue.pop();
            System.out.println("pop = " + pop);
        }
    }
}
