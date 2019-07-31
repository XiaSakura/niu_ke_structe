package com.xia.structe.class04;

import com.xia.structe.utils.PrintBinaryTree;

import java.util.Stack;

import static com.xia.structe.utils.PrintBinaryTree.Node;

/**
 * 使用递归的方式 打印二叉树
 */
public class PreInPosTraversal {

    /**
     * 先序递归遍历
     * 中 左 右
     *
     * @param head
     */
    private static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历
     * 左 中 右
     *
     * @param head
     */
    private static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    /**
     * 后序遍历
     * 左 中 右
     *
     * @param head
     */
    private static void afterOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        afterOrderRecur(head.left);
        afterOrderRecur(head.right);
        System.out.println(head.value);
    }

    private static void preOrderUnRecur(Node head) {
        System.out.println("pre-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                //弹出栈顶
                head = stack.pop();
                //打印
                System.out.println("head = " + head.value);
                //先压入右边 再压入右边
                if (head.right != null) {
                    stack.add(head.right);
                }
                if (head.left != null) {
                    stack.add(head.left);
                }
            }
        }
        System.out.println();
    }

    private static void inOrderUnRecur(Node head){
        if (head!=null) {
            Stack<Node> stack=new Stack<>();
            while (head!=null|| !stack.isEmpty()) {
                if (head!=null) {
                    //将左边界一直压下去
                    stack.push(head);
                    head=head.left;
                }else{
                    //右边界弹出
                    head = stack.pop();
                    System.out.println("head = " + head.value);
                    head=head.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        Node head = new PrintBinaryTree.Node(1);
        head.left = new PrintBinaryTree.Node(-222222222);
        head.right = new PrintBinaryTree.Node(3);
        head.left.left = new PrintBinaryTree.Node(Integer.MIN_VALUE);
        head.right.left = new PrintBinaryTree.Node(55555555);
        head.right.right = new PrintBinaryTree.Node(66);
        head.left.left.right = new PrintBinaryTree.Node(777);
        PrintBinaryTree.printTree(head);
        inOrderUnRecur(head);
    }
}
