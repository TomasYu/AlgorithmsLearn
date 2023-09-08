package com.xinyu.test.kotlin

import kotlin.coroutines.*

class K1 {

}

fun main() {
    val coroutine = suspend {
        println("suspend")
        "aaa"
    }.createCoroutine(object : Continuation<String> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<String>) {
            println(result.getOrNull())
        }

    })

    coroutine.resume(Unit)


    suspend {
        println("suspend2")
        "bbbb"
    }.startCoroutine(object : Continuation<String> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<String>) {
            println(result.getOrNull())
        }

    })


    suspend {
        println("suspend2")
        "bbbb"
    }.startCoroutine(object : Continuation<String> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<String>) {
            println(result.getOrNull())
        }

    })

}