package com.xia.structe.class03;


/**
 * 反转单向和双向链表
 */
public class ReverseList {
    /**
     * 单向链表
     */
    public static class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseList(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void printNode(Node head) {
        while (head != null) {
            System.out.print(head.value + "| ");
            head = head.next;
        }
    }


    /**
     * 双向链表
     */
    public static class DoubleNode {
        public DoubleNode pre;
        public DoubleNode next;
        public int value;
        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static  DoubleNode reverseDoubleNode(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode next=null;
        while (head!=null) {
            next=head.next;
            pre=head;
            head.next=pre;
            head=next;
        }
        return pre;
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        printNode(head);
//        Node list = reverseList(head);
//        printNode(list);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.pre = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.pre = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.pre = head2.next.next;
        printDoubleLinkedList(head2);

    }
}
