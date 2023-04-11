package com.xinyu.test

class TestArray162 {
    //https://leetcode.cn/problems/delete-nodes-and-return-forest/
    /**
     * 1110. 删点成林
    给出二叉树的根节点 root，树上每个节点都有一个不同的值。

    如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。

    返回森林中的每棵树。你可以按任意顺序组织答案。



    示例 1：



    输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
    输出：[[1,2,null,4],[6],[7]]
    示例 2：

    输入：root = [1,2,4,null,3], to_delete = [3]
    输出：[[1,2,4]]


    提示：

    树中的节点数最大为 1000。
    每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
    to_delete.length <= 1000
    to_delete 包含一些从 1 到 1000、各不相同的值。
     */
    var result = ArrayList<TreeNode>()
    var first = true

    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        //dfs查找节点 如果有孩子节点 把自己移除掉 放入孩子节点 以此类推
        if (root == null) {
            return result
        }
        if (first){
            if (root.`val` !in to_delete){
                result.add(root)
            }
            first = false
        }
        if (root.`val` in to_delete) {
            if (root.left != null && root.left!!.`val` !in to_delete){
                result.add(root.left)
            }

            if (root.right != null && root.right!!.`val`  !in to_delete){
                result.add(root.right)
            }

        } else {
            //kotlin +号这个坑真的很坑
//            result + root
//            result.add(root)
        }

        delNodes(root.left, to_delete)

        delNodes(root.right, to_delete)

        if ((root.left?.`val` ?: -1) in to_delete) {
            root.left = null

        } else {

        }

        if ((root.right?.`val` ?: -1) in to_delete) {
            root.right = null


        } else {

        }
        return result
    }
    //不能过的太舒服 否则生于忧患

}

fun main() {
    println(
        TestArray162().delNodes(
            TreeNode(
                1, TreeNode(2, TreeNode(4), TreeNode(5)),
                TreeNode(3, TreeNode(6), TreeNode(7))
            ), intArrayOf(3, 5)
        )
    )
}