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
    val aa = func(1)
    aa(9)
    println(aa(9))
    println(aa(9))




}

/**
 * https://geek-docs.com/kotlin/kotlin-tutorial/kotlin-higher-order-function.html
 */
//https://geek-docs.com/kotlin/kotlin-tutorial/kotlin-higher-order-function.html
fun func(num: Int): (Int) -> Int = {num2 -> num2 + num}
/**
 * 交换两个变量
 */
fun test(){
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a=$a b=$b")

}


class Classa{
    var a = 10

    inner class Classb{
        var b = a + 10
    }
}