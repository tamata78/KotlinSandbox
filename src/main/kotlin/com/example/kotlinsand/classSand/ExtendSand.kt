package com.example.kotlinsand.scope_func

class ExtendSand { }

/*
 継承
 */
class Sample // 未指定時はAnyを暗黙継承、AnyはObjectとは異なる。ObjectはAnyのサブクラスにあたる

open class Base(p: Int) // openつけると継承可能クラスになる。デフォはJavaでのfinal class

// Baseを継承したクラス、プライマリコンストラクタは基底クラスを初期化
class Derived(p: Int) : Base(p)

// プライマリコンストラクタがない場合
class MyView : View {
    // 各セカンダリコンストラクタは親クラスのコンストラクタをsuperで呼び出す
    constructor(ctx: Context) : super(ctx) { // セカンダリコンストラクタが親のコンストラクタを継承の意味？かな
    }
}

/*
 メンバーのオーバーライド
 */
open class Base {
    // デフォルトでfinal。openなしはオーバーライド不可
    open fun v() {}
    fun nv() {}
}

class Derived() : Base() {
    // オーバーライドする側ではoverrideを付ける。付けないとコンパイラエラー
    override fun v() {}
}

open class AnotherDerived() : Base() {
    // オーバーライドするとデフォルトでopen扱い。
    // それ以上オーバーライドさせないならfinalを付ける。
    final override fun v() {}
}
