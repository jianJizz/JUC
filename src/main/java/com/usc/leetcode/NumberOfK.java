package com.usc.leetcode;

import java.util.Scanner;

/**
 * 第k个数
 */
public class NumberOfK {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] q = new int[n];
        for(int i=0; i<n; i++) q[i] =  in.nextInt();

        int ans = quickSort(q, 0, n-1, k);
        System.out.println(n);
    }

    public static int quickSort(int[] q, int l, int r, int k){
        if (l >= r) return q[l];
        int i=l-1, j = r+1, x = q[( l + r >> 1)];
        while(i < j){
            while(q[++i] < x);
            while(q[--j] > x);
            if (i < j) swap(q, i, j);
        }
        int sl = i - l + 1;
        if (k <= sl) return quickSort(q, l, i, k);
        return quickSort(q, i+1, r, k-sl);
    }

    private static void swap(int[] q, int i, int j){
        int t = q[i];
        q[i] = q[j];
        q[j] = t;
    }
}
