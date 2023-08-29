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
    private var finalMax = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return finalMax
    }

    fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        //左右两个子节点贡献值最小为0 如果是负数那么就直接不归属，相当于取0
        val maxLeft = dfs(root.left).coerceAtLeast(0)
        val maxRight = dfs(root.right).coerceAtLeast(0)
        var max = (maxRight + root.`val`).coerceAtLeast(maxLeft + root.`val`)
        //当前节点当作整个路径的最大值计算一下
        finalMax = finalMax.coerceAtLeast(maxLeft + maxRight + root.`val`)
        //返回的max表示当前节点的最大贡献值
        return max
    }

    /**
    返回指是贡献的值
    不包含左右节点
    而最大值是可以包含的






    核心是注意当前节点的最大路径，与当前节点作为子节点时的贡献是两个不同的值

    当前节点的最大路径： max(自己，自己+左边，自己+右边，自己 + 左边 + 右边）
    当前节点作为子节点时的贡献：max(自己，自己+左边，自己+右边）
    后者相对前者，少了左右都存在的情况。因为作为子节点时，一条路如果同时包含左右，根就被包含了2次，不符合题目只出现一次的限制了。


     */
}