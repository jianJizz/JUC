package com.usc.leetcode;

import java.util.*;

/**
 * @author jianjianduan
 * @date 2020/9/19 5:47 下午
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class BuildTree {
    public static void main(String[] args) {
       BuildTree main =  new BuildTree();
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(null);
        list.add(6);
        TreeNode treeNode = main.createBinaryTree(list);
        main.preOrder(treeNode);
    }


    /**
     * 构建二叉树
     * @param inputList   输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
        if(data != null){
            node = new TreeNode(data
            );
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public void preOrder(TreeNode node){
        if (node == null) return ;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
