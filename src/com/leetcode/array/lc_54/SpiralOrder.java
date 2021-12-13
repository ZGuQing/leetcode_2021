package com.leetcode.array.lc_54;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/9 4:50 下午
 * @Version 1.0
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int left = 0, right = matrix[0].length - 1;
        int down = 0, up = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && down <= up) {
            //右移
            for (int i = left; i <= right; i++) {
                res.add(matrix[down][i]);
            }
            //下移
            for (int i = down + 1; i <= up; i++) {
                res.add(matrix[i][right]);
            }
            //只有一行或一列时，不能左移或下移
            if (left < right && down < up) {
                //左移
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[up][i]);
                }
                //上移
                for (int i = up; i > down; i--) {
                    res.add(matrix[i][left]);
                }
            }
            down++;
            right--;
            up--;
            left++;
        }
        return res;
    }
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);
    }
}
