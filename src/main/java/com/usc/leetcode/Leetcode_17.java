package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/7/31 8:11 下午
 */
public class Leetcode_17 {
    public static void main(String[] args) {
        new Leetcode_17().letterCombinations("23");
    }

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    // 构造字典
    //                 0      1      2      3     4      5       6      7
    String[] words = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        // 深度为digits的长度，宽度为 3
        dfs(digits, 0);

        return res;
    }

    // index为访问字母的下标
    public void dfs(String digits, int index) {
        // 结束条件
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }
        // 获取数字对应的字母集 2 -> "abc"
        String word = words[digits.charAt(index)-'2'];
        for (int i=0; i<word.length(); i++) {
            path.append(word.charAt(i));
            // 递归
            dfs(digits, ++index);
            // 回溯
            path.deleteCharAt(path.length()-1);
            index--;
        }
    }
}
