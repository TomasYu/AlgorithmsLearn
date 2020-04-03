package com.xinyu.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zy on 2020/4/3.
 */
public class TestTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);


    }

    /**
     *  二叉树的前序遍历
     *
     *
     *给定一个二叉树，返回它的 前序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [1,2,3]
     进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     */


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.offer(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.offer(treeNode.left);
            }
        }
        return result;
    }





}
