package com.xinyu.test

import java.util.*

class TestNode52 {
    /**
     * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/
     *
     * 653. 两数之和 IV - 输入二叉搜索树
    给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。



    示例 1：


    输入: root = [5,3,6,2,4,null,7], k = 9
    输出: true
    示例 2：


    输入: root = [5,3,6,2,4,null,7], k = 28
    输出: false
     */
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        var temp = root
        var stack = LinkedList<TreeNode>()
        var set = HashSet<Int>()
        stack.offer(root)
        while (!stack.isEmpty()) {
            temp = stack.pop()
            set.add(temp.`val`)
            temp?.let {
                temp.left?.let {
                    stack.offer(temp.left)
                }
                temp.right?.let {
                    stack.offer(temp.right)
                }
            }
        }

        set.forEach {
            if (k - it != it && set.contains(k - it)) {
                return true
            }
        }

        return false
    }

    fun findTarget2(root: TreeNode?, k: Int): Boolean {
        var temp: TreeNode
        var stack = LinkedList<TreeNode>()
        var set = HashSet<Int>()
        stack.offer(root)
        while (!stack.isEmpty()) {
            temp = stack.pop()
            if (set.contains(k - temp.`val`)) {
                return true
            }
            set.add(temp.`val`)
            temp?.let {
                temp.left?.let {
                    stack.offer(temp.left)
                }
                temp.right?.let {
                    stack.offer(temp.right)
                }
            }
        }
        return false
    }
}