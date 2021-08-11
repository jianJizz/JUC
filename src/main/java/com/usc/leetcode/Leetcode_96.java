package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/7/27 11:43 上午
 */
public class Leetcode_96 {
    public static void main(String[] args) {
        numTrees(3);
    }

    public static int numTrees(int n) {
        // 1.确定dp数组及下标含义 -- 第i个节点组成互不相同的二叉搜索树有dp[i]种
        int[] dp = new int[n+1];
        // 2. 递推公式: dp[i] += dp[以j为头结点左⼦树节点数量] * dp[以j为头结点右⼦树节点数量]
        // 3.初始化dp数组
        // 4.遍历顺序
        // 5.举例验证dp数组
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<n+1; i++) {
            for (int j=1; j<=i; j++) {
                System.out.println(dp[j-1] + "," + dp[i-j]);
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
