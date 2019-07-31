package com.xia.structe.class04;

import com.xia.structe.utils.PrintBinaryTree.Node;

/**
 * 计算出完全二叉树的节点个数 但是时间复杂度不能大于等于O(N)
 */
public class CompleteTreeNodeNumber {

    private static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLevelHigh(head, 1));
    }

    /**
     * @param node  当前节点
     * @param level 我们需要知道当前节点是第几层的
     * @param h     我们需要当前节点下面左子树的高度
     * @return
     */
    private static int bs(Node node, int level, int h) {
        System.out.println();
        //递归中止条件
        if (level == h) {//代表已经递归到了最后一层
            return 1;
        }
        //判断右子树的 最左边的节点 是否在最后一层 满足条件的情况下 左子树是满二叉树
        if (mostLevelHigh(node.right, level + 1) == h) {
            //左子树+递归右子树
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            //右子树是满的 +递归左子树
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    /**
     * 当前节点的左子树是完全二叉树的高度-1(不包括当前节点)  就是第几层到最后一层的左子树高度 level-1
     *
     * @return
     */
    private static int mostLevelHigh(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
