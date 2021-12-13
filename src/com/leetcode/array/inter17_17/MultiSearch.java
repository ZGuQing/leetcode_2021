package com.leetcode.array.inter17_17;

import java.util.*;

/**
 * @Author zhuguoqing
 * @Description 多次搜索-暴力
 * @Date 2021/12/7 8:01 下午
 * @Version 1.0
 */
public class MultiSearch {
    public int[][] multiSearch(String big, String[] smalls) {
        int m = big.length();
        int n = smalls.length;
        int[][] res = new int[n][];
        int[] nu = new int[10000];  //先存到一个一维数组中
        for (int i = 0; i < n; i++) {
            int lenS = smalls[i].length();
            if ("".equals(smalls[i])) {
                res[0] = new int[0];
                return res;
            }
            int idx = 0;
            for (int j = 0; j < m - lenS + 1; j++) {   //big
                if (big.substring(j,j + lenS).equals(smalls[i])) {
                    nu[idx++] = j;
                }
            }
            res[i] = new int[idx];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = nu[j];
            }
        }
        return res;
    }
}
