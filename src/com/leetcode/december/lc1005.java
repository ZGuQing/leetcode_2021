package com.leetcode.december;

import org.junit.Test;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/3 2:05 下午
 * @Version 1.0
 */
public class lc1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 每次选择最小的数进行翻转
        int sum = 0;
        int[] count = new int[201];  //取值区间-100～100
        for(int t: nums) {
            count[t + 100]++;   //将取值区间映射到0～200
        }
        int i = 0;
        while (k > 0) {
            while (count[i] == 0) {
                i++;    //找到最小的数
            }
            count[i]--;
            count[200 - i]++;
            if (i > 100) {
                i = 200 - i;
            }
            k--;
        }
        for(int j = i; j < count.length; j++) {
            sum += (j - 100) * count[j];    //j是值大小，count是个数
        }
        return sum;
    }

    public int largestSumAfterKNegations1(int[] nums, int k) {
        // 每次选择最小的数进行翻转
        int sum = 0;
        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            // 找到最小的数
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] < min) {
                    min = nums[i];
                    idx = i;
                }
            }
            nums[idx] = -nums[idx];
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, -1, 0, 2};
        int k = 3;
        int i = largestSumAfterKNegations(nums, k);
        System.out.println(i);
    }
}
