package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/7/27 10:56 上午
 */
public class Leetcode_343 {
    public static void main(String[] args) {
        integerBreak(5); //  0, 1, 1, 2, 4, 6
        //
    }
    public static int integerBreak(int n) {
        // 1. 确定dp数组及下标的含义 正整数i拆分为至少两个正整理的和，这些正整数的乘积最大为dp[i]
        // 2. 确定递推公式    将i拆分成i-j, j -> dp[i] = dp[i-j]*j, j*(i-j)
        // i = 5 j = 2 -> dp[3]*2, 2*3
        // 3. dp数组初始化    dp[1] = 1 dp[0] = 0
        // 4. 遍历顺序       前->后
        // 5. 举例验证dp数组的值
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<n+1; i++){
            for (int j=1; j<i; j++){
                dp[i] = Math.max(Math.max(dp[i-j]*j, (i-j)*j), dp[i]);
            }
        }

        return dp[n];
    }
}
