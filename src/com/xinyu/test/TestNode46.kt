package com.xinyu.test

class TestNode46 {
    /**
     * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。

    返回包含原始树中所有 最深节点 的 最小子树 。

    如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。

    一个节点的 子树 是该节点加上它的所有后代的集合。

     

    示例 1：



    输入：root = [3,5,1,6,2,0,8,null,null,7,4]
    输出：[2,7,4]
    解释：
    我们返回值为 2 的节点，在图中用黄色标记。
    在图中用蓝色标记的是树的最深的节点。
    注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
    示例 2：

    输入：root = [1]
    输出：[1]
    解释：根节点是树中最深的节点。
    示例 3：

    输入：root = [0,1,3,null,2]
    输出：[2]
    解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    var map = HashMap<TreeNode, Int>()
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return helper(0, root)
    }

    private fun helper(level: Int, root: TreeNode?): TreeNode? {
        if (root != null) {
            map[root] = level
        } else {
            return null
        }
        val left = helper(level + 1, root.left)
        val right = helper(level + 1, root.right)
        if (left == null && right == null) {
            return root
        } else if (left != null && right != null) {
            return if (map[left] == map[right]) {
                map[root] = map[left]!!
                root
            } else {
                if (map[left]!! > map[right]!!) {
                    left
                } else {
                    right
                }
            }
        } else {
            return left ?: right
        }
    }
}

fun main() {
//    println(
//        TestNode46().subtreeWithAllDeepest(
//            TreeNode(
//                3, TreeNode(
//                    5, TreeNode(
//                        6
//                    ), TreeNode(
//                        2,
//                        TreeNode(7, null, null), TreeNode(4, null, null)
//                    )
//                ), TreeNode(1, TreeNode(0), TreeNode(8))
//            )
//        )?.`val`
//    )


    println(
        TestNode46().subtreeWithAllDeepest(
            TreeNode(
                0, TreeNode(
                    1, TreeNode(
                        3
                    ), TreeNode(
                        2)
                ), null)
        )?.`val`
    )
}