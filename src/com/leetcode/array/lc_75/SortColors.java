package com.leetcode.array.lc_75;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/10 5:35 下午
 * @Version 1.0
 */
public class SortColors {
    public void sortColors1(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i <= p2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }

    }
}
