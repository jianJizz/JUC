package com.usc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianjianDuan
 * @date 2021/7/11 5:34 下午
 */
public class H_274 {
    public static void main(String[] args) {
        int res = new H_274().hIndex(new int[]{3, 0, 6, 1, 5});
        System.out.println(res);
    }


    public int hIndex(int[] citations) {
        Set<Integer> set = new HashSet<>();
        int n = citations.length;
        int h = -1;
        Arrays.sort(citations);
        for(int i=0; i<n; i++) {
            if (set.contains(citations[i])) {
                continue;
            }
            int idx = leftBound(citations, citations[i]);
            if (idx < citations[i] && n-idx >= citations[i]){
                set.add(citations[i]);
                if (citations[i] > h) {
                    h = citations[i];
                }
            }
        }

        return h;
    }


    // 找左边界
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
}
