package com.xinyu.test

import java.util.concurrent.Executors

class TestThreadPool {

}

fun main() {

    val newSingleThreadExecutor = Executors.newSingleThreadExecutor()
    var runnable = Runnable {
//        newSingleThreadExecutor.shutdown()
        newSingleThreadExecutor.shutdownNow()
        println("aaaaa")
        Thread.sleep(2000)
        println("bbbb")

    }

    newSingleThreadExecutor.execute(runnable)
}