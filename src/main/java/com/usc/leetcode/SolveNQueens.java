package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianduan
 * @date 2020/9/14 9:48 下午
 * N皇后问题
 */
public class SolveNQueens {
    public static void main(String[] args) {

    }

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] track = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                track[i][j] = '.';
            }
        }
        dfs(0, track);
        return ans;
    }

    public void dfs(int row, char[][]track){
        // 结束条件
        if (track.length == row) {
            ans.add(map(track));
            return;
        }
        int n = track[row].length;
        for(int col=0; col<n; col++){
            // 不合法(已经有皇后了)
            if (!isValid(track, row, col))
                continue;
            // 做选择
            track[row][col] = 'Q';
            // 继续下一个
            dfs(row+1, track);
            // 撤销选择
            track[row][col] = '.';
        }
    }

    //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
    //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相        等来判断。
    public boolean isValid(char[][] track, int row, int col){
        for(int i=0; i<=row; i++){
            for(int j=0; j<track[i].length; j++){
                if (track[i][j] == 'Q' && (j==col || Math.abs(row-i) == Math.abs(col-j))){
                    return false;
                }
            }
        }

        return true;
    }
    public List<String> map(char[][] chs){
        List<String> res = new ArrayList<>();
        for(int i=0; i<chs.length; i++){
            res.add(new String(chs[i]));
        }

        return res;
    }
}
