package com.xinyu.test

import java.util.*

class TestArray180 {
    //https://leetcode.cn/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
    /**
    901. 股票价格跨度
    中等
    428
    相关企业
    设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。

    当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

    例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。

    实现 StockSpanner 类：

    StockSpanner() 初始化类对象。
    int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。


    示例：

    输入：
    ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
    [[], [100], [80], [60], [70], [60], [75], [85]]
    输出：
    [null, 1, 1, 1, 2, 1, 4, 6]

    解释：
    StockSpanner stockSpanner = new StockSpanner();
    stockSpanner.next(100); // 返回 1
    stockSpanner.next(80);  // 返回 1
    stockSpanner.next(60);  // 返回 1
    stockSpanner.next(70);  // 返回 2
    stockSpanner.next(60);  // 返回 1
    stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
    stockSpanner.next(85);  // 返回 6

    提示：

    1 <= price <= 105
    最多调用 next 方法 104 次

     ??? 数组参数怎么没有传递

     奥 是单个数一个个穿的
     用单调递增栈就解决解决
     初始化栈
    遍历数组
     如果为空就放入元素 返回栈的长度
     否则判断当前的股价是否大于栈顶
     是的话 放入栈 返回栈的长度
     否则 清空栈 并放入当前元素

     逻辑有点漏洞

又是审题不严密

     是不是从后往前比较好做啊？？
     比我小的如栈
     大了清空栈
     但是可能得费空间了
     而且需要从后往前


     需要计算索引的话
     栈里面只有元素确实不太行、
     思路要打开
     */
    class StockSpanner() {
        var stack = LinkedList<Int>()
        fun next(price: Int): Int {
            if (!stack.isEmpty() && price < stack.peek()){
                //不能直接清空 最后一个数超级大 怎么处理？？？“”
                //难道只能往前对比？但是pop了不好办了
                stack.clear()
            }
            stack.push(price)
            return stack.size
        }
    }
}