package com.xinyu.test

import java.util.*
import kotlin.collections.ArrayList

class TestNode45 {

    /**
     * 面试题 03.03. 堆盘子
    堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。

    当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.

    示例1:

    输入：
    ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
    [[1], [1], [2], [1], [], []]
    输出：
    [null, null, null, 2, 1, -1]
    示例2:

    输入：
    ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
    [[2], [1], [2], [3], [0], [0], [0]]
    输出：
    [null, null, null, null, 2, 1, 3]
     */

    class StackOfPlates(var cap: Int) {
        private var plateList = ArrayList<LinkedList<Int>>()

        fun push(`val`: Int) {
            if (cap == 0) {
                return
            }
            //找到最后一个  如果满了  新建一个盘子栈   如果没有满 直接放到最后一个
            if (plateList.isEmpty()) {
                addInNewPlateStack(`val`)
            } else {
                val stack = plateList[plateList.lastIndex]
                if (stack.size == cap) {
                    addInNewPlateStack(`val`)
                } else {
                    stack.push(`val`)
                }
            }
        }


        fun pop(): Int {
            //找到最后一个盘子栈  移除（如果已经为空那么移除这个栈）  返回该值
            return pop(plateList.lastIndex)
        }

        fun popAt(index: Int): Int {
            //定位到盘子栈   移除（如果已经为空那么移除这个栈）  返回该值
            return pop(index)
        }

        private fun pop(index: Int): Int {
            //移除（如果已经为空那么移除这个栈）  返回该值
            if (plateList.isEmpty()) {
                return -1
            } else {
                if (index >= plateList.size) {
                    return -1
                }
                val linkedList = plateList[index]
                return if (!linkedList.isEmpty()) {
                    val pop = linkedList.pop()
                    if (linkedList.isEmpty()) {
                        plateList.remove(linkedList)
                    }
                    pop
                } else {
                    -1
                }
            }
        }


        private fun addInNewPlateStack(i: Int): LinkedList<Int> {
            val linkedList = LinkedList<Int>()
            linkedList.push(i)
            plateList.add(linkedList)
            return linkedList
        }

    }
}