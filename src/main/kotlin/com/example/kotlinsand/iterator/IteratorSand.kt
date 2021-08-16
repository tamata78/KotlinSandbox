package com.example.kotlinsand.scope_func

class IteratorSand {

    data class Item(val name: String, val value: Int)

    fun main() {
        // イテレーターでループ
        val itemList = listof(Item("a", 1), Item("b", 2))
        val itr = itemList.iterator()
        while (itr.hasNext()) {
            val item = itr.next()
            if (item.name == "a") itr.remove() // 該当OBJを削除
        }
    }
}
