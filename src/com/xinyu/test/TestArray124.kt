package com.xinyu.test

class TestArray124 {
    /**
     * https://leetcode.cn/problems/shift-2d-grid/
     * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

    每次「迁移」操作将会引发下述活动：

    位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
    位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    请你返回 k 次迁移操作后最终得到的 二维网格。

     

    示例 1：



    输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
    输出：[[9,1,2],[3,4,5],[6,7,8]]
    示例 2：



    输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
    输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
    示例 3：

    输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
    输出：[[1,2,3],[4,5,6],[7,8,9]]

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/shift-2d-grid
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val height = grid.size
        var width = if (grid.isNotEmpty()) grid[0].size else 0
        var next = 0
        for (i in 1..k) {
            grid.forEachIndexed { index, ints ->
                ints.forEachIndexed { index2, i ->
                    //
                    if (index == 0 && index2 == 0) {
                        next = i
                    } else {
                        var temp = i
                        grid[index][index2] = next
                        next = temp
                        if (index == height - 1 && index2 == width - 1) {
                            grid[0][0] = next
                        }
                    }
                }
            }
        }

        var result = ArrayList<List<Int>>()

        grid.forEach {
            val element = ArrayList<Int>()
            result.add(element)
            it.forEach {
                element.add(it)
            }
        }
        return result
    }


    fun shiftGrid2(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val heightT = grid.size
        var widthT = if (grid.isNotEmpty()) grid[0].size else 0

        var result = ArrayList<ArrayList<Int>>()
        grid.forEach {
            val element = ArrayList<Int>()
            result.add(element)
            it.forEach { _ ->
                element.add(0)
            }
        }

        grid.forEachIndexed { height, ints ->
            ints.forEachIndexed { width, i ->
                var newIndex = (height * widthT + width + k) % (heightT * widthT)
                result[newIndex / widthT][newIndex % widthT] = i
            }
        }
        return result
    }

}

fun main() {
    val shiftGrid = TestArray124().shiftGrid(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)), 1)


    shiftGrid.forEach {
        it.forEach {
            print(it)
        }
        println()
    }
}