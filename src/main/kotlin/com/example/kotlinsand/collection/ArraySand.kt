package com.example.kotlinsand.scope_func

class ArraySand {

    fun main() {
        // ジェネリック型配列
        val x = arrayOf<Int>()     //=> Array<Int>
        val x = arrayOf<Double>()  //=> Array<Double>

        // プリミティブ型配列
        val x = intArrayOf()       //=> IntArray
        val x = doubleArrayOf()    //=> DoubleArray

        // Kotlin が定義しているシングルトンインスタンス（EmptyList など）を返すので、空のコレクションインスタンスをいくつも生成するのを避ける
        val x = emptyArray<Int>()        //=> Array<Int>

        // 初期値を指定して配列を生成
        val x: Array<Int> = arrayOf(1, 2, 3)
        val x: IntArray = intArrayOf(1, 2, 3)

    }
}
