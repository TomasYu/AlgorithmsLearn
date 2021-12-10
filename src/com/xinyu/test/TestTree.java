package com.xinyu.test;

import java.util.ArrayList;
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


        List<Integer> integers2 = postorderTraversal2(treeNode);

        System.out.println(integers2);



        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.left = new TreeNode(9);
        treeNode2.right = new TreeNode(20);
        treeNode2.right.left = new TreeNode(15);
        treeNode2.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(treeNode2);
        System.out.println(lists);


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


    /**
     * 给定一个二叉树，返回它的 后序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [3,2,1]
     *
     */

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        reversePO(root,result);
        return result;
    }

    private static void reversePO(TreeNode root, List<Integer> result) {
        if (root != null) {
            reversePO(root.left,result);
            reversePO(root.right,result);
            result.add(root.val);
        }
    }


    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pollLast();
            if (treeNode == null) {
                continue;
            }
            if (treeNode.left == null && treeNode.right == null) {
                result.add(treeNode.val);
                continue;
            }
            stack.add(treeNode);

            if (treeNode.right != null) {
                stack.offer(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.offer(treeNode.left);
            }
            treeNode.left = treeNode.right = null;
        }
        return result;
    }


    /**
     *
     * 二叉树的层序遍历
     给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



     示例：
     二叉树：[3,9,20,null,null,15,7],

     3
     / \
     9  20
     /  \
     15   7
     返回其层次遍历结果：

     [
     [3],
     [9,20],
     [15,7]
     ]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List <TreeNode>list = new LinkedList<>();
        if (root != null) {
            list.add(root);
        }
        while (!list.isEmpty()) {
            List<Integer> line = new LinkedList<>();
            List <TreeNode>lineTree = new LinkedList<>();
            for (TreeNode treeNode : list) {
                line.add(treeNode.val);
                if (treeNode.left != null) {
                    lineTree.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    lineTree.add(treeNode.right);
                }
            }
            result.add(line);
            list = lineTree;
        }
        return result;
    }

    private static void reverseLO(List<TreeNode> list, List<List<Integer>> result) {

    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        reverseLevel(root,result,0);
        return result;
    }

    public static void reverseLevel(TreeNode node, List<List<Integer>> result, int leve){
        if (result.size() == leve) {
            result.add(new LinkedList<>());
        }

        //加本层的
        result.get(leve).add(node.val);

        //左孩子
        if (node.left != null) {
            reverseLevel(node.left,result,leve+1);
        }
        //右孩子
        if (node.right != null) {
            reverseLevel(node.right,result,leve+1);
        }
    }


    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> level = levelOrder2(root);
        for (List<Integer> integers : level) {
            result.add(integers.get(integers.size()-1));
        }
        return result;
    }

}
