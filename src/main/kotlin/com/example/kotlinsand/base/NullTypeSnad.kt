package com.example.kotlinsand.base

class Sand {
    fun main() {
        // ?.
        val str: String? = "test"
        val length: Int? = str?.length // lengthの型はInt?となるのがポイント
        // Nullableは早めにnullチェックしてNon-null化するのが良い

        // ?:s
        val name: String? = "test"
        val displayName: String = name ?: "No Name" // null時の値設定、Non-Null化になる

        fun foo(list: List<String>) {
            val str: String = list.get(1) ?: return // `list` が空なら早期脱出。returnも書けて便利
            // length を使う処理
        }

        // ?.let
        name?.let { "$it san" } // Nullableな値をメソッドの引数として渡すのに使える

    }
}
