package com.xia.structe.class03;

import java.util.Stack;

/**
 * 判断一个链表是不是回文结构
 */
public class IsPalindromeList {

    public static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用栈 作为辅助空间
     *
     * @return
     */
    private static boolean isPalindromeList01(Node head) {
        Stack<Node> help = new Stack<>();
        Node cur = head;
        //压入栈中
        while (cur != null) {
            help.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != help.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 不使用额外空间 使用快慢指针
     *
     * @param head
     * @return
     */
    private static boolean isPalindromeList03(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;//n1是慢指针
        Node n2 = head;//n2是快指针
        //找到中间节点 防止快指针越界
        //当结束的时候 n2已经来到了末尾 n1来到了中间位置
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next; //我们需要拿到右半部分
        n1.next = null;//mid.next -> null
        Node n3 = null;
        //将右半部分倒叙
        while (n2 != null) {
            //在头节点改变之前，先获取下一个节点的指针
            n3 = n2.next;
            //头节点的下一个节点要改成它的上一个节点，是一个逆转的过程
            n2.next = n1;
            //上一个节点前移指向头节点
            n1 = n2;
            //头节点前移指向下一个节点
            n2 = n3;
        }
        n3 = n1; // n3 -> save last node  当上面的循环完 n1会存放最后的节点 因为此时n2是空的 因为n1要动 所以用n3记录下 之后好倒序回来
        n2 = head;// n2 -> left first node
        boolean res = true;
        //当n1和n2不为空时 检查是否回文
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        //设置末尾
        n1 = n3.next;
        n3.next = null;
        //对有部分进行复原
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeList01(head) + " | ");
        System.out.println(isPalindromeList03(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }
}
