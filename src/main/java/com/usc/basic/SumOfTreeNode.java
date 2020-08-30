package com.usc.basic;

/**
 * 前序遍历求树的所有节点之和
 */
public class SumOfTreeNode {
    public int sum(TreeNode root){
        int val = 0;
        if (root == null) return 0;
        val = root.val;
        if (root.left != null) val += sum(root.left);
        if (root.right != null) val += sum(root.right);
        return val;
    }
}
