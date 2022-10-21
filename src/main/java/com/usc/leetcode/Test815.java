package com.usc.leetcode;



/**
 * @author jianjianDuan
 * @date 2022/8/15 9:38 AM
 */
public class Test815 {
    public static void main(String[] args) {
        int[] res = new Test815().shuffle(new int[]{2,5,1,3,4,7}, 3);
        System.out.println(res);
    }

    // 3 4 5 1 2
    // 3 2 1 5 4
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        for(int i=0, j=0; i < 2 * n; i+=2) {
            ans[i] = nums[j];
            ans[i+1] = nums[j+n];
            j++;

        }

        return ans;
    }
}


