package com.xia.structe.class04;

import com.xia.structe.utils.PrintBinaryTree.Node;

import java.util.*;

/**
 * BST是平衡二叉树
 * CBT是完全二叉树
 */
public class IsBSTAndCBT {

    public static boolean isBST(Node head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        //我们利用中序遍历 左 中 右是升序的方式 进行判断
        inOrderRecur(head, nodes);
        ArrayList<Integer> clone = ((ArrayList<Integer>) nodes.clone());
        Collections.sort(nodes);
        if (nodes.toString().hashCode() == clone.toString().hashCode()) {
            return true;
        }
        return false;
    }

    private static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> nodes = new LinkedList<>();
        boolean leaf = false;//是否是叶子节点
        Node l = null;
        Node r = null;
        nodes.offer(head);
        while (!nodes.isEmpty()) {
            head = nodes.poll();
            l = head.left;
            r = head.right;
            //下面的条件是不满足满二叉树的综合条件
            if (leaf && (l != null && r != null) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                nodes.offer(l);
            }
            if (r != null) {
                nodes.offer(r);
            }
            if (l == null || r == null) {
                leaf=true;
            }
        }
        return true;
    }

    private static void inOrderRecur(Node head, ArrayList<Integer> nodes) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left, nodes);
        nodes.add(head.value);
        inOrderRecur(head.right, nodes);
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        System.out.println(isCBT(head));
    }
}
