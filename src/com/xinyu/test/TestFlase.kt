package com.xinyu.test

class TestFlase {
    var a = false
}

fun main() {
    val testFlase = TestFlase()
    val message = !testFlase.a
    println(message)
    println(testFlase.a)
}