package com.example.kotlinsand.scope_func

class CalssSand { }

// 中身なしクラス、引数なしコンストラクタが定義される
class Empty

// コンストラクタ(プライマリを一つ、セカンダリを複数持てる)
class Customer(name: String) { // ()内がプライマリコンストラクタ
    init { // 初期化処理
        println("${name}") // プライマリコンストラクタの引数を使える
    }

    val name = name // プライマリコンストラクタの引数は初期化にも使える

    // セカンダリコンストラクタ
    constructor(firstName: String, lastName: String)
    // プライマリがある場合、セカンダリは必ずプライマリを呼び出す
        : this("$firstName $lastName") {
        logger.info("firstName = $firstName, lastName = $lastName")
    }
}

// プライマリコンストラクタの正規の書き方
class Person constructor(firstName: String) {
    // ...
}

// プライマリコンストラクタなしでセカンダリだけってのもあり。
class Person {
    constructor(parent: Person) {
        parent.children.add(this)
    }
}

// コンストラクタを公開したくないなら、こんな感じでアクセス指定する。
class DontCreateMe private constructor () {
}

/*
 シールドクラス
 */
// Exprはその内部クラスしか継承できない
sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}

// whenと一緒に使うと便利
fun eval(expr: Expr): Double = when(expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
    Expr.NotANumber -> Double.NaN
    // 全てのケースをカバーしてるのでelseはいらない
    // Expr継承できるのは内部クラスだけなので、上で定義されてる分だけしかないことを
    // コンパイラは知っている。
}
