package com.xinyu.test

import java.util.*

class TestInt28 {
    /**
     *
     *有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。

    如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。

    你可以：

    装满任意一个水壶
    清空任意一个水壶
    从一个水壶向另外一个水壶倒水，直到装满或者倒空
     

    示例 1: 

    输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
    输出: true
    解释：来自著名的 "Die Hard"
    示例 2:

    输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
    输出: false
    示例 3:

    输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
    输出: true
     

    提示:

    1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/water-and-jug-problem
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
        val curState = IntArray(2) { 0 }
        val set = mutableSetOf<String>()

        val queue = LinkedList<IntArray>()
        queue.offer(curState)
        while (!queue.isEmpty()) {
            val pop = queue.pop()
            if (set.contains(hash(pop))) {
                continue
            }
            set.add(hash(pop))
            if (pop[0] == targetCapacity || pop[1] == targetCapacity || pop[0] + pop[1] == targetCapacity) {
                return true
            }
            //倒空
            queue.offer(intArrayOf(0, pop[1]))
            queue.offer(intArrayOf(pop[0], 0))
            //装满
            queue.offer(intArrayOf(jug1Capacity, pop[1]))
            queue.offer(intArrayOf(pop[0], jug2Capacity))

            //互相倒
            //1 倒入2
            queue.offer(
                intArrayOf(
                    (pop[0] - (jug2Capacity - pop[1])).coerceAtLeast(0),
                    (pop[1] + pop[0]).coerceAtMost(jug2Capacity)
                )
            )
            //2倒入1
            queue.offer(
                intArrayOf(
                    (pop[0] + pop[1]).coerceAtMost(jug1Capacity),
                    (pop[1] - (jug1Capacity - pop[0])).coerceAtLeast(0)
                )
            )
        }
        return false
    }

    private fun hash(state: IntArray): String {
        return "${state[0]}-${state[1]}"
    }
}

fun main() {
//    println(TestInt28().canMeasureWater(2, 6, 5))
    //104579
    //104593
    //12444
    //重要的是 每一步要分解成原子操作   不然没有办法思考 ；
    println(TestInt28().canMeasureWater(104579, 104593, 12444))
}