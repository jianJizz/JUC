package com.usc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 */
public class BalancedStringSplit {

    public static void main(String[] args) {
        int ans = BalancedStringSplit.balancedStringSplit("LLLLRRRR");
        System.out.println(ans);
    }
    public static int balancedStringSplit(String s) {
        int ans = 0;
    char[] chs = s.toCharArray();
    int len = chs.length;
    Deque<Character> stack = new ArrayDeque<>();
    int count = 1;
        for (int i=0; i < len; i++){
        if (!stack.isEmpty()){
            char t = chs[i];
            if (stack.peek() != t ){
                if (count == 1){
                    ans++;
                    i++;
                    stack.poll();
                }else{
                    count--;
                    stack.poll();
                    continue;
                }
            }else{
                count++;
            }
        }
        if (i < len)
            stack.push(chs[i]);
    }


        return ans;
}
}
