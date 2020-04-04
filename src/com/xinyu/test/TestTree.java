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


        List<Integer> integers2 = inorderTraversal3(treeNode);

        System.out.println(integers2);


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


    /**
     * 给定一个二叉树，返回它的中序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [1,3,2]
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.pollLast();
            if (poll == null) {
                continue;
            }
            if (poll.left == null && poll.right == null) {
                linkedList.offer(poll.val);
                continue;
            }

            TreeNode right = poll.right;
            if (right != null) {
                stack.offer(right);
            }
            if (poll.left != null) {
                stack.offer(poll);
                stack.offer(poll.left);
            }else {
                linkedList.offer(poll.val);
                continue;
            }

            poll.left = null;
            poll.right = null;
        }

        return linkedList;
    }


    public static List<Integer> inorderTraversal2(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode mCur = root;
        while (mCur != null || !stack.isEmpty()) {
            while (mCur != null) {
                stack.offer(mCur);
                mCur = mCur.left;
            }
            TreeNode treeNode = stack.pollLast();
            linkedList.offer(treeNode.val);
            mCur = treeNode.right;
        }

        return linkedList;
    }

    public static List<Integer> inorderTraversal3(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        reverse(root,linkedList);
        return linkedList;
    }

    private static void reverse(TreeNode node,LinkedList<Integer> linkedList) {
        if (node != null) {
            //左节点
            reverse(node.left,linkedList);
            //自己
            linkedList.offer(node.val);
            //右节点
            reverse(node.right,linkedList);
        }
    }


}
