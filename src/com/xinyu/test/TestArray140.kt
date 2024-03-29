package com.xinyu.test

class TestArray140 {
    /**
     * 39. 组合总和
    给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

    candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。

    对于给定的输入，保证和为 target 的不同组合数少于 150 个。



    示例 1：

    输入：candidates = [2,3,6,7], target = 7
    输出：[[2,2,3],[7]]
    解释：
    2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    7 也是一个候选， 7 = 7 。
    仅有这两种组合。
    示例 2：

    输入: candidates = [2,3,5], target = 8
    输出: [[2,2,2,2],[2,3,3],[3,5]]
    示例 3：

    输入: candidates = [2], target = 1
    输出: []


    提示：

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    candidate 中的每个元素都 互不相同
    1 <= target <= 500


    路径不需要new 那么多
    最后保存一下可行的路径即可


    这种题 还是要画树图才好解决

    面试失败  准备的还是不够

    https://leetcode.cn/problems/combination-sum/

     */

//    var results = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        dfs(candidates, target, mutableListOf(), 0, results)
        return results
    }

    private fun dfs(
        candidates: IntArray,
        target: Int,
        path: MutableList<Int>,
        startIndex: Int,
        result: MutableList<List<Int>>
    ) {
        if (target == 0) {
            val element = mutableListOf<Int>()
            element.addAll(path)
            result.add(element)
        } else if (target < 0) {
            return
        }
        for (i in startIndex until candidates.size) {
            path.add(candidates[i])
            dfs(candidates, target - candidates[i], path, i, result)
            path.removeAt(path.size - 1)
        }
    }


}

fun main() {
    println(TestArray140().combinationSum(intArrayOf(2, 3, 6, 7), 7))
}