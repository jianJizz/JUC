package com.usc.leetcode;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 */
public class ThirdMax {
    public static void main(String[] args) {
        int i = ThirdMax.thirdMax(new int[]{1, 2, -2147483648});
        System.out.println(i);
    }
    public static int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        long max = getMax(nums, 0, false);
        long sec = getMax(nums, max, true);
        long thr = getMax(nums, sec, true);

        return thr == Long.MIN_VALUE ? (int)max : (int)thr;

    }

    private static long getMax(int[] nums, long limit, boolean isLimit){
        long max = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if (isLimit){
                if (nums[i] > max && nums[i] < limit) max = nums[i];
            }else{
                if (nums[i] > max) max = nums[i];
            }

        }

        return max;
    }
}
