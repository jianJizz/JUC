package com.usc.leetcode;
/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        LevelOrder.BFS(root);

    }
    List<List<Integer>> levels = new ArrayList<>();
    public  List<List<Integer>> DFS(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public void helper(TreeNode node, int level){
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);

    }

    // curr next ans
    // 3    9,20   [3]
    // 9,20 15,7 [9,20]
    // 15,7 empty [15,7]
    public static List<List<Integer>> BFS(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();//count为这一层树的所有元素 从左到右的顺序
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                count--;
            }
            ans.add(list);
        }

        return ans;
    }
}

