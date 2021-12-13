package com.leetcode.array.inter17_14;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/8 9:10 下午
 * @Version 1.0
 */
public class HeapSolution {
    public int[] smallestK(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        //维护一个k个数的大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {    //当堆顶大于该数时，堆顶出队，该数入队，知道前k个数为最小的k个数。
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
