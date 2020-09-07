package com.usc.leetcode;

import java.util.Arrays;

/**
 * @author jianjianduan
 * @date 2020/8/31 11:30 下午
 */
public class FindContentChildern {
    public static void main(String[] args) {
        findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8});
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int k = 0;
        for(int i=0; i<g.length; i++){
            for(int j=0; j<s.length; j++){
                if (s[j] >= g[i]) {
                    ans++;
                    k++;
                }
                break;
            }
        }

        return ans;
    }
}
