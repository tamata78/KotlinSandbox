package com.example.kotlinsand.scope_func

class ConstantsSand {
	// クラスに紐づくstaticフィールドやメソッドを定義する
    companion object { // objectキーワードでSingletonを生成。companionキーワードでクラスに紐付け
        private val objectMapper = ObjectMapperBuilder.SENSITIVE
        private val Headers = listOf("Authorization")
    }

	private prMethod(): String = "aaa"

    fun main() {
    }
}

// objectキーワードならトップレベルに宣言可能で、パッケージレベルからアクセス可能
object aaa {
    private val objectMapper = ObjectMapperBuilder.SENSITIVE
    private val Headers = listOf("Authorization")

    // トップレベル関数からはクラス内のprivateメソッドにはアクセス不可
    fun topLevelFun() {
    	// prMethod()
    }
}

// 定数を定義可能
private const val HUGA = "Huga"