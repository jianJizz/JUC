package com.usc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianjianduan
 * @date 2020/9/19 10:36 上午
 * <p>
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
public class OpenLock {
    public static void main(String[] args) {
        new OpenLock().openLock(new String[]{"8888"}, "0009");
    }

    // 向上拨动一次拨片
    public String plus(String input, int j) {
        char[] ch = input.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;

        return new String(ch);
    }

    // 向下拨动一次拨片
    public String minus(String input, int j) {
        char[] chs = input.toCharArray();
        if (chs[j] == '0')
            chs[j] = '9';
        else
            chs[j] -= 1;

        return new String(chs);
    }

    public int openLock(String[] deadends, String target) {
        // 1. 定义数据队列
        Deque<String> q = new ArrayDeque<>();
        // 2. visited队列
        Set<String> visited = new HashSet<>();

        Set<String> dead = new HashSet<>();
        for (String d : deadends)
            dead.add(d);

        // 3. 将起始点加入队列
        q.offer("0000");
        visited.add("0000");
        // 4. 记录扩散步数
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            // 5.将当前队列中的所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                // 6.判断是否在target中
                String curr = q.poll();
                if (dead.contains(curr))
                    continue;
                if (curr.equals(target))
                    return step;

                // 7.将curr的相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plus(curr, j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        q.offer(up);
                    }
                    String down = minus(curr, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        q.offer(down);
                    }
                }
            }

            // 8.步数++
            step++;
        }

        return -1;
    }
}
