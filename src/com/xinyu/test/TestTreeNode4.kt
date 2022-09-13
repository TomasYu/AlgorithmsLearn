package com.xinyu.test

class TestTreeNode4 {
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
        dfs(root, "", result)
        return result
    }

    /**
     */
    internal fun dfs(root: TreeNode?, path: String, result: MutableList<String>) {
        root?.let {
            if (root.left == null && root.right == null) {
                result.add("$path${root.`val`}")
            }else{
                dfs(root.left,"$path${root.`val`}->",result)
                dfs(root.right,"$path${root.`val`}->",result)
            }
        }
    }
}

fun main() {
    println(TestTreeNode4().binaryTreePaths(TreeNode(1, TreeNode(2, null, TreeNode(5, null, null)), TreeNode(3))))
}