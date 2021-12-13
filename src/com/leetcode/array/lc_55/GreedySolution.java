package com.leetcode.array.lc_55;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/8 9:53 下午
 * @Version 1.0
 */
public class GreedySolution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;  //维持一个可以到达的最远位置
        for (int i = 0; i < n; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

}
