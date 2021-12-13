package com.leetcode.array.lc_36;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author zhuguoqing
 * @Description 有效的数独
 * @Date 2021/12/5 8:28 下午
 * @Version 1.0
 */
public class IsValidShudu {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int idx = c - '1', boxIdx = i / 3 + (j / 3) * 3;
                if (row[i][idx] >= 1 || col[j][idx] >= 1 || box[boxIdx][idx] >= 1) {    //分别判断行，列和单元格是否有重复
                    return false;
                }
                row[i][idx]++;
                col[j][idx]++;
                box[boxIdx][idx]++;
            }
        }
        return true;
    }
}
