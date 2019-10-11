package com.usc.leetcode;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange.coinChange(new int[]{1,2,5}, 11);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int cost = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE){
                    cost = Math.min(cost, dp[i-coins[j]]+1);
                }
            }

            dp[i] = cost;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
