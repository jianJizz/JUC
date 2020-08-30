package com.usc.basic;

/**
 * 前序遍历求所有叶子节点之和
 */
public class SumOfLeave {
    public int sum(TreeNode root){
        if (root == null) return 0;
        int sum = 0;
        if (root.left == null && root.right == null) sum = root.val;
        if (root.left != null) sum += sum(root.left);
        if (root.right != null) sum += sum(root.right);
        return sum;
    }

}
