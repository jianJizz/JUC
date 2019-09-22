package com.usc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * stack peek和pop
 * 相同点：大家都返回栈顶的值。
 *
 * 不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("{[][]}"));
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++){
            if (deque.size() == 0)
                deque.push(chs[i]);
            else if (isPair(deque.peek(), chs[i]))
                deque.pop();
            else
                deque.push(chs[i]);
        }

       return deque.size() == 0;
    }

    private boolean isPair(char ch1, char ch2){
        return (ch1 == '{' && ch2 =='}') || (ch1 == '[' && ch2 ==']') || (ch1 == '(' && ch2 ==')');
    }


    public boolean isValid2(String s) {
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++){

        }


        return false;
    }
}
