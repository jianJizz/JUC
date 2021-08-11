package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/8/3 10:43 上午
 */
public class Leetcode_581 {
    public static void main(String[] args) {
        new Leetcode_581().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    }

    public int findUnsortedSubarray(int[] nums) {
        // 如果最右端已排序好，那么它的每个元素都比左边的最大值要大
        int n = nums.length;
        int min = Integer.MAX_VALUE; // 右边最小值
        int max = Integer.MIN_VALUE; // 左边最大值
        int L = -1, R = -1;
        for (int i=0; i<n; i++) {
            if (nums[i] < max) {
                R = i;
            }else {
                max = nums[i];
            }
        }

        for (int i=n-1; i>=0; i--) {
            if (nums[i] > min) {
                L = i;
            }else {
                min = nums[i];
            }
        }

        System.out.println(R);
        System.out.println(L);
        return L == -1 ? 0 : R - L + 1 ;
    }
}
