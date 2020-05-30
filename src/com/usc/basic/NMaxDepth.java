package com.usc.basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 559
 *  N叉树的最大深度
 *  给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class NMaxDepth {
    public int depth = 1;
    public int depth(Node root){
        if (root == null) return 0;
        dfs(root);
        return 0;
    }

    int d = 1;
    private void dfs(Node root){
        if (root == null) return;
        List<Node> children = root.children;
        for (Node c : children) {
            if (c != null) {
                int t = d;
                d++;
                dfs(c);
                depth = Math.max(depth, d);
                d = t; //回溯
            }
        }
    }

    // 二叉树的高度=max(左子树的高度， 右子树的高度)+1
    // 树的高度=max(子树的高度)+1
    public int maxDepth(Node root) {
        if (root == null) return 0;
        else if (root.children.isEmpty()) return 1;
        else {
            List<Node> children = root.children;
            List<Integer> heights = new LinkedList<>();
            for(Node c: children){
                if (c != null){
                    heights.add(maxDepth(c));
                }
            }

            return Collections.max(heights)+1;
        }
    }
}
