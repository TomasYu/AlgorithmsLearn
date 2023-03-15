package com.xinyu.test

class TestArray157 {
    //     https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
    /**
     *
     * https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
     * 1986. 完成任务的最少工作时间段
    你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。

    你需要按照如下条件完成给定任务：

    如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
    完成一个任务后，你可以 立马 开始一个新的任务。
    你可以按 任意顺序 完成任务。
    给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。

    测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。



    示例 1：

    输入：tasks = [1,2,3], sessionTime = 3
    输出：2
    解释：你可以在两个工作时间段内完成所有任务。
    - 第一个工作时间段：完成第一和第二个任务，花费 1 + 2 = 3 小时。
    - 第二个工作时间段：完成第三个任务，花费 3 小时。
    示例 2：

    输入：tasks = [3,1,3,1,1], sessionTime = 8
    输出：2
    解释：你可以在两个工作时间段内完成所有任务。
    - 第一个工作时间段：完成除了最后一个任务以外的所有任务，花费 3 + 1 + 3 + 1 = 8 小时。
    - 第二个工作时间段，完成最后一个任务，花费 1 小时。
    示例 3：

    输入：tasks = [1,2,3,4,5], sessionTime = 15
    输出：1
    解释：你可以在一个工作时间段以内完成所有任务。


    提示：

    n == tasks.length
    1 <= n <= 14
    1 <= tasks[i] <= 10
    max(tasks[i]) <= sessionTime <= 15
     */
    fun minSessions(tasks: IntArray, sessionTime: Int): Int {
        //猛一看挺简单的
        //关键是尽量让每一段都是最大的sessionTime
        //排序  最大的开始 不能放下了 从最小的开始
        //这个思路不对 随便举一个特殊的case就可以否决 2 2 3  7  8   每一段最大是11  这样正常可以两次  你按照这个思路就是3次


        //https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/solution/zhuang-tai-ya-suo-by-linbuxiao-2y8h/
        //https://leetcode.cn/problems/minimum-number-of-work-sessions-to-finish-the-tasks/solution/zhuang-tai-ya-suo-dong-tai-gui-hua-by-zh-txne/
        //当数据量小的时候 可以人工计算 太大了 需要算法解决  需要计算机解决
        val size = tasks.size
        val dpSize = 1 shl size
        var mask = Array(dpSize) { IntArray(2) { Int.MAX_VALUE } }
        mask[0] = intArrayOf(1, 0)

        for (i in 1 until dpSize) {
            var j = 0
            while ((1 shl j) <= i) {
                if (i and (1 shl j) == 0){
                    j++
                    continue
                }
                if (mask[i xor (1 shl j)][1] + tasks[j] > sessionTime) {
                    if (mask[i xor (1 shl j)][0] + 1 <= mask[i][0]) {
                        mask[i][0] = mask[i xor (1 shl j)][0] + 1
                        mask[i][1] = mask[i][1].coerceAtMost(tasks[j])
                    }
                } else {

                    if (mask[i xor (1 shl j)][0]  <= mask[i][0]) {
                        mask[i][0] = mask[i xor (1 shl j)][0]
                        mask[i][1] = mask[i][1].coerceAtMost(mask[i xor (1 shl j)][1] + tasks[j])
                    }
                }
                j++
            }
        }
        return mask[mask.size - 1][0]
    }


}

fun main() {
//    println(TestArray157().minSessions(intArrayOf(1, 2, 3), 3))
//    println(TestArray157().minSessions(intArrayOf(9, 6, 9), 14))
//    println(TestArray157().minSessions(intArrayOf(3,2,3,7,5,2,2,10,9,1,10), 11))
//    println(TestArray157().minSessions(intArrayOf(2,2,2,3,3,4,5,5,7,8,8,10,10), 14))
    println(TestArray157().minSessions(intArrayOf(1,5,7,10,3,8,4,2,6,2), 10))
}