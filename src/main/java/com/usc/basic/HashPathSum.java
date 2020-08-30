package com.usc.basic;

public class HashPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        new HashPathSum().hasPathSum(root, 1);
    }

    public int tsum = 0;
    public boolean ans = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        dfs(root, sum);

        return ans;
    }

    private void dfs(TreeNode root, int sum){
        if (root == null) return;
        tsum += root.val;
        if (root.left != null || root.right != null) {
            int t = tsum;
            dfs(root.left, sum);
            tsum = t;
            dfs(root.right, sum);
            tsum = t;
        }else if (root.left == null && root.right == null){
            if (tsum == sum) {
                ans = true;
                return;
            }
        }
    }
}
