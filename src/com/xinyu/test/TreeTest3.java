package com.xinyu.test;

import java.util.*;

public class TreeTest3 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int curLevelSize = treeNodes.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = treeNodes.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }

                if (node.right != null) {
                    treeNodes.offer(node.right);
                }

            }
            result.add(levelList);
        }
        print(result);
        return result;
    }

    public void print(List<List<Integer>> lists){
        for (List<Integer> list : lists) {
            if (!list.isEmpty()) {
                System.out.println(list.get(list.size() - 1));
            }
        }
    }


    /**
     * 107. 二叉树的层序遍历 II
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层序遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int curLevelSize = treeNodes.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = treeNodes.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }

                if (node.right != null) {
                    treeNodes.offer(node.right);
                }

            }
            result.addFirst(levelList);
        }
        print(result);
        return result;
    }



}
