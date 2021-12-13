package com.leetcode.array.lc_59;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/9 7:44 下午
 * @Version 1.0
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bot = n - 1;
        int num = 1;
        while (left <= right || top <= bot) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            for (int i = top + 1; i <= bot; i++) {
                res[i][right] = num++;
            }
            if (left < right && top < bot) {
                for (int i = right - 1; i > left; i--) {
                    res[bot][i] = num++;
                }
                for (int i = bot; i > top; i--) {
                    res[i][left] = num++;
                }
            }
            left++;
            right++;
            bot--;
            top++;
        }
        return res;
    }
}
