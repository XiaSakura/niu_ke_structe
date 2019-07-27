package com.xia.structe.class03;

import com.xia.structe.utils.SortTestHelper;

import java.util.LinkedList;

/**
 * 链表的荷兰国旗问题
 */
public class SmallerEqualBigger {
    public static class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 将链表改成链表数组 还是利用之前的方法进行 分区
     *
     * @param head
     * @param num
     * @return
     */
    public static Node listPartition1(Node head, int num) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        //我们需要找到数组的初始大小是多少
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        //初始化链表数组
        Node[] nodeArr = new Node[i];
        //赋值
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        //partition过程 和我们之前写的荷兰国旗差不多
        arrPartition(nodeArr, num);
        //还原链表
        for (i=1;i<=nodeArr.length-1;i++){
            nodeArr[i-1].next=nodeArr[i];
        }
        //最后一个
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    /**
     * 对数组进行partition
     *
     * @param arr
     * @param num
     */
    private static void arrPartition(Node[] arr, int num) {
        int less = -1;
        int more = arr.length;
        int index = 0;
        while (index != more) {
            if (arr[index].value < num) {
                swap(arr, ++less, index);
            } else if (arr[index].value == num) {
                index++;
            } else if (arr[index].value > num) {
                swap(arr, --more, index);
            }
        }
    }

    private static void swap(Node[] arr, int l, int r) {
        Node tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 5);
        printLinkedList(head1);
    }
}
