package com.example.kotlinsand.base

class BaseTypeSnad {
    fun main() {
        // IntをDoubleに入れる
        val x1: Int = 42
//        val y: Double = x // コンパイルエラー 暗黙型変換は不可。Int と Double には型の派生関係がないため
        val y1: Double = x1.toDouble() // OK

        // DoubleをIntに入れる
        val x2: Double = 42.0
//        val y: Int = x as Int // ClassCastException。 Int と Double には型の派生関係がないため
        val y2: Int = x2.toInt() // OK

    }
}
