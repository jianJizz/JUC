package com.usc.leetcode;


import java.util.*;

/**
 * @author jianjianDuan
 * @date 2021/7/22 2:29 下午
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Leetcode_2032 {

    public static void main(String[] args) {


        restoreArray(new int[][]{{2,1}, {3, 4}, {3,2}});


    }


    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = adjacentPairs.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v1 = adjacentPairs[i][0], v2 = adjacentPairs[i][1];
            putMap(map, v1, v2);
            putMap(map, v2, v1);

        }
        // 2->1, 3
        // 3->4, 2
        // 1 -> 2
        // 4->3
        // 只有一个相邻的->首尾
        // 只有两个相邻-> 中间
        int[] t = new int[2];
        int i = 0;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            List<Integer> list = map.get(key);
            if (list.size() == 1) {
                t[i++] = key;
            }

            if (i > 1) {
                break;
            }
        }
        ans.add(t[0]);
        int index = 0;
        while (ans.get(ans.size() - 1) != t[1]) {
            // a = 1
            int a = ans.get(index);
            // 1-> [2]
            List<Integer> list = map.get(a);
            if (list.size() == 1) {
                ans.add(list.get(0));
            } else {
                int v1 = list.get(0), v2 = list.get(1);
                if (v1 != ans.get(index - 1)) {
                    ans.add(v1);
                } else {
                    ans.add(v2);
                }
            }
            index++;
        }

        int[] ansArr = new int[ans.size()];
        int j = 0;
        for (int v : ans) {
            ansArr[j++] = v;
        }
        return ansArr;
    }

    private static void putMap(Map<Integer, List<Integer>> map, int v1, int v2) {
        List<Integer> list;
        if (map.containsKey(v1)) {
            list = map.get(v1);
        } else {
            list = new ArrayList<>();
        }
        list.add(v2);
        map.put(v1, list);
    }
}
