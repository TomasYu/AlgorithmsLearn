package com.xinyu.test.kotlin

class KotlinTest {

}

fun main(args: Array<String>) {
    KotlinTest()

    //sampleStart
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"

    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
//sampleEnd
    println(s2)

    test()



}

/**
 * 交换两个变量
 */
fun test(){
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a=$a b=$b")

}