package com.xia.structe.class03;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 利用hashMap
     * @param head
     * @return
     */
    public static Node copyListWithRandom01(Node head) {
        Node current=head;
        Map<Node,Node> nodeMap=new HashMap<>();
        //初始化map
        while (current!=null) {
            nodeMap.put(current,new Node(current.value));
            current=current.next;
        }
        //再次遍历链表 给next和rand赋值
        current=head;
        while (current!=null) {
            nodeMap.get(current).next=nodeMap.get(current.next);
            nodeMap.get(current).rand=nodeMap.get(current.rand);
            current=current.next;
        }

        return nodeMap.get(head);
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        printRandLinkedList(res1);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        printRandLinkedList(res1);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }
}
