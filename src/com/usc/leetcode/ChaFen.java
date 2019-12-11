package com.usc.leetcode;

import java.util.Scanner;

/**
 * 差分
 * 构造一个b[i]使得 b[i]是a[i]的前缀和
 */
public class ChaFen {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n+2];
        int[] b = new int[n+2];
        for(int i=1; i<=n; i++) a[i] = in.nextInt();

        for(int i=1; i<=n; i++) insert(b, i, i, a[i]);

        for(int i=1; i<=m; i++){
            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            insert(b, l, r, c);
        }

        for(int i=1; i<=n; i++) b[i] += b[i-1];

        for(int i=1; i<=n; i++) System.out.print(b[i]+" ");
    }


    public static void insert(int[] b, int l, int r, int c){
        b[l] += c;
        b[r+1] -= c;
    }
}
