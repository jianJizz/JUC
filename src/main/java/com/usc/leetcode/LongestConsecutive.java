package com.usc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int i = LongestConsecutive.longestConsecutive3(new int[]{});
        System.out.println(i);
    }

    //哈希法
    public static int longestConsecutive3(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int len = 1;
                int frist = num;
                while (set.contains(frist + 1)) {
                    len++;
                    frist++;
                }
                ans = Math.max(ans, len);
            }

        }

        return ans;
    }

    //排序 后查找
    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        Arrays.sort(nums);
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            if (nums[i] == nums[i - 1] + 1) {
                len++;
            } else {
                ans = Math.max(ans, len);
                len = 1;
            }
        }

        return Math.max(ans, len);
    }


    //暴力法 从nums第一个元素开始一直往后累加如果该数在nums中则记录其长度，直到不在nums中 更新最大长度
    public static int longestConsecutive1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            int frist = nums[i];
            while (arrayContains(nums, frist + 1)) {
                len++;
                frist++;
            }
            ans = Math.max(ans, len);
        }

        return ans;
    }


    public static boolean arrayContains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return true;
        }

        return false;
    }
}
