package com.xinyu.test

import java.util.LinkedList
import kotlin.math.absoluteValue

class TestArray183 {
    //https://leetcode.cn/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
    /**
    https://leetcode.cn/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
    735. 小行星碰撞
    提示
    中等
    456
    相关企业
    给定一个整数数组 asteroids，表示在同一行的小行星。

    对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。

    找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。



    示例 1：

    输入：asteroids = [5,10,-5]
    输出：[5,10]
    解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
    示例 2：

    输入：asteroids = [8,-8]
    输出：[]
    解释：8 和 -8 碰撞后，两者都发生爆炸。
    示例 3：

    输入：asteroids = [10,2,-5]
    输出：[10]
    解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。


    提示：

    2 <= asteroids.length <= 104
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0



    输入
    asteroids =
    [-2,-1,1,2]

    添加到测试用例
    输出
    []
    预期结果
    [-2,-1,1,2]

    我又理解错了？？？
    卧槽 还有方向的问题！！！
    左右方向的问题
     */
    fun asteroidCollision(asteroids: IntArray): IntArray {
        //遍历顺序的问题 并不是傻了吧唧的从头开始遍历
        //也是从头开始遍历
        //用栈实现就可以了
        // 遇到碰撞的话就 出栈
        val linkedList = LinkedList<Int>()
        asteroids.forEach {
            var needPush = true
            while (!linkedList.isEmpty() && it < 0 && linkedList.peek() > 0) {
                if (it.absoluteValue <= linkedList.peek().absoluteValue) {
                    needPush = false
                    break
                }
                if (it.absoluteValue >= linkedList.peek().absoluteValue) {
                    linkedList.pop()
                }
            }
            if (needPush) {
                linkedList.push(it)
            }
        }
        linkedList.reverse()
        return linkedList.toIntArray()
    }
}