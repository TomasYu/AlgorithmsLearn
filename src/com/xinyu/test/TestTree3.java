package com.xinyu.test;


import java.util.LinkedList;

/**
 * Created by zy on 2020/4/5.
 */
public class TestTree3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        boolean b = hasPathSum(root,22);
        System.out.println(b);

    }

    /**
     * 路径总和
     *
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

     说明: 叶子节点是指没有子节点的节点。

     示例:
     给定如下二叉树，以及目标和 sum = 22，

     5
     / \
     4   8
     /   / \
     11  13  4
     /  \      \
     7    2      1
     返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return hasPathRev(root,sum);
    }

    private static boolean hasPathRev(TreeNode node, int sum) {
        if (node != null && node.left == null && node.right == null && node.val == sum){
            return true;
        }
        if (node == null) {
            return false;
        }
        boolean left = hasPathRev(node.left, sum - node.val);
        boolean right = hasPathRev(node.right, sum - node.val);
        return (left || right) ;
    }


    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();
        stack.offer(new Pair<>(root,sum));

        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> treeNodeIntegerPair = stack.pollLast();
            Integer value = treeNodeIntegerPair.getValue();
            TreeNode key = treeNodeIntegerPair.getKey();
            if (key.left == null && key.right == null && key.val == value) {
                return true;
            }
            if (key.left != null) {
                stack.offer(new Pair<>(key.left,value - key.val));
            }

            if (key.right != null) {
                stack.offer(new Pair<>(key.right,value - key.val));
            }
        }
        return false;
    }
}
