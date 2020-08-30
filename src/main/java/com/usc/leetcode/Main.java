package com.usc.leetcode;


import java.io.*;
import java.math.BigInteger;

public class Main{
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int N = 10;
    static int n = 0;
    static int[] path = new int[N];
    static int[] visited = new int[N];

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(in.readLine());
        dfs(0);
    }

    public static void dfs(int u){
        if (u == n){
            for(int i=0; i<n; i++) System.out.print(path[i]+" ");
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                if (visited[i] == 0){
                    path[u] = i;
                    visited[i] = 1;
                    dfs(u+1);
                    //恢复现场
                    path[u] = 0;
                    visited[i] = 0;
                }
            }
        }
    }

}

