package com.example.kotlinsand.scope_func

class CollectionSand {

    fun main() {
        // 空の配列やリスト
        val x = listOf<Int>()                //=> List<Int>
        val x = mutableListOf<Int>()         //=> MutableList<Int>

        val x = setOf<Int>()                 //=> Set<Int>
        val x = mutableSetOf<Int>()          //=> MutableSet<Int>

        val x = mapOf<String, Int>()         //=> Map<String, Int>
        val x = mutableMapOf<String, Int>()  //=> MutableMap<String, Int>

        // Kotlin が定義しているシングルトンインスタンス（EmptyList など）を返すので、空のコレクションインスタンスをいくつも生成するのを避ける
        // この場合、編集不可(要素追加不可)になる
        val x = emptyList<Int>()         //=> List<Int>
        val x = emptySet<Int>()          //=> Set<Int>
        val x = emptyMap<String, Int>()  //=> Map<String, Int>

        // 初期値を指定して List/Set/Map を生成
        val x: List<Int> = listOf(1, 2, 3)
        val x: MutableList<Int> = mutableListOf(1, 2, 3)

        val x: Set<Int> = setOf(1, 2, 3)
        val x: MutableSet<Int> = mutableSetOf(1, 2, 3)

        val x: Map<String, Int> = mapOf("one" to 1, "two" to 2)
        val x: MutableMap<String, Int> = mutableMapOf("one" to 1, "two" to 2)

    }
}
