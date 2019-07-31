package com.xia.structe.class05;

import java.util.HashMap;

/**
 * 题目二
 * 设计RandomPool结构
 */
public class RandomPool {

    private static class Pool<T> {
        //这里的value是 存放的当前的size 为了知道当前存放第几个了 而且为了getRandom根据这个依据好取key
        private HashMap<T, Integer> map1;
        private HashMap<Integer, T> map2;
        private Integer size;

        public Pool() {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            this.size = 0;
        }

        public void insert(T key) {
            map1.put(key, size);
            map2.put(size, key);
            size++;
        }

        /**
         * 由于我们知道了 size的范围 所以可以根据这个来进行随机
         *
         * @param
         * @return
         */
        public T getRandom() {
            int random = (int) (Math.random() * size);
            return map2.get(random);
        }

        /**
         * 根据key来删除 由于我们的map里面的value是具有连贯性的 所以我们需要进行下面的操作
         *
         * @param key
         */
        public void delete(T key) {
            //当前需要删除的位置要和当前map最后size--进行交换 注意两个map都需要
            if (map1.containsKey(key)) {
                //得到需要删除的位置
                Integer deleteIndex = map1.get(key);
                //得到需要交换的位置
                T t = map2.get(--size);
                //进行交换 就是再插入 补全这个位置 防止出现空
                map1.put(t,deleteIndex);
                map2.put(deleteIndex,t);
                map1.remove(key);
                map2.remove(size);
            }
        }
    }

    public static void main(String[] args) {

    }
}
