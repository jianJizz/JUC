package com.usc.leetcode;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] ints = SearchRange.searchRange1(new int[]{2,2}, 1);
        System.out.println(Arrays.toString(ints));

    }


    //O(n)算法
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int start = -1;
        int end = -1;
        boolean isFrist = true;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                start = isFrist ? i : start;
                isFrist = false;
                start = Math.min(start, i);
                end = Math.max(end, i);
            }

        }
        ans[0] = start;
        ans[1] = end;
        return ans;
    }


    //log n算法
    //TODO: 继续完成 这个二分法有点问题
    public static int[] searchRange1(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return ans;
        if (nums.length == 1)
            return nums[0] == target ? new int[]{0,0} : ans;
        int start = -1;
        int end = -1;
        boolean isFrist = true;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right && left < len && right <= len) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                start = isFrist ? mid : start;
                isFrist = false;
                start = Math.min(mid, start);
                end = Math.max(mid, end);
                left = mid+1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        ans[0] = start;
        ans[1] = end;

        return ans;
    }
}
