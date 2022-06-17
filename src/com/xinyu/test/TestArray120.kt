package com.xinyu.test

import java.util.*

class TestArray120 {
    /**
     * 剑指 Offer II 059. 数据流的第 K 大数值
    设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

    请实现 KthLargest 类：

    KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
    int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。


    示例：

    输入：
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    输出：
    [null, 4, 5, 5, 8, 8]

    解释：
    KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    kthLargest.add(3);   // return 4
    kthLargest.add(5);   // return 5
    kthLargest.add(10);  // return 5
    kthLargest.add(9);   // return 8
    kthLargest.add(4);   // return 8


    提示：

    1 <= k <= 104
    0 <= nums.length <= 104
    -104 <= nums[i] <= 104
    -104 <= val <= 104
    最多调用 add 方法 104 次
    题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素

    https://leetcode.cn/problems/jBjn9C/
     */

    class KthLargest(k: Int, nums: IntArray) {
        var q = PriorityQueue(Collections.reverseOrder<Int?>().reversed())
        var max = k
        init {
            nums.forEach {
                q.offer(it)
                if (q.size > k){
                    q.poll()
                }
            }
        }

        fun add(`val`: Int): Int {
            q.offer(`val`)
            if (q.size > max){
                q.poll()
            }
            return q.peek()
        }

    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * var obj = KthLargest(k, nums)
     * var param_1 = obj.add(`val`)
     */
}