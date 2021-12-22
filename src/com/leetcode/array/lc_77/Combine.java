package com.leetcode.array.lc_77;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    private void dfs(int i, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(j + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
