package com.leetcode.array.lc_73;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/9 9:11 下午
 * @Version 1.0
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    set.add(new int[]{i, j});
                }
            }
        }
        for (int[] t : set) {
            int row = t[0], col = t[1];
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
