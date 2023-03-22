package com.xinyu.test

class TestArray159 {

    //https://leetcode.cn/problems/find-bottom-left-tree-value/
    /**
     * 513. 找树左下角的值
    给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

    假设二叉树中至少有一个节点。



    示例 1:



    输入: root = [2,1,3]
    输出: 1
    示例 2:



    输入: [1,2,3,4,null,5,6,null,null,7]
    输出: 7


    提示:

    二叉树的节点个数的范围是 [1,104]
    -231 <= Node.val <= 231 - 1
     */

    var curMaxDepth = 0
    var curMax = 0
    fun findBottomLeftValue(root: TreeNode?): Int {
        //
        curMax = root?.`val`!!
        dfs(root, curMaxDepth)
        return curMax

    }

    fun dfs(root: TreeNode?, depth: Int) {
        if (root == null) {
            return
        }
        if (depth >= curMaxDepth) {
            curMaxDepth = depth
            curMax = root.`val`
        }
        dfs(root.right, depth + 1)
        dfs(root.left, depth + 1)
    }
}

fun main() {

}
