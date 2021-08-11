package com.usc.leetcode;

import java.util.*;

/**
 * @author jianjianDuan
 * @date 2021/7/28 4:31 下午
 */
public class Leetcode_101 {
    public static void main(String[] args) {



    }

    public static boolean isSymmetric(TreeNode root) {
        // 左子树的左孩子 = 右子树的右孩子 => 外侧相等
        // 左子树的右孩子 = 右子树的左孩子 => 内侧相等
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 左右子树为空
            if (left==null && right == null) continue;
            else if (left != null && right == null) return false;
            else if (left == null && right != null) return false;
                // 左右子树不为空
            else if (left.val != right.val) return false;

            // 外侧
            queue.offer(left.left);
            queue.offer(right.right);
            // 内侧
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
