package com.xia.structe.class04;

import com.xia.structe.utils.PrintBinaryTree.Node;

/**
 * 判断一个树是否是平衡二叉树
 */
public class IsBalanceTree {
    private static class ReturnData {
        public boolean isB; //是否平衡
        public int h; //树的高度

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isBalanceTree(Node node) {
        ReturnData returnData = process(node);
        return returnData.isB;
    }

    private static ReturnData process(Node head) {
        if (head == null) {//空树是平衡的
            return new ReturnData(true, 0);
        }
        ReturnData leftData=process(head.left);
        if (!leftData.isB) {
            return new ReturnData(false,0);
        }
        ReturnData rightData=process(head.right);
        if (!rightData.isB) {
            return new ReturnData(false,0);
        }
        //当左子树和右子树高度之差大于1 说明不是平衡树
        if (Math.abs(leftData.h-rightData.h)>1) {
            return new ReturnData(false,0);
        }

        return new ReturnData(true,Math.max(leftData.h,rightData.h)+1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.right = new Node(8);
        head.right.right.right.right = new Node(8);
        System.out.println("该树是否是平衡的:" + isBalanceTree(head));
    }
}
