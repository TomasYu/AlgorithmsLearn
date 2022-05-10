package com.xinyu.test

class TestNode37 {
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

//第一个版本  很烂  但是通过了
class AllOne() {
    var map = HashMap<String, Node>()
    var head = Node()
    var tail = Node()

    init {
        head.next = tail
        tail.pre = head
    }

    class Node {
        var set = HashSet<String>()
        var count = 0
        var next: Node? = null
        var pre: Node? = null
    }

    fun inc(key: String) {
        // 存在
        if (map.containsKey(key)) {
            val node = map[key]
            if (node!!.next?.count != node.count + 1) {
                if (node.set.size == 1) {
                    node.count ++
                } else { //new node
                    val node1 = Node()
                    node1.count = node.count + 1
                    node1.set.add(key)
                    map[key] = node1
                    node.set.remove(key)

                    node1.next = node.next
                    node1.pre = node
                    node1.pre!!.next = node1
                    node1.next!!.pre = node1
                }

            } else {
                //user old
                node.next!!.set.add(key)
                map[key] = node.next!!
                if (node.set.size == 1) {
                    node.pre!!.next = node.next
                    node.next!!.pre = node.pre
                } else {
                    node.set.remove(key)
                }
            }


        } else {
            //不存在  寻找相同数量的node
            var cur = head.next
            if (cur?.count != 1) {
                var node = Node()
                node.set.add(key)
                node.count = 1
                node.next = head.next
                node.pre = head
                node.pre!!.next = node
                node.next!!.pre = node
                map[key] = node
            } else {
                //存在1个元素
                cur.set.add(key)
                map[key] = cur
            }
        }

    }

    fun dec(key: String) {
        //
        val node = map[key]
        //只有这个自己  移除
        if (node!!.count == 1 && node.set.count() == 1) {
            node.pre?.next = node.next
            node.next?.pre = node.pre
            map.remove(key)
        } else {
            if (node.pre!!.count != node.count - 1) {
                val node1 = Node()
                node1.next = node
                node1.pre = node.pre
                node1.pre!!.next = node1
                node1.next!!.pre = node1
                node1.count = node.count - 1
                node1.set.add(key)
                map[key] = node1
                if (node.set.size == 1){
                    //remove
                    node.pre!!.next = node.next
                    node.next!!.pre = node.pre
                }else{
                    node.set.remove(key)
                }
            } else {
                if (node.pre != head){
                    node.pre!!.set.add(key)
                    map[key] = node.pre!!
                    if (node.set.count() == 1){
                        node.pre!!.next = node.next
                        node.next!!.pre = node.pre
                    }else{
                        node.set.remove(key)
                    }
                }else{
                    node.set.remove(key)
                    if (node.set.size == 0){
                        map.remove(key)
                        node.next!!.pre = node.pre
                        node.pre!!.next = node.next
                    }
                }
            }
        }
    }

    fun getMaxKey(): String {
        val pre = tail.pre
        if (pre != head) {
            return pre!!.set.iterator().next()
        }
        return ""
    }

    fun getMinKey(): String {
        val next = head.next
        if (next != tail) {
            val iterator = next!!.set.iterator()
            var result = ""
            while (iterator.hasNext()){
                result = iterator.next()
            }
            return result
        }
        return ""
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
    val allOne = TestNode37.AllOne()
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