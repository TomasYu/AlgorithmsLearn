package com.xinyu.test

class TestNode38 {
    /**
     * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。

    实现 AllOne 类：

    AllOne() 初始化数据结构的对象。
    inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
    dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
    getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
    getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
     

    示例：

    输入
    ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
    [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
    输出
    [null, null, null, "hello", "hello", null, "hello", "leet"]

    解释
    AllOne allOne = new AllOne();
    allOne.inc("hello");
    allOne.inc("hello");
    allOne.getMaxKey(); // 返回 "hello"
    allOne.getMinKey(); // 返回 "hello"
    allOne.inc("leet");
    allOne.getMaxKey(); // 返回 "hello"
    allOne.getMinKey(); // 返回 "leet"
     

    提示：

    1 <= key.length <= 10
    key 由小写英文字母组成
    测试用例保证：在每次调用 dec 时，数据结构中总存在 key
    最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 104 次

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/all-oone-data-structure
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

class AllOne() {
    var map = HashMap<String, Node>()
    var head = Node()
    var tail = Node()
    init {
        head.next = tail
        tail.pre = head
    }
    class Node() {

        var set = HashSet<String>()
        var count = 0
        var next: Node? = null
        var pre: Node? = null

        constructor(key: String,count:Int) : this() {
            set.add(key)
            this.count = count
        }

        fun insertPre(pre: Node) {
            this.pre?.next = pre
            pre.pre = this.pre
            pre.next = this
            this.pre = pre
        }

        fun insertNext(next: Node) {
            this.next?.pre = next
            next.next = this.next
            this.next = next
            next.pre = this
        }

        fun removeKey(key: String) {
            set.remove(key)
            if (set.isEmpty()){
                remove()
            }
        }

        fun addKey(key: String) {
            set.add(key)
        }

        fun remove() {
            this.next?.pre = this.pre
            this.pre?.next = this.next
        }
    }

    fun inc(key: String) {
        // 存在
        if (map.containsKey(key)) {
            val node = map[key]
            val newCount = node!!.count + 1
            if (node.next?.count != newCount) {
                //new node
                val nextNode = Node(key,newCount)
                node.insertNext(nextNode)
                map[key] = nextNode
            } else {
                //user old
                node.next!!.addKey(key)
                map[key] = node.next!!
            }
            node.removeKey(key)
        } else {
            //不存在  寻找相同数量的node
            val cur = head.next
            if (cur?.count != 1) {
                val node = Node(key,1)
                head.insertNext(node)
                map[key] = node
            } else {
                //存在1个元素
                cur.addKey(key)
                map[key] = cur
            }
        }

    }

    fun dec(key: String) {
        val node = map[key] ?: return
        val newCount = node.count - 1
        if (newCount == 0){
            map.remove(key)
        }else if (node.pre!!.count != newCount) {
            val preNode = Node(key,newCount)
            node.insertPre(preNode)
            map[key] = preNode
        } else {
            node.pre!!.addKey(key)
            map[key] = node.pre!!
        }
        node.removeKey(key)
    }

    fun getMaxKey(): String {
        return if (tail.pre == head){
            ""
        }else{
            tail.pre!!.set.iterator().next()
        }
    }

    fun getMinKey(): String {
        return if (head.next == tail){
            ""
        }else {
            head.next!!.set.iterator().next()
        }
    }

    // for test
    fun print(){
        var cur = head.next
        println("start")
        while (cur != tail){
            println("count : ${cur!!.count} ${cur.set})")
            cur = cur.next
        }
        println("end")
    }
}
}


/**
["AllOne"
"inc"
"inc"
"inc"
"inc"
"inc"
"inc"
"dec"
"dec"
"getMinKey"
"dec"
"getMaxKey"
"getMinKey"]
[[]
["a"]
["b"]
["b"]
["c"]
["c"]
["c"]
["b"]
["b"]
[]
["a"]
[]
[]]
 */
fun main() {
    val allOne = TestNode38.AllOne()
    allOne.inc("a")
    allOne.print()
    allOne.inc("b")
    allOne.print()

    allOne.inc("b")
    allOne.print()

    allOne.inc("c")
    allOne.print()

    allOne.inc("c")
    allOne.print()

    allOne.inc("c")
    allOne.print()

    allOne.dec("b")
    allOne.print()

    allOne.dec("b")
    allOne.print()
    println(allOne.getMinKey())

    allOne.dec("a")
    allOne.print()

    println(allOne.getMaxKey())
    println(allOne.getMinKey())
//    ["AllOne","inc","inc","inc","dec","inc","inc",      "getMaxKey","dec","dec","dec","getMaxKey"]
//    [[],["hello"],["world"],["hello"],["world"],["hello"],["leet"]     ,[],["hello"],["hello"],["hello"],[]]

//    allOne.inc("hello")
//    allOne.inc("world")
//    allOne.inc("hello")
//    allOne.dec("world")
//    allOne.inc("hello")
//    allOne.inc("leet")
//    allOne.dec("hello")
//    allOne.dec("hello")
//    allOne.dec("hello")
////    allOne.dec("a")
//    println(allOne.getMaxKey())
//    println(allOne.getMinKey())
}