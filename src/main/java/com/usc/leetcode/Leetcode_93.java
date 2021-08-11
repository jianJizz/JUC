package com.usc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianjianDuan
 * @date 2021/8/1 9:41 下午
 */
public class Leetcode_93 {

    public static void main(String[] args) {
        new Leetcode_93().restoreIpAddresses("25525511135");
    }


    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        // 深度: 4 宽度: s.length
        dfs(new StringBuilder(s), 0, 0);
        return res;
    }

    public void dfs(StringBuilder s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            // 判断第四部分是否合法
            if (isVaild(s.toString(), startIndex, s.length()-1))
                res.add(s.toString());
            return;
        }

        for (int i=startIndex; i<s.length(); i++) {
            if (isVaild(s.toString(), startIndex, i)) {
                s.insert(i+1, "."); //在i的后面插入逗点
                pointNum++;
                dfs(s, i+2, pointNum);
                // 回溯
                s.deleteCharAt(i+1);
                pointNum--;
            }else {
                break;
            }
        }
    }

    public boolean isVaild(String s, int start, int end) {
        if (end-start+1 > 3 || end-start+1 == 0) return false;
        int num = Integer.parseInt(s.substring(start, end+1));
        // System.out.println(num);
        if (num == 0 && start != end) return false;
        else if (num > 255) {
            return false;
        }else {
            return true;
        }
    }
}
