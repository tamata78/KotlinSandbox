package com.example.kotlinsand

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.reflect.KFunction
import org.junit.jupiter.params.ParameterizedTest




@SpringBootTest
@Transactional
@Sql(
    statements = [
        """
        INSERT INTO item
        (item_id, regist_id, regist_tm, delete_flg)
        VALUES
        (1L, '4567', TIMESTAMP '2021-08-03 10:00:00.000000', '0');
        """
    ]
)
class JunitSand {

    @Autowired
    private lateinit var repo: ItemRepository

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "c"])
    fun string(value: String) {
        println("string: $value")
    }

    // パラメータ切り替えのテストの際に使う書き方。メソッドの引数で複数ケースを消化する場合。
    @ParameterizedTest
    @ArgumentsSource(FindByItemCode::class)
    fun findByItemCode(itemCode: String, orderType: OrderType, now: Timestamp, expected: String?) {
        val entity = repo.findByItem(itemCode, orderType, now)
        Assertions.assertEquals(expected, entity?.itemCode)
    }

    // findByItemCodeのテストデータ
    private class FindByItemCode : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.arguments("item1", OrderType.SAME_DAY, TimestampUtil.stringToTimestamp("20210801100000", "yyyyMMddHHmmss"), null),
            Arguments.arguments("item1", OrderType.SAME_DAY, TimestampUtil.stringToTimestamp("20210802000000", "yyyyMMddHHmmss"), "item1"),
            Arguments.arguments("item1", OrderType.SAME_DAY, TimestampUtil.stringToTimestamp("20210731235959", "yyyyMMddHHmmss"), null),
        )
    }
}
