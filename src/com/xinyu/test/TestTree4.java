package com.xinyu.test;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

public class TestTree4 {

    public static int sumOfLeftLeaves(TreeNode root) {
        ArrayDeque<TreeNode> arrayQueue = new ArrayDeque<TreeNode>();
        arrayQueue.offer(root);
        int result = 0;
        while (!arrayQueue.isEmpty()){
            TreeNode poll = arrayQueue.poll();
            if (poll != null) {
                if (poll.left != null) {
                    arrayQueue.offer(poll.left);
                    if (poll.left.left == null && poll.left.right == null) {
                        result = result +  poll.left.val;
                    }
                }
                if (poll.right != null) {
                    arrayQueue.offer(poll.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
