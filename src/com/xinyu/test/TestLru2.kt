package com.xinyu.test

class TestLru2 {
    //https://leetcode.cn/problems/lru-cache/
    /**
    146. LRU 缓存
    中等
    2.9K
    相关企业
    请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
    实现 LRUCache 类：
    LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
    函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。



    示例：

    输入
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    输出
    [null, null, null, 1, null, -1, null, -1, 3, 4]

    解释
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    lRUCache.get(1);    // 返回 1
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    lRUCache.get(2);    // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    lRUCache.get(1);    // 返回 -1 (未找到)
    lRUCache.get(3);    // 返回 3
    lRUCache.get(4);    // 返回 4


    提示：

    1 <= capacity <= 3000
    0 <= key <= 10000
    0 <= value <= 105
    最多调用 2 * 105 次 get 和 put


    这只能用HashMap实现了
    但是怎么移除呢？
    LRU的时候 我怎么知道该移除哪一个呢？？？
    再来个队列吧 里面放K

    那LinkedHashMap?
    书到用时方恨少，事因经过始知难
    本以为会很流畅的写出来
    结果呢？？？
    这个继承都继承不了？？

     */
    class Node(value: Int) {
        var pre: Node? = null
        var nex: Node? = null
        var value: Int

        init {
            this.value = value
        }
    }


    class LRUCache(capacity: Int) {
        var map = mutableMapOf<Int, Int>()
        var dumpHead: Node = Node(-1)
        private var dumpTail: Node = Node(-1)
        var mCapability = capacity

        init {
            dumpHead.nex = dumpTail
            dumpTail.pre = dumpHead
        }

        fun get(key: Int): Int {

            val orDefault = map.getOrDefault(key, -1)
            if (orDefault != -1) {
                val find = find(key)
                if (find != null) {
                    find.nex!!.pre = find.pre
                    find.pre!!.nex = find.nex

                    dumpHead.nex!!.pre = find
                    find.nex = dumpHead.nex

                    dumpHead.nex = find
                    find.pre = dumpHead
                }
            }
            return orDefault
        }

        fun put(key: Int, value: Int) {

            if (map.containsKey(key)) {
                val find = find(key)
                if (find != null) {
                    find.nex!!.pre = find.pre
                    find.pre!!.nex = find.nex

                    dumpHead.nex!!.pre = find
                    find.nex = dumpHead.nex

                    dumpHead.nex = find
                    find.pre = dumpHead
                }
            } else {
                val node = Node(key)
                dumpHead.nex!!.pre = node
                node.nex = dumpHead.nex
                dumpHead.nex = node
                node.pre = dumpHead
            }
            map[key] = value


            while (map.size > mCapability) {
                dumpTail.pre?.let {
                    it.pre!!.nex = dumpTail
                    dumpTail.pre = it.pre
                    map.remove(it.value)
                }
            }
        }

        fun find(key: Int): Node? {
            var cur = dumpHead.nex
            while (cur != null) {
                if (cur.value == key) {
                    return cur
                }
                cur = cur.nex
            }
            return null
        }

    }
}