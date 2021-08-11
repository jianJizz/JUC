package com.usc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/8/1 10:17 上午
 */
public class Leetcode_1337 {
    public static void main(String[] args) {
        new Leetcode_1337().kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3);
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        // i行1<j行的1 =>  mar[i][] < mar[j][]
        // 1相同，但i < j
        int m = mat.length; // 行数
        int n = mat[0].length; // 列数
        // 行数_和
        List<String> list = new ArrayList<>();
        int [] ans = new int[k];
        for (int i=0; i<m; i++) {// 行
            int sum = 0;
            for (int j=0; j <n ;j ++) {
                sum += mat[i][j];
            }
            list.add(i+"_"+sum);
        }

        Collections.sort(list, (a, b) -> {
            String[] key1 = a.split("_");
            String[] key2 = b.split("_");
            int row1_row2 = Integer.parseInt(key1[0]) - Integer.parseInt(key2[0]);
            int sum1_sum2 = Integer.parseInt(key1[1]) - Integer.parseInt(key2[1]);
            if (sum1_sum2 == 0) {
                return row1_row2;
            }else {
                return sum1_sum2;
            }
        });

        int index = 0;
        for (String v: list) {
            ans[index++] = Integer.parseInt(v.split("_")[0]);
            if (index == k) break;
        }

        return ans;
    }
}
