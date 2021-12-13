package com.leetcode.array.lc_63;

/**
 * @Author zhuguoqing
 * @Description 跳跃游戏f[i][j]表示：从[0,0]-[i][j]所需要的最大的不同路径数。
 * @Date 2021/12/9 8:39 下午
 * @Version 1.0
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                f[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                f[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = Math.max(f[i - 1][j] + f[i][j - 1], f[i][j]);
                } else {
                    f[i][j] = 0;
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
