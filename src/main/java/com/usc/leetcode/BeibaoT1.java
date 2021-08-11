package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/7/27 2:30 下午
 * <p>
 * 有N件物品和⼀个最多能被重量为W 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每
 * 件物品只能⽤⼀次，求解将哪些物品装⼊背包⾥物品价值总和最⼤。
 */
public class BeibaoT1 {
    public static void main(String[] args) {
        int ans = slove1(new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 5}, 4, 5);
        System.out.println(ans);
    }


    // 二维
    public static int slove1(int[] w, int[] v, int N, int W) {
        // 1. 确定dp数组及下标的含义  从[0-i]的物品中任意取放进重量为j的背包得到的最大价值为dp[i][j]
        // 2. 确定递推公式
        //  对物品i 放或者不放:
        //   1) 不放: dp[i][j] = dp[i-1][j]
        //   2)  放:  dp[i][j] = dp[i-1][j-w[i]] + v[i]
        // dp[i][j] = max(不放, 放)
        // 3. dp数组初始化
        // dp[i][0] = 0 没有重量
        // 4. 遍历顺序    先遍历背包再遍历物品 从前往后遍历
        // 5. 举例验证dp数组的值

        int[][] dp = new int[N][W + 1];
        // ======初始化=====
        // 背包重量为0
        for (int i = 0; i < N; i++) dp[i][0] = 0;
        // 取第0个物品放入背包容量j
        for (int j = 0; j < W + 1; j++) {
            if (j >= w[0]) {
                dp[0][j] = v[0];
            }
        }
        // ===============

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (j < w[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }

        return dp[N - 1][W];
    }

    // 一维
    public static int slove2(int[] w, int[] v, int N, int W) {
        // 1. 确定dp数组及下标的含义  从v中任意取，容量为j时最大价值为dp[j]
        // 2. 确定递推公式
        //  dp[j] = max(dp[j], dp[j-w[i]]+v[i])
        // 3. dp数组初始化
        // dp[0] = 0
        // 4. 遍历顺序    先遍历物品再遍历背包(逆序，避免重复放入背包)
        // 5. 举例验证dp数组的值
        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = W; j >= w[i]; j--) {
                // int ans = slove1(new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 5}, 4, 5);
                // 正序: dp[1] = max(dp[1], dp[1-1]+ 1) = 1
                //      dp[2] = max(dp[2], dp[2-1]+1) = 2
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }


        return dp[W];
    }
}
