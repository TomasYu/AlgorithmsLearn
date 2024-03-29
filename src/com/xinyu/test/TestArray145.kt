package com.xinyu.test

class TestArray145 {
    /**
     *
     *
     * https://leetcode.cn/problems/course-schedule/
     * 207. 课程表
    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。



    示例 1：

    输入：numCourses = 2, prerequisites = [[1,0]]
    输出：true
    解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    示例 2：

    输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    输出：false
    解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。


    提示：

    1 <= numCourses <= 105
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    prerequisites[i] 中的所有课程对 互不相同


    思路想不出来啊  实际问题 如果转变成
     */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val status = IntArray(numCourses) { 0 }
        var end = 0
        for (prerequisite in prerequisites) {
            map.getOrDefault(prerequisite[1], mutableListOf()).also {
                it.add(prerequisite[0])
                map[prerequisite[1]] = it
            }
            status[prerequisite[0]]++
        }
        val ended = mutableListOf<Int>()
        status.forEachIndexed { index, i ->
            if (i == 0) {
                end++
                ended.add(index)
//                ended + index
            }
        }
        val iterator = ended.iterator()
        while (iterator.hasNext()) {
            val course = iterator.next()
            iterator.remove()
            map[course]?.forEach {
                status[it]--
                if (status[it] == 0) {
                    ended.add(it)
                    end++
                }
            }
        }
        println(end)
        println(ended.joinToString { "," })
        return end == numCourses
    }
}

fun main() {
    TestArray145().canFinish(5, arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2, 4),
        intArrayOf(3, 1),
        intArrayOf(3, 2)


    )).also { println(it) }
}