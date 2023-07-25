package com.xinyu.test

import java.util.LinkedList

class TestNode53 {
    //https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
    /**
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
     *
     * 230. 二叉搜索树中第K小的元素
    难度
    中等

    752





    给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。



    示例 1：


    输入：root = [3,1,4,null,2], k = 1
    输出：1
    示例 2：


    输入：root = [5,3,6,2,4,null,null,1], k = 3
    输出：3




    提示：

    树中的节点数为 n 。
    1 <= k <= n <= 104
    0 <= Node.val <= 104

     */
    public fun kthSmallest(root: TreeNode?, k: Int): Int {

        //想法：遍历  放到数组里面 直接获取k位

        //其实也不用数组 直接返回也没问题
        //中序遍历就可以

        val linkedList = LinkedList<TreeNode>()

        //zuo 自己 有
        //会改变原来的结构

        //也可以不改变数据结构 改变指针
        //为什么我的思路没想到呢？
        //一路左左下去

        linkedList

        return -2

    }

    public fun dfs(root: TreeNode?, list: ArrayList<TreeNode>) {
        if (root == null) {
            return
        }
        dfs(root.left, list)
        list.add(root)
        dfs(root.right, list)
    }
}

fun main() {

    val treeNode = TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4))
    println(TestNode10().kthSmallest(treeNode, 1))

}