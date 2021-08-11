package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/7/14 7:10 下午
 */
public class Minabs_1818 {
    public static void main(String[] args) {
        new Minabs_1818().minAbsoluteSumDiff(new int[]{1,28,21}, new int[]{9,21,20});
        // 1 28 21
        // 9 21 20
        // 8 7  1
        //
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int ans = 0;
        int n = nums1.length;
        int maxGapValue = 0;
        int maxGapValueIdx = 0; // 绝对值最大的元素下标
        for(int i=0; i<n; i++){
            int abs = Math.abs(nums1[i] - nums2[i]);
            ans += Math.abs(nums1[i] - nums2[i]);
            if (abs > maxGapValue) {
                maxGapValue = abs;
                maxGapValueIdx = i;
            }
        }

        if (ans == 0) return 0;
        int tmp_ans = ans;
        int t = ans;
        for(int i=0; i<n; i++){
            int abs = Math.abs(nums1[i] - nums2[maxGapValueIdx]);
            if (abs < maxGapValue) {
                t = ans - maxGapValue + abs;
            }

            if (t < tmp_ans) {
                tmp_ans = t;
            }
        }

        return tmp_ans % mod;

    }
}
