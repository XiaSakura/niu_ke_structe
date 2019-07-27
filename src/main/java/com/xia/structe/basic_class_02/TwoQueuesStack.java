package com.xia.structe.basic_class_02;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈结构
 */
@Data
public class TwoQueuesStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueuesStack() {
        this.data = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int num) {
        data.add(num);
    }

    public int pop() {
        //先将data队列里面的除了第一个其它的所有数据放入第一个
        while (data.size()>1){
            help.add(data.poll());
        }
        int res=data.poll();
        swap();
        return res;
    }

    public void swap() {
        Queue<Integer> tmp = help;
        help = data;
        data = tmp;
    }

    public static void main(String[] args) {
        TwoQueuesStack stack=new TwoQueuesStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int pop = stack.pop();
        System.out.println("pop = " + pop);
    }

}
