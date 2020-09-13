package com.usc.leetcode;

import java.util.HashMap;
import java.util.Map;

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
        CoinChange.coinChange4(new int[]{2}, 3);
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


    // 2.自顶向下的思想 （超时）
    public static int coinChange2(int[] coins, int amount){
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        // base case
        for (int i=0; i<coins.length; i++){
            // 子问题
            int subProblem = coinChange2(coins, amount-coins[i]);
            // 子问题无解
            if (subProblem == -1) continue;
            res = Math.min(subProblem+1, res);
        }

        return res == Integer.MAX_VALUE ? -1 : res ;
    }

    // 加入备忘录功能 超时
    private static int helper(int[] coins, int amount, int[] memo){
        // 算子问题之前先去查一下之前有没计算过
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != Integer.MAX_VALUE) return memo[amount];
        // base case
        int res = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
            // 子问题
            int subProblem = helper(coins, amount-coins[i], memo);
            // 子问题无解
            if (subProblem == -1) continue;
            res = Math.min(subProblem+1, res);
        }

        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;

        return memo[amount];
    }
    public static int coinChange3(int[] coins, int amount){
        int[] memo = new int[amount + 1];
        for(int i=0; i<amount+1; i++){
            memo[i] = Integer.MAX_VALUE;
        }

        return helper(coins, amount, memo);
    }

    // dp思想，自底向上
    public static int coinChange4(int[] coins, int amount){
            int[] dp = new int[amount+1];
            for(int i=0; i<amount+1; i++){
                dp[i] =  amount+1;
            }
            dp[0] = 0;
            for(int i=1; i<=amount; i++){
                for(int j=0; j<coins.length; j++){
                    if(i-coins[j] < 0) continue;
                    int t = dp[i-coins[j]]+1;
                    dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
                }
            }

            return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
