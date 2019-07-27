package com.xia.structe.basic_class_02;

import lombok.Data;

import java.util.Stack;

/**
 * 利用两个栈 实现队列
 * 使用两个栈结构 push栈和pop栈 用户给我们的放到push栈 用户想要拿的放到pop栈 就相当于转换一下 就是队列了
 * 但是当pop栈里面 有数据的情况下 push栈不能倒给pop栈 需要把pop栈倒完
 * 还有个限制 需要将push栈一次倒完
 */
@Data
public class TwoStackQueue {
    private Stack<Integer> push;
    private Stack<Integer> pop;

    public TwoStackQueue() {
        this.push = new Stack<>();
        this.pop = new Stack<>();
    }

    public void push(int num) {
        //我们需要知道pop栈是否为空
        //所以这里有一个dao数据的操作 就是将push栈里面的数据往pop栈里面倒
        push.push(num);
        dao();
    }

    public void dao() {
        // 但是当pop栈里面 有数据的情况下 push栈不能倒给pop栈 需要把pop栈倒完
        if (!pop.isEmpty()) {
            return;
        }
        while (!push.isEmpty()) {
            pop.push(push.pop());
        }
    }

    public int poll() {
        dao();
        return pop.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue queue=new TwoStackQueue();
        queue.push(1);
        queue.push(2);
        int poll = queue.poll();
        System.out.println("poll = " + poll);
    }

}
