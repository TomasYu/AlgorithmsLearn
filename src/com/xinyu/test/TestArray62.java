package com.xinyu.test;

import java.util.ArrayList;
import java.util.List;

public class TestArray62 {
    /**
     *
     *     给定一颗二叉树，找到二叉树上任意两个节点之间的距离
     *
     *
     *
     */

    class TreeNode {
        TreeNode left;
        TreeNode right;
    }

    int findDistance(TreeNode root, TreeNode p, TreeNode q){
        if (p == q) {
            return 0;
        }
        List<TreeNode> list1= findPath(root,p);
        List<TreeNode> list2 = findPath(root,q);
//        TreeNode lastSame = null;
        int lastSame = 0;
        for(int i = 0; i< list1.size();i++){
            if(list1.get(i) == list2.get(i)){
                lastSame = i;
            }else{
                break;
            }
        }

        return list1.size() - lastSame + list2.size() - lastSame;
    }

    List<TreeNode> findPath(TreeNode root,TreeNode node){
        List<TreeNode> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        if(root == node){
            list.add(root);
            return list;
        }
        List<TreeNode> left = findPath(root,root.left);
        List<TreeNode> right = findPath(root,root.right);
        if(left.contains(node)){
            list.addAll(left);
        }else if(right.contains(node)){
            list.addAll(right);
        }
        return list;
    }
}
