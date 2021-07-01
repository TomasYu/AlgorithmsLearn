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



}
