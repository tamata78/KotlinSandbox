package com.example.kotlinsand.scope_func

class UtilSand {

    fun main() {
        val time1 = measureTimeMillis {
            // 時間のかかる処理
            println("test")
        }
        println("計測：表示処理 in $time1 ms")
    }
}
