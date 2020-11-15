package com.usc.leetcode;

/**
 * 统计数字
 */
public class DigitCounts {
    public static void main(String[] args) {
        new DigitCounts().digitCounts(1, 12);
    }

    public int digitCounts(int k, int n) {
        int ans = 0;
        for(int i=0; i<=n; i++){
            int j = i;
            while(j > 0){
                if (j % 10 == k) ans++;
                j /= 10;
            }
        }


        return ans;
    }
}
