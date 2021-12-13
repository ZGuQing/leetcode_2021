package com.leetcode.array.lc17_23;

import org.junit.Test;

/**
 * @Author zhuguoqing
 * @Description
 * @Date 2021/12/4 4:07 下午
 * @Version 1.0
 */
public class FindSquare {
    public int[] findSquare(int[][] matrix) {
        int len1 = matrix.length, len2 = matrix[0].length;
        int[][] maxRow = new int[len1][len2];
        int[][] maxCol = new int[len1][len2];

        for (int r = len1 - 1; r >= 0; --r) {
            for (int c = len2 - 1; c >= 0; --c) {
                if (matrix[r][c] == 0) {
                    maxRow[r][c] = 1;
                    if (c < len2 - 1) {
                        maxRow[r][c] += maxRow[r][c + 1];
                    }
                    maxCol[r][c] = 1;
                    if (r < len1 - 1) {
                        maxCol[r][c] += maxCol[r + 1][c];
                    }
                }
            }
        }
        int[] res = new int[3];
        for (int r = 0; r < len1; r++) {
            for (int c = 0; c < len2; c++) {
                if(matrix[r][c] == 0) {
                    int upper = Math.min(maxRow[r][c], maxCol[r][c]);
                    int bound = res[2]; //上次的最大size
                    for (int size = upper; size > bound; size--) {
                        if (maxRow[r + size - 1][c] >= size && maxCol[r][c + size - 1] >= size) {
                            res[0] = r;
                            res[1] = c;
                            res[2] = size;
                            break;  //最大边结束
                        }
                    }
                }
            }
        }
        if(res[2] == 0) return new int[]{};
        return res;
    }

    @Test
    public void test() {
        int[][] m = new int[][]{{1,0,1},{0,0,1},{0,0,1}};
        int[] square = findSquare(m);
        for (int i = 0; i < square.length; i++) {
            System.out.println(square[i]);
        }
    }
}
