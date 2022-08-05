package com.xinyu.test

import java.lang.Thread
import java.lang.InterruptedException
import kotlin.jvm.JvmStatic

class TestInterrupt2 {
    class TestThread : Thread() {
        override fun run() {
            super.run()
            while (!isInterrupted) {
                println("testThread")
                try {
                    sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                    interrupt()
                }
            }
        }
    }

    fun countArrangement(n: Int): Int {
        return dfs(n, 1, 0)
    }

    private fun dfs(n: Int, i: Int, visited: Int): Int {
        if (i > n) {
            return 1
        }
        var ans = 0
        for (num in 1..n) {
            if (1 shl num and visited == 0 && (num % i == 0 || i % num == 0)) {
                // 数值传递不用还原状态
                ans += dfs(n, i + 1, 1 shl num or visited)
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val testThread = TestThread()
            testThread.start()
            try {
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            testThread.interrupt()
        }
    }
}

fun main() {
    println(TestInterrupt2().countArrangement(2))
}