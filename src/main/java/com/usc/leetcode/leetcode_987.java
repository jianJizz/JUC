package com.usc.leetcode;

import java.security.Key;
import java.util.*;

/**
 * @author jianjianDuan
 * @date 2021/7/31 9:38 下午
 */
public class leetcode_987 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
       new leetcode_987().verticalTraversal(root);
    }


    Map<Integer, List<String>> map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 深度: 未知, 宽度: 2    结束条件: 遇到叶子节点
        dfs(root, 0, 0, 0);

        // 注意同行同列才按大小排序, 排序插入到list
        Set<Integer> keySet = map.keySet();
        int[] keyArr = new int[keySet.size()];
        int index = 0;
        for (int key: keySet) keyArr[index++] = key;
        Arrays.sort(keyArr);

        for (Integer key: keyArr) {
            List<String> list = map.get(key);
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    // 先对比层级，再对比key
                    // 5_1, 6_1
                    String[] key1 = o1.split("_");
                    String[] key2 = o2.split("_");
                    int y1_y2 = Integer.parseInt(key1[0])-Integer.parseInt(key2[0]);
                    int layer1_layer2 = Integer.parseInt(key1[1]) - Integer.parseInt(key2[1]);
                    if (layer1_layer2 < 0) {
                        return -1;
                    }else if (layer1_layer2 > 0) {
                        return 1;
                    }else {
                        return y1_y2;
                    }
                }
            });
            // 将list中的值转为string
            List<Integer> tList = new ArrayList<>();
            for (String v: list) {
                tList.add(Integer.parseInt(v.split("_")[0]));
            }

            res.add(tList);
        }

        return res;
    }

    // y 为父节点的纵坐标, flag 0, 1, 2 => 根节点，左节点，右结点
    public void dfs(TreeNode root, int y, int flag, int layer) {
        if (root == null) return;
        // 本节点的纵坐标
        int curY = 0;
        if (flag == 1) curY = y-1;
        else if (flag == 2) curY = y+1;
        List<String> list = map.getOrDefault(curY, null);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(root.val + "_" + layer);
        // 每一层做标记
        map.put(curY, list);
        if (root.left != null) dfs(root.left, curY, 1, layer+1);
        if (root.right != null) dfs(root.right, curY, 2, layer+1);
    }
}
