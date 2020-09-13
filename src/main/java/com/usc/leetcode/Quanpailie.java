package com.usc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianjianduan
 * @date 2020/9/13 11:24 下午
 * 全排列问题
 *
 * 回溯算法框架

// for 选择 in 选择列表:
// # 做选择
// 将该选择从选择列表移除
// 路径.add(选择)
// backtrack(路径, 选择列表)
// # 撤销选择
// 路径.remove(选择)
// 将该选择再加入选择列表
 */
public class Quanpailie {

    public static void main(String[] args) {

    }


    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(nums, track);

        return ans;
    }

    public void dfs(int[] nums, LinkedList<Integer> track){
        // 结束条件 数字全部被选择过了
        if (track.size() == nums.length) {
            ans.add(new LinkedList(track));
            return;
        }
        // 遍历选择列表
        for(int i=0; i<nums.length; i++){
            if (track.contains(nums[i])) continue;
            // 做选择
            track.add(nums[i]);
            //继续下一层
            dfs(nums, track);
            // 下一层完成后回溯
            // 移除选择过的元素
            track.removeLast();
        }
    }
}
