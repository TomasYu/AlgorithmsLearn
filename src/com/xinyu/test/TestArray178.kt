package com.xinyu.test

class TestArray178 {
    /**
    605. 种花问题
    简单
    684
    相关企业
    假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

    给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。



    示例 1：

    输入：flowerbed = [1,0,0,0,1], n = 1
    输出：true
    示例 2：

    输入：flowerbed = [1,0,0,0,1], n = 2
    输出：false


    提示：

    1 <= flowerbed.length <= 2 * 104
    flowerbed[i] 为 0 或 1
    flowerbed 中不存在相邻的两朵花
    0 <= n <= flowerbed.length


    贪心？？？
    其实就是两个1之间的0的个数？？
    万一全都没有1呢？？
    那就是连续0的个数
    连续3个0  有可能是2个啊
    因为在边上


    只能判断左右两边是否是0 是有有1
    然后放入之后 就改变数组状态

    顺序遍历吧
    如果能放就放
    不能放就往后
    从前往后和从后往前一样的
    只要0的个数一样
    10000 001

    个人感觉是可能有是数学方法的


    每一三省吾身

    遇到0  +1的位置是不是1 并且看+2的位置是不是0 +3的位置不是1 才行

    遇到1 直接看 +2的位置是不是0 +3是不是1 都OK那就可以

    感觉思路还是有些许的凌乱


    遇到0 直接看+2的位置是不是0 并且c+3的位置是0 才行

    遇到1 直接看 +2的位置是不是0 +3是0 都OK那就可以


    遇到0
    +2 ==0  +3 ==0 OK  直接+2
    +2 ==0   +3!=0 直接到+3的位置
    +2 !=0 直接变更index

    遇到1
    +2 ==0  +3 ==0 OK  直接+2
    +2 ==0   +3!=0 直接到+3的位置
    +2 !=0 直接变更index

    这不是O和1都一样吗
    不对0还要看+1



     只考虑当前位置能不能放
     不能考虑太多


    【1】当遍历到index遇到1时，说明这个位置有花，那必然从index+2的位置才有可能种花，因此当碰到1时直接跳过下一格。 【2】当遍历到index遇到0时，由于每次碰到1都是跳两格，因此前一格必定是0，此时只需要判断下一格是不是1即可得出index这一格能不能种花，如果能种则令n减一，然后这个位置就按照遇到1时处理，即跳两格；如果index的后一格是1，说明这个位置不能种花且之后两格也不可能种花（参照【1】），直接跳过3格。

    作者：Eleanor
    链接：https://leetcode.cn/problems/can-place-flowers/solutions/542634/fei-chang-jian-dan-de-tiao-ge-zi-jie-fa-nhzwc/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var index = 0
        val size = flowerbed.size
        var result = 0
        while (index < size) {
            when (flowerbed[index]) {
                0 -> {
                    if (index + 1 == size || flowerbed[index + 1] == 0) {
                        result++
                        index += 2
                        if (result >= n){
                            return true
                        }
                    } else {
                        index += 3
                    }
                }
                else -> {
                    index += 2
                }
            }
        }
        return result >= n
    }
}

fun main() {
//    println(TestArray178().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    println(TestArray178().canPlaceFlowers(intArrayOf(1,0,0,0,1,0,0), 2))
}