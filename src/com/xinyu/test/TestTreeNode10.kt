package com.xinyu.test

class TestTreeNode10 {
    //https://leetcode.cn/problems/binary-tree-maximum-path-sum/
    /**
     * 124. 二叉树中的最大路径和
    难度
    困难

    2013





    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

    路径和 是路径中各节点值的总和。

    给你一个二叉树的根节点 root ，返回其 最大路径和 。



    示例 1：


    输入：root = [1,2,3]
    输出：6
    解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    示例 2：


    输入：root = [-10,9,20,null,null,15,7]
    输出：42
    解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42


    提示：

    树中节点数目范围是 [1, 3 * 104]
    -1000 <= Node.val <= 1000

     */

    fun maxPathSum(root: TreeNode?): Int {
        var max = Int.MIN_VALUE

        if (root == null){
            return Int.MIN_VALUE
        }
        //只是知道节点和  那应该简单
        //每个节点 肯定知道 左右孩子的合
        //每一步记录更新最大的合
        //层序遍历就可以
        val maxLeft = maxPathSum(root.left)
        val maxRight = maxPathSum(root.right)
        max = max.coerceAtLeast(root.`val`)
        max = max.coerceAtLeast(maxLeft)
        max = max.coerceAtLeast(maxRight)
        if (maxLeft != Int.MIN_VALUE && maxRight != Int.MIN_VALUE) {
            max = max.coerceAtLeast(maxLeft + maxRight + root.`val`)
        }
        if (maxRight != Int.MIN_VALUE){
            max = max.coerceAtLeast(maxRight + root.`val`)
        }
        if (maxLeft != Int.MIN_VALUE){
            max = max.coerceAtLeast(maxLeft + root.`val`)
        }
        return max
    }

    //逻辑有漏洞  需要考虑连接性

    fun dfs(root: TreeNode?){

    }
}