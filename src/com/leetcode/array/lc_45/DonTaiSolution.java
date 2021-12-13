package com.leetcode.array.lc_45;

import java.util.Arrays;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/8 10:34 下午
 * @Version 1.0
 */
public class DonTaiSolution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果j能达到，且j当前位置+j位置数组的值超过i时，说明i可达，dp[i]存放可达的最小步数
                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
