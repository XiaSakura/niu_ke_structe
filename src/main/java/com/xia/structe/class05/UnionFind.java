package com.xia.structe.class05;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集的题
 */
public class UnionFind {
    private static class Node {
        //只是代表一个节点 里面的内容可以任意填
    }

    /**
     * 并查集的基本机构
     */
    public static class UnionFindSet {
        private HashMap<Node, Node> fatherMap; //前一个node是具体某一个节点 后一个node代表她的父亲
        private HashMap<Node, Integer> sizeMap; //sizeMap是某一个节点所属集合具体有多少个节点

        public UnionFindSet(List<Node> nodeList) {
            //初始化并查集 这一步是必须的
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            nodeList.forEach(node -> {
                //每一个节点都是一个集合 所以node的父亲是node 每一个node自己形成集合
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            });
        }

        /**
         * 找到代表节点
         *
         * @return
         */
        private Node findHead(Node node) {
            Node parent = fatherMap.get(node);
            if (parent != node) {
                //递归 直接找到他的父亲
                parent = findHead(parent);
            }
            //下面是扁平的操作
            fatherMap.put(node, parent);
            return parent;
        }

        public boolean isSameSet(Node node1, Node node2) {
            return findHead(node1) == findHead(node2);
        }

        public void union(Node a, Node b) {
            if (a == null && b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                //比较两个谁大
                Integer aSize = sizeMap.get(aHead);
                Integer bSize = sizeMap.get(bHead);
                if (aSize <= bSize) {
                    //a集合挂到b上面
                    fatherMap.put(aHead,bHead);
                    //b集合扩大
                    sizeMap.put(bHead,aSize+bSize);
                }else{
                    //a集合挂到b上面
                    fatherMap.put(bHead,aHead);
                    //b集合扩大
                    sizeMap.put(aHead,aSize+bSize);
                }
            }
        }

    }

}
