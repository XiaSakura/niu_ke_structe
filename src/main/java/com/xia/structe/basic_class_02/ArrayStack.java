package com.xia.structe.basic_class_02;

import com.xia.structe.utils.SortTestHelper;

import java.util.Arrays;

/**
 * 利用数组结构实现固定的栈
 */
public class ArrayStack {
    private int[] arr;
    private int index;//用户想要新加一个数 需要放到哪个位置

    public ArrayStack(int initSize) {
        if (initSize <= 0) {
            throw new IllegalArgumentException("初始化大小0 出错");
        }
        arr = new int[initSize];
        index = 0;
    }

    /**
     * 插入操作
     *
     * @param num
     */
    public void push(int num) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("栈已满 已经不能插入了");
        }
        arr[index++] = num;
    }

    public int pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("栈空了 不能再弹出了");
        }
        return arr[--index];
    }

    public Boolean isEmpty(){
        if (index==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        while (!arrayStack.isEmpty()) {
            System.out.println("arrayStack = " + arrayStack.pop());
        }
    }
}
