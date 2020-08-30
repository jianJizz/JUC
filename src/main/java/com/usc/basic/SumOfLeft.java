package com.usc.basic;

/**
 * 求所有左叶子节点之和
 */
public class SumOfLeft {
    public int sum(TreeNode root){
        if (root == null) return 0;

        return helper(root, false);
    }

    private int helper(TreeNode root, Boolean flag){
        if (root == null) return 0;
        int sum = 0;
        if (flag && root.left == null && root.right == null) sum += root.val;
        if (root.left != null) sum += helper(root.left, true);
        if (root.right != null) sum += helper(root.right, false);
        return sum;
    }
}
