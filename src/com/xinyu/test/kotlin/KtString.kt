package com.xinyu.test.kotlin

class KtString {

}

fun main() {
    var s = """"jf
        |jj
        |a"
        |fsd
        |a
        |f""".trimMargin("|")
    println(s)
}