package com.xinyu.test

class TestTreeNode5 {
    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

    叶子节点 是指没有子节点的节点。

     
    示例 1：


    输入：root = [1,2,3,null,5]
    输出：["1->2->5","1->3"]
    示例 2：

    输入：root = [1]
    输出：["1"]
     

    提示：

    树中节点的数目在范围 [1, 100] 内
    -100 <= Node.val <= 100


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/binary-tree-paths
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()
        dfs(root, mutableListOf(), result)
        return result
    }

    /**
     * 1. StringBuffer.delete(path.length - 2, path.length)
     * 前包后不包
     */
    internal fun dfs(root: TreeNode?, path: MutableList<Int>, result: MutableList<String>) {
        root?.let {
            if (root.left == null && root.right == null) {
                path.add(root.`val`)
                result.add(path.joinToString("->"))
                path.removeAt(path.size - 1)
            }else{
                path.add(root.`val`)
                dfs(root.left, path, result)
                dfs(root.right, path, result)
                path.removeAt(path.size - 1)
            }
        }
    }
}

fun main() {
    println(TestTreeNode5().binaryTreePaths(TreeNode(1, TreeNode(2, null, TreeNode(5, null, null)), TreeNode(3))))
}