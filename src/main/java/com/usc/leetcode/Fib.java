package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianduan
 * @date 2020/9/11 11:07 下午
 *
 * 斐波那契数列优化
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib2(20));
    }


    // 暴力
    public static int fib(int N){
        if (N <= 0) return 0;
        if (N == 1 || N == 2) return 1;
        return fib(N-1) + fib(N-2);
    }

    // 使用备忘录功能记录已经计算的结果，每次计算之前先去备忘录查一下
    public static int fib2(int N){
        if (N <= 0) return 0;
        int[] memo = new int[N+1];
        return helper(N, memo);
    }

    private static int helper(int N, int[] memo) {
        if (N == 1 || N == 2) return 1;
        if (memo[N] != 0) return memo[N];
        memo[N] = helper(N-1, memo)+ helper(N-2, memo);

        return memo[N];
    }

    // 自底向上，动态规划思想
    public static int fib3(int N){
        if (N <= 0) return 0;
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }

    // 进一步优化 不需要存储全部状态
    // 自底向上，动态规划思想
    public static int fib4(int N){
        if (N <= 0) return 0;
        if (N == 1 || N == 2) return 1;
       int pre = 1, curr = 1;
       int temp = 0;
        for(int i=3; i<=N; i++){
            temp = pre + curr;
            curr = pre;
            pre = temp;
        }

        return temp;
    }
}
