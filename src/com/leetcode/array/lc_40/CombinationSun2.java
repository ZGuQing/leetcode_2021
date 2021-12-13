package com.leetcode.array.lc_40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhuguoqing
 * @Description 组合总和2
 * @Date 2021/12/5 10:21 下午
 * @Version 1.0
 */
public class CombinationSun2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, list, ans, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<Integer> combine, List<List<Integer>> ans, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i-1])
                continue;
            if(target - candidates[i] >= 0) {
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], combine, ans, i + 1); //第一种选择：加入该数
                combine.remove(combine.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] test = new int[]{10,1,2,7,6,1,5};
        int t = 8;
        combinationSum2(test, t);
    }
}
