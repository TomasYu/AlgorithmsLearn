package com.xinyu.test

import java.util.*

class TestNode54 {
    //https://leetcode.cn/problems/min-stack/
    /**
     *155. 最小栈
    难度
    中等

    1619





    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    实现 MinStack 类:

    MinStack() 初始化堆栈对象。
    void push(int val) 将元素val推入堆栈。
    void pop() 删除堆栈顶部的元素。
    int top() 获取堆栈顶部的元素。
    int getMin() 获取堆栈中的最小元素。


    示例 1:

    输入：
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    输出：
    [null,null,null,null,-3,null,0,-2]

    解释：
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.getMin();   --> 返回 -2.


    提示：

    -231 <= val <= 231 - 1
    pop、top 和 getMin 操作总是在 非空栈 上调用
    push, pop, top, and getMin最多被调用 3 * 104 次

     */

    /**
     * 1.常数范围内获取最小？？ 每次push pop 更新一遍？
     *
     * 除非联表加数组  数组维护栈的顺序 连标维护大小关系
     *
     *
     *
     */

    //一定要知道 栈是单向进出的 所以才可以保证每一步操作都是最小的
    //
    class MinStack() {
        val stack = LinkedList<Int>()
        val miniStack = LinkedList<Int>()

        fun push(`val`: Int) {
            stack.push(`val`)
            if (!miniStack.isEmpty()) {
                miniStack.push(miniStack.peek().coerceAtMost(`val`))
            }else{
                miniStack.push(`val`)
            }
        }

        fun pop() {
            stack.pop()
            miniStack.pop()
        }

        fun top(): Int {
           return stack.peek()
        }

        fun getMin(): Int {
            return miniStack.peek()
        }

    }
}