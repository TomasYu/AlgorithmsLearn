package com.xinyu.test

import java.util.*

class TestArray136 {
    /**
     * 剑指 Offer II 037. 小行星碰撞
    给定一个整数数组 asteroids，表示在同一行的小行星。

    对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。

    找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。



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
    示例 4：

    输入：asteroids = [-2,-1,1,2]
    输出：[-2,-1,1,2]
    解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。


    提示：

    2 <= asteroids.length <= 104
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0
    https://leetcode.cn/problems/XagZNi/
     */
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val list = asteroids.asList().toMutableList()
        //find 表示是否有碰撞的
        var find = true
        while (find) {
            find = false
            for (i in list.indices) {
                if (list[i] > 0 && i + 1 < list.size && list[i + 1] < 0) {
                    val result = list[i] + list[i + 1]
                    if (result > 0) {
                        list.removeAt(i + 1)
                    } else if (result == 0) {
                        list.removeAt(i)
                        list.removeAt(i)
                    } else {
                        list.removeAt(i)
                    }
                    find = true
                    break
                }
            }
        }
        return list.toIntArray()
    }


    fun asteroidCollision2(asteroids: IntArray): IntArray {
        var stack = Stack<Int>()
        asteroids.forEach {
            var alive = true
            while (it < 0 && !stack.isEmpty() && stack.peek() >0) {
                alive = stack.peek() < -it
                if (stack.peek() == -it){
                    stack.pop()
                    break
                }else if (stack.peek() < -it){
                    stack.pop()
                }else{
                    break
                }
            }
            if (alive) {
                stack.push(it)
            }
        }
        var result = IntArray(stack.size) { 0 }
        stack.forEachIndexed { index, i ->
            result[index] = i
        }
        return result
    }


    fun asteroidCollision3(asteroids: IntArray): IntArray {
        var stack = Stack<Int>()
        asteroids.forEach {
            var alive = true
            while (alive && it < 0 && !stack.isEmpty() && stack.peek() >0) {
                alive = stack.peek() < -it
                if (stack.peek() <= -it){
                    stack.pop()
                }
            }
            if (alive) {
                stack.push(it)
            }
        }
        var result = IntArray(stack.size) { 0 }
        stack.forEachIndexed { index, i ->
            result[index] = i
        }
        return result
    }
}

fun main() {
    println(TestArray136().asteroidCollision2(intArrayOf(5, 10, -5)).contentToString())
}