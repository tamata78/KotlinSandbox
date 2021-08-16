package com.example.kotlinsand.base

class FuncSand {
    fun main() {
        // 無名関数
        val numbers = arrayListOf<Int>(1,2,3)
        numbers.forEach(fun(number: Int) {
            if (number % 2 == 1) {
                return // 早期脱出 ラムダだとreturnできないが無名関数ならreturnできる
            }
            // 任意の処理
        })

    }
}
