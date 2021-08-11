package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/7/30 11:41 下午
 */
public class Leetcode_77 {

    public static void main(String[] args) {
        Leetcode_77.combine(4, 2);
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> paths = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        // 1. 回溯函数的返回值和参数 n k startIndex(本层选了哪个数)
        // 2. 回溯函数的终止条件    当path的size==k时说明到达了叶子节点
        // 3. 回溯函数的搜索遍历过程

        backTrack(n, k, 1);

        return res;
    }

    public static void backTrack(int n, int k, int startIndex) {
        if (paths.size() == k) {
            res.add(new ArrayList<>(paths));
            return;
        }
        for (int i=startIndex; i<=n; i++) {
            paths.add(i);
            backTrack(n, k, i+1);
            // 撤销选择
            paths.remove(paths.size()-1);
        }
    }
}
