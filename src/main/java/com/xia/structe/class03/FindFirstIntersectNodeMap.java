package com.xia.structe.class03;

import java.util.HashSet;

/**
 * 这个使用了HashMao辅助空间的
 * 发现两个链表相交的第一个节点
 * 1)怎么判断一个单链表 有没有环
 * 2)怎么判断两个无环的单链表 相交的第一个节点
 * 3)怎么做到两个有环单链表 第一个相交的节点
 */
public class FindFirstIntersectNodeMap {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 得到相交的点
     *
     * @return
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //1)判断链表有没有环
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个链表都没有环
        if (loop1 == null && loop2 == null) {
            return bothNoLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    /**
     * 一共有三种情况
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        //当两个链表 入环的第一个点相同是第二种情况
        if (loop1 == loop2) {
            //将head1从未入环的(包括loop1) 之前的node加入到HashSet里面
            cur1 = head1;
            HashSet<Node> nodes = new HashSet<>();
            while (cur1 != loop1.next) {
                nodes.add(cur1);
                cur1 = cur1.next;
            }
            //判断nodes里面是否有head2里面的 肯定存在的
            cur2 = head2;
            while (cur2 != loop2.next) {
                if (nodes.contains(cur2)) {
                    return cur2;
                }
                cur2 = cur2.next;
            }
        } else {
            cur1 = loop1;
            //让loop1继续往下走 如果loop1都转回自己本来的位置了 还没有遇到loop2 就说明是第一种 否则是第三种
            while (cur1 != null) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        //第三种
        return null;
    }

    private static Node getLoopNode(Node head) {
        HashSet<Node> nodes = new HashSet<>();
        Node current = head;
        boolean flag = false; //是否有环
        while (current != null) {
            if (nodes.contains(current)) {
                flag = true;
                break;
            }
            nodes.add(current);
            current = current.next;
        }
        if (flag) {
            return current;
        }
        return null;
    }

    /**
     * 两个链表都没有环的情况
     * 使用map的方法 我们需要把head1 所有的节点 放到map里面去  然后遍历head2 每遍历一个节点就查询
     * 当前head2的节点是否在map里面 第一个在的就是第一个相交的点 反之 返回null
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node bothNoLoop(Node head1, Node head2) {
        HashSet<Node> nodes = new HashSet<>();
        Node current1 = head1;
        //将head1里面 放入nodes中
        while (current1 != null) {
            nodes.add(current1);
            current1 = current1.next;
        }
        //判断head2第一个与head1相交的点
        current1 = head2;
        boolean flag = false; //是否相交
        while (current1 != null) {
            if (nodes.contains(current1)) {
                flag = true;
                break;
            }
            current1 = current1.next;
        }
        if (flag) {
            return current1;
        }
        return null;
    }

    //1)判断一个单链表 有没有环
    public static void main(String[] args) {

        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
