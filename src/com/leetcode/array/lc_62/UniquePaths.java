package com.leetcode.array.lc_62;

/**
 * @Author zhuguoqing
 * @Description 动态规划：一个求最优解：背包问题，一个求方案数：比如这题
 * @Date 2021/12/9 8:47 下午
 * @Version 1.0
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
