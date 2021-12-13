package com.leetcode.array.lc_45;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/8 10:40 下午
 * @Version 1.0
 */
public class GreedySolution {
    public int jump1(int[] nums) {
        int position = nums.length - 1;
        int minStep = 0;
        while (position > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    minStep++;
                    break;
                }
            }
        }

        return minStep;
    }

    public int jump2(int[] nums) {
        int position = 0;
        int minStep = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == position) {
                position = maxPosition;
                minStep++;
            }
        }
        return minStep;
    }
}
