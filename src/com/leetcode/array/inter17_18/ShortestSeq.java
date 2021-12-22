package com.leetcode.array.inter17_18;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhuguoqing
 * @Description 最短超串
 * @Date 2021/12/7 3:36 下午
 * @Version 1.0
 */
public class ShortestSeq {
    public int[] shortestSeq(int[] big, int[] small) {
        int n = big.length;
        int diff = small.length;    //记录需要覆盖的字符个数
        int[] res = {};
        Map<Integer, Integer> map = new HashMap<>();
        //small数组不重复
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], 1);
        }
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {
            int x = big[right];
            if (map.containsKey(x)) {
                if (map.get(x) > 0) {
                    diff--;
                }
                map.put(x, map.get(x) - 1);
            }

            while (diff == 0) { //big中找到一个子串，压缩左端点
                if (right - left < min) {
                    min = right - left;
                    res = new int[]{left, right};
                }
                int y = big[left];
                if (map.containsKey(y)) {
                    map.put(y, map.get(y) + 1);
                    if (map.get(y) > 0) {
                        diff++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
