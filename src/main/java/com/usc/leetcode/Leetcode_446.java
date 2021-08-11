package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/8/11 9:37 上午
 */
public class Leetcode_446 {
    public static void main(String[] args) {
        int res = new Leetcode_446().numberOfArithmeticSlices(new int[]{-2147483648,0,-2147483648});
        System.out.println(res);
        long t = (long)-2147483648;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(t);
    }
    int res = 0;
    List<Integer> path = new ArrayList<>();
    public int numberOfArithmeticSlices(int[] nums) {
        dfs(nums, 0, new boolean[nums.length]);

        return res;
    }

    public void dfs(int[] nums, int startIndex, boolean[] visted) {
        if (path.size() >= 3) {
            res++;
        }

        for (int i=startIndex; i<nums.length; i++) {
            if (visted[i]) continue;
            if (path.size() >= 2) {
                int last = path.get(path.size()-1);
                int lastlast = path.get(path.size()-2);
                long diff = (long)last - (long)lastlast;
                long gap = (long)nums[i] - (long)last;
                if (gap != diff) continue;
            }
            path.add(nums[i]);
            visted[i] = true;
            dfs(nums, i, visted);
            path.remove(path.size()-1);
            visted[i] = false;
        }
    }
}
