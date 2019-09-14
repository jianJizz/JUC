package com.usc.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String [] strs = new String[]{"flower","flow"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }

    public  String longestCommonPrefix(String [] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1) return strs[0];
        String ans = new String("");

        int len = 1;

        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen)
                minLen = strs[i].length();
        }

        while (len <= minLen) {
            String first = strs[0].substring(0, len);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].substring(0, len).equals(first)) {
                    len = minLen;
                    break;
                }
                if (i == strs.length - 1){
                    ans = first;
                }
            }

            len++;
        }

        return ans;
    }
}
