package com.usc.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 */
public class ReverseNumber{

    public static void main(String[] args) {
       int ans =  new ReverseNumber().reverse(Integer.MAX_VALUE);

        System.out.println(Integer.MAX_VALUE);
       System.out.println(ans);
    }


    public int reverse(int x){
        
        long ans = 0;
        while(x != 0){
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return  (ans > 0x7fffffff || ans < 0x80000000) ? 0 : (int)ans;
    }
}