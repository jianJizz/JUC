package com.usc.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 872: 叶子相似的树
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 */
public class LeftSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 =  new ArrayList<Integer>();
        List<Integer> l2 =  new ArrayList<Integer>();
        dfs(root1, l1);
        dfs(root2, l2);
        if (l1.size() != l2.size()) return false;

        for(int i=0; i<l1.size(); i++) {
            int i1 = l1.get(i);
            int i2 = l2.get(i);
            if (i1 != i2) return false;
        }
        return true;
    }


    private void dfs(TreeNode root, List<Integer> list){
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
