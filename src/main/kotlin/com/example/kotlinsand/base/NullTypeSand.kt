package com.example.kotlinsand.base

class NullTypeSnad {
    fun main() {
        // ?.
        val str: String? = "test"
        val length: Int? = str?.length // lengthの型はInt?となるのがポイント
        // Nullableは早めにnullチェックしてNon-null化するのが良い

        // ?:s
        val valueOrNull: String? = null
        val displayName: String = valueOrNull ?: "No Name" // null時の値設定、Non-Null化になる

        fun foo(list: List<String>) {
            val str: String = list[1] ?: return // `list` が空なら早期脱出。returnも書けて便利
            // length を使う処理
        }

        // ?.let
        valueOrNull?.let { "$it san" } // Nullableな値をメソッドの引数として渡すのに使える

        // デフォルト値の設定後にチェインする場合
        val defaultValue = "default"
        valueOrNull.let { it ?: defaultValue }
                .let { it }

    }
}
