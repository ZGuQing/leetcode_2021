package com.leetcode.array.lc_39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhuguoqing
 * @Description 组合总数
 * @Date 2021/12/5 9:38 下午
 * @Version 1.0
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, ans, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<Integer> combine, List<List<Integer>> ans, int idx) {
        if (idx == candidates.length) {     //第一种退出情况：数用完了
            return;
        }
        if (target == 0) {  //第二种退出情况：target == 0
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates, target, combine, ans, idx + 1); //第一种选择：直接跳过该数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], combine, ans, idx);   //第二种情况：可以无限重复
            combine.remove(combine.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] test = new int[]{2,3,6,7};
        int t = 7;
        combinationSum(test, t);
    }
}
