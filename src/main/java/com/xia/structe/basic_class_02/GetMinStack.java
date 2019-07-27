package com.xia.structe.basic_class_02;

import java.util.Stack;

/**
 * 创建特殊的栈 实现返回栈中最小元素的操作
 */
public class GetMinStack {
    //准备两个栈 data栈和min栈
    //第一个压入4 data和min都压入4
    //第二个压入5 data压入5 但是min压入4 因为4比5小
    private Stack<Integer> stackData=new Stack<>();
    private Stack<Integer> stackMin=new Stack<>();


    public void push(int num) {
        if (stackMin.isEmpty()) {
            //直接压入
            stackMin.push(num);
        } else {
            Integer peek = stackMin.peek();
            int min = peek >= num ? num : peek;
            stackData.push(min);
        }
        stackData.push(num);
    }

    public int pop(){
        return stackData.pop();
    }

    public int getMin(){
        return stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack=new GetMinStack();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        int min = stack.getMin();
        System.out.println("min = " + min);
    }

}
