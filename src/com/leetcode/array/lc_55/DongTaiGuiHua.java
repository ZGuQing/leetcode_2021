package com.leetcode.array.lc_55;

import java.util.Arrays;

/**
 * @Author zhuguoqing
 * @Description 动态规划：dp[i]判断每个位置是否可达
 * @Date 2021/12/8 10:05 下午
 * @Version 1.0
 */
public class DongTaiGuiHua {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果j能达到，且j当前位置+j位置数组的值超过i时，说明i可达，dp[i] = true
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

}
