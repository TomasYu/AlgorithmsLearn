package com.xinyu.test;


import java.util.LinkedList;

/**
 * Created by zy on 2020/4/5.
 */
public class TestTree2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = maxDepth2(root);
        System.out.println(i);


        TreeNode root2 = new TreeNode(9);
        root2.left = new TreeNode(-42);
        root2.right = new TreeNode(-42);
        root2.left.left = null;
        root2.left.right = new TreeNode(76);
        root2.right.left = new TreeNode(76);
        root2.right.right = null;

        root2.left.right.right = new TreeNode(13);
        root2.right.left.right = new TreeNode(13);
        boolean symmetric = isSymmetric2(root2);
        System.out.println(symmetric);

    }

    /**
     * 二叉树的最大深度
     *
     * 给定一个二叉树，找出其最大深度。

     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

     说明: 叶子节点是指没有子节点的节点。

     示例：
     给定二叉树 [3,9,20,null,null,15,7]，

     3
     / \
     9  20
     /  \
     15   7
     返回它的最大深度 3 。
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = 0,depthRight = 0;
        //左孩子
        if (root.left != null) {
            depthLeft = maxDepth(root.left);
        }
        //右孩子
        if (root.right != null) {
            depthRight = maxDepth(root.right);
        }
        // 加上自己的这一级别
        return 1 + Math.max(depthLeft,depthRight);
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();
        stack.offer(new Pair<>(root,1));
        int maxDep = 1;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> treeNodeIntegerPair = stack.pollLast();
            TreeNode key = treeNodeIntegerPair.getKey();
            Integer value = treeNodeIntegerPair.getValue();
            maxDep = Math.max(value,maxDep);

            if (key.left != null) {
                stack.offer(new Pair<>(key.left,value + 1));
            }

            if (key.right != null) {
                stack.offer(new Pair<>(key.right,value + 1));
            }
        }
        return maxDep;
    }

    /**
     * 对称二叉树
     *
     *
     * 给定一个二叉树，检查它是否是镜像对称的。

     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

     1
     / \
     2   2
     / \ / \
     3  4 4  3
     但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

     1
     / \
     2   2
     \   \
     3    3
     */

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricReverse(root,root);

    }

    private static boolean isSymmetricReverse(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }else if (left == null || right == null){
            return false;
        }
        return left.val == right.val && isSymmetricReverse(left.left,right.right) && isSymmetricReverse(left.right,right.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        //第一个孩子单独处理下
        if (root.left == null && root.right == null) {
            return true;
        }else if (root.left == null || root.right == null){
            return false;
        }
        stack.offer(root.left);
        stack.offer(root.right);
        while (!stack.isEmpty()){
            TreeNode left = stack.poll();
            TreeNode right = stack.poll();
            if (left == null && right == null) {
                continue;
            }else if (left == null || right ==null){
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.offer(left.left);
            stack.offer(right.right);
            stack.offer(left.right);
            stack.offer(right.left);
        }
        return true;
    }


}
