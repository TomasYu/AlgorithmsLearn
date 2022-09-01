package com.xinyu.test

import java.util.*
import kotlin.concurrent.fixedRateTimer

class TestNode49 {

    /**
     * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。

    注意，根节点 root 位于深度 1 。

    加法规则如下:

    给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
    cur 原来的左子树应该是新的左子树根的左子树。
    cur 原来的右子树应该是新的右子树根的右子树。
    如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
     

    示例 1:



    输入: root = [4,2,6,3,1,5], val = 1, depth = 2
    输出: [4,1,1,2,null,null,6,3,1,5]
    示例 2:



    输入: root = [4,2,null,3,1], val = 1, depth = 3
    输出:  [4,2,null,1,1,3,null,null,1]
     

    提示:

    节点数在 [1, 104] 范围内
    树的深度在 [1, 104]范围内
    -100 <= Node.val <= 100
    -105 <= val <= 105
    1 <= depth <= the depth of tree + 1


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/add-one-row-to-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
//广度
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 1) {
            return TreeNode(`val`, root, null)
        }
        var queue = LinkedList<TreeNode>()
        queue.offer(root)
        var curDepth = 1
        while (!queue.isEmpty()) {
            if (curDepth == depth - 1) {
                while (queue.peek() != null) {
                    val pop = queue.pop()
                    pop.left = TreeNode(`val`, pop.left, null)
                    pop.right = TreeNode(`val`, null, pop.right)
                }
                break
            } else {
                for (i in 0 until queue.size) {
                    val pop = queue.pop()
                    pop.left?.let { queue.offer(pop.left) }
                    pop.right?.let { queue.offer(pop.right) }
                }
                curDepth++
            }
        }
        return root
    }

    fun addOneRow2(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 1){
            return TreeNode(`val`,root,null)
        }else if (depth == 2){
            root?.left = TreeNode(`val`,root?.left,null)
            root?.right = TreeNode(`val`,null,root?.right)
        }else{
            root?.left = addOneRow2(root?.left,`val`,depth -1)
            root?.right = addOneRow2(root?.right,`val`,depth -1)
        }
        return root
    }

}

fun main() {
    TestNode49().addOneRow(TreeNode(4, TreeNode(2, TreeNode(3), TreeNode(1)), TreeNode(6, TreeNode(5), null)), 1, 2)
}