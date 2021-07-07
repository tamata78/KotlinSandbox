package com.example.kotlinsand.scope_func

class ScopeFuncSand {

    fun main() {
        var a: String? = "a"
        var b: String = ""

        a?.let {
            // ok
            b = it
        } ?: b // 式のみ記載可能

        // else側が複数行にしたい場合、runを使うと良い
        a?.let {
            // a が null でないときの処理
            b = it
        } ?: run {
            // a が null のときの処理
            // 複数行処理を書ける
            b = "b"
        }

    }
}