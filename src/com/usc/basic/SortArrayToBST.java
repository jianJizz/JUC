package com.usc.basic;

import java.util.Arrays;

/**
 * 它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 *
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * leetcode 面试题 04.02 最小高度树
 */
public class SortArrayToBST {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        // [2,4)
        int mid = nums.length / 2;
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, mid)));
    }

    /**
     *
     * 思路:
     * 二分法
     * 递归创建左右子树
     * @param nums 排序数组
     * @return 最小高度的二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        int mid = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, len));

        return root;
    }
}
