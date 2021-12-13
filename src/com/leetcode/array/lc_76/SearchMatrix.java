package com.leetcode.array.lc_76;

import org.junit.Test;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/9 9:58 下午
 * @Version 1.0
 */
public class SearchMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        //确定在哪一行
        int ro = row;
        for(int i = 0; i < row; i++) {
            if (target <= matrix[i][col - 1]) {
                ro = i;
                break;
            }
        }
        if (ro == row) {
            return false;
        }
        int l = 0, r = col;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[ro][mid] < target) {
                l = mid + 1;
            } else if (matrix[ro][mid] > target){
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 一次二分
     * @param
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            int x = matrix[mid / col][mid % col];   //二维下标映射
            if (target > x) {
                l = mid + 1;
            } else if (target < x) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int t = 3;
        searchMatrix1(matrix,t);
    }
}
