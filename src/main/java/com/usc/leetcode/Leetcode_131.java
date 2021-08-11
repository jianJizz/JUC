package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/8/1 4:54 下午
 */
public class Leetcode_131 {

    public static void main(String[] args) {
        new Leetcode_131().partition("aab");
    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // 深度: 未知, 宽度: 字符串的长度
        // 参数和返回值
        // 终止条件: 切割到了最后一个字符
        // 单层遍历逻辑

        dfs(s, 0);

        return res;
    }

    public void dfs(String s, int startIndex) {
        if (startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<s.length(); i++) {
            String t = s.substring(startIndex, i-startIndex+1);
            if (!isHuiwen(t)) continue;
            else path.add(t);
            // 递归
            dfs(s, i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }

    public boolean isHuiwen(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
