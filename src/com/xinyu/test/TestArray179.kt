package com.xinyu.test

class TestArray179 {
    //https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75
    /**
    https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=leetcode-75
    给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。



    示例 1:

    输入: temperatures = [73,74,75,71,69,72,76,73]
    输出: [1,1,4,2,1,1,0,0]
    示例 2:

    输入: temperatures = [30,40,50,60]
    输出: [1,1,1,0]
    示例 3:

    输入: temperatures = [30,60,90]
    输出: [1,1,0]


    提示：

    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100


    最笨的方法 肯定能做出来
    只不过是需要多遍历

    创建同样的长度的数据
    遍历一遍的时候
    从后往前遍历
    不断更新当前位置的最大值
    这样就可以输出对应的结果了


    我擦 想简单了
    还是输出第几天。。。。

    这跟栈有啥关系？？？？

    栈怎么可能有index？？？？（直接入栈的是索引）
    两个栈？？？？
    一块pop push
    我擦
    逻辑？？？
    乱想？？？？

    这题有意思
    如何保证的第一个大的index？ 因为本来就是顺序遍历


    map的能力

     */

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val size = temperatures.size
        val stack = ArrayDeque<Int>()
        var result = IntArray(size) { 0 }
        temperatures.forEachIndexed { index, i ->
            while (!stack.isEmpty()) {
                val lastIndex = stack.last()
                if (i > temperatures[lastIndex]) {
                    result[lastIndex] = index - lastIndex
                    stack.removeLastOrNull()
                } else {
                    break
                }
            }
            stack.addLast(index)

        }
        return result
    }
}