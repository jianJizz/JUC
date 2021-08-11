package com.usc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/8/1 4:08 下午
 */
public class Leetcode_40 {
    public static void main(String[] args) {
//        new Leetcode_40().combinationSum2(new int[]{2,5,2,1,2}, 5);
        String s = "ab".substring(0, 1);
        System.out.println(s);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 深度 未知, 宽度 candidates.length
        // 回溯的参数和返回值
        // 递归终止条件 target == path.sum
        // 单层遍历逻辑
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, target, 0, 0, used); //sum 为当前路径数字的和, starIndex控制遍历的起始位置, used为同一层是否被使用过

        return res;
    }

    public void dfs(int[] candidates, int target, int sum, int starIndex, boolean[] used) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        Arrays.sort(candidates);
        for (int i=starIndex; i<candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) continue;
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            // 递归
            dfs(candidates, target, sum, i+1, used);
            // 回溯
            path.remove(path.size()-1);
            sum -= candidates[i];
            used[i] = false;
        }
    }
}
