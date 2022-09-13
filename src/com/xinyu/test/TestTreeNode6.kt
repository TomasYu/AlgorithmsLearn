package com.xinyu.test

import java.util.*

class TestTreeNode6 {
    /**
     * 111. 二叉树的最小深度
    给定一个二叉树，找出其最小深度。

    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

    说明：叶子节点是指没有子节点的节点。



    示例 1：


    输入：root = [3,9,20,null,null,15,7]
    输出：2
    示例 2：

    输入：root = [2,null,3,null,4,null,5,null,6]
    输出：5


    提示：

    树中节点数的范围在 [0, 105] 内
    -1000 <= Node.val <= 1000

    https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    这个题还是广度搜索比较好   因为是最小深度  深度搜索会一直往下进行无用的遍历
     */

    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return dfs(root, 1)
    }

    internal fun dfs(root: TreeNode?, depth: Int): Int {
        root?.let {
            if (root.left == null && root.right == null) {
                return depth
            }
            var left = dfs(root.left, depth + 1)
            var right = dfs(root.right, depth + 1)
            return left.coerceAtMost(right)
        }
        return Int.MAX_VALUE
    }

    /**
     * 不必为了知道深度  单独传递一个参数  其实也都行  能写出来就行
     */
    fun minDepth2(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null){
            return 1
        }
        val left = minDepth2(root.left)
        val right = minDepth2(root.right)
        return if (left == 0 || right == 0){
            left + right + 1
        }else{
            left.coerceAtMost(right) + 1
        }
    }

    //bfs
    fun minDepth3(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        root?.let { queue.offer(it) }
        var depth = 0
        while (!queue.isEmpty()){
            depth ++
            val size = queue.size
            for (i in 1..size){
                val pop = queue.pop()
                if (pop.left == null && pop.right == null){
                    return depth
                }
                pop.left?.let { queue.offer(it) }
                pop.right?.let { queue.offer(it) }
            }
        }
        return depth
    }
}