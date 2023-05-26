package com.xinyu.test

import java.util.stream.Collector
import kotlin.math.max

class TestArray167 {
    //https://leetcode.cn/problems/adding-two-negabinary-numbers/
    /**
     * 负二进制数相加
     *
     * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。

    数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。

    返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。

     

    示例 1：

    输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
    输出：[1,0,0,0,0]
    解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
    示例 2：

    输入：arr1 = [0], arr2 = [0]
    输出：[0]
    示例 3：

    输入：arr1 = [0], arr2 = [1]
    输出：[1]
     

    提示：

    1 <= arr1.length, arr2.length <= 1000
    arr1[i] 和 arr2[i] 都是 0 或 1
    arr1 和 arr2 都没有前导0


    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/adding-two-negabinary-numbers
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    https://leetcode.cn/problems/adding-two-negabinary-numbers/solution/python3javacgotypescript-yi-ti-yi-jie-mo-mg0a/
     */

    fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
        //想法是？？？？
        //题目思路很清晰  但是问题是-2的多少次方？

        //搞成-2进制  不过跟dfs有什么关系呢？？？？
        //不停的处以-2
        //不停的得到的余数
        //直接dfs计算
        //但是我怎么知道他的长度呢？？？？
        var size1 = arr1.size
        var size2 = arr2.size
        var bit = 0
        var i: Int
        var j: Int
        var temp: Int
        val resultList = ArrayList<Int>()
        while (size1 > 0 || size2 > 0 || bit != 0){
            i = if (size1 > 0){
                arr1[--size1]
            }else{
                0
            }
            j = if (size2 > 0){
                arr2[--size2]
            }else{
                0
            }
            temp = i + j + bit
            if (temp >= 2){
                temp -= 2
                bit = -1
            }else if (temp == -1){
                temp = 1
                bit = 1
            }else{
                bit = 0
            }
            resultList.add(temp)
        }
        while (resultList.size > 1 &&  resultList[resultList.lastIndex] == 0){
            resultList.removeAt(resultList.lastIndex)
        }
        resultList.reverse()
        return resultList.toIntArray()
    }


    //原来不是很复杂的数学公式 是简单的公式



}

fun main() {
//    println(TestArray167().addNegabinary(intArrayOf(1, 1, 1, 1, 1), intArrayOf(1, 0, 1)).contentToString())
//    println(TestArray167().addNegabinary(intArrayOf(0), intArrayOf(0)).contentToString())
    println(TestArray167().addNegabinary(intArrayOf(1), intArrayOf(1)).contentToString())
}