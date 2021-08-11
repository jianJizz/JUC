package com.usc.leetcode;

import java.util.*;

/**
 * @author jianjianDuan
 * @date 2021/8/3 5:19 下午
 */
public class InsertSort {

    public static void main(String[] args) {
//        InsertSort.insertSort(new int[]{4, 1, 3, 2});

        List<List<Integer>> res = new ArrayList<>();

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(0);



    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i];
            int j = i - 1;
            for (;j >= 0; j--) {
                if (nums[j] > tmp) {
                    nums[j + 1] = nums[j]; // 把j后移
                }else {
                    break;
                }
            }
            nums[j + 1] = tmp;
        }
    }
}
