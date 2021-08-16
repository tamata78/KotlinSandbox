package com.example.kotlinsand

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.reflect.KFunction
import oracle.net.aso.b.i
import oracle.net.aso.b.i
import org.mockito.Mockito

@SpringBootTest // Configクラスの自動検出用アノテーション、ないとエラーになる
// @ExtendWith(MockitoExtension.class) // junit5でmokitoを使う場合に必要
class MokitoSand {
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean // Mockオプジェクトを設定。Spring Bootが提供するアノテーション。Spring Bootを利用したテストは非常に遅い。@MockBeanは多用しない
    // @Mock Mockitoの機能として同様の動作をするもの。初期化設定は必要になる
    private lateinit var cartRepo: CartRepository

    @MockBean
    private lateinit var messageService: MessageService

    // @SpyBean テストクラスの一部を書き換えるためのSpyオプジェクトを注入する

    // staticクラス、privateなクラスはMock化できない。Mock化したい場合はpower mockを利用

    val headers = HttpHeaders()

    private var item: ItemEntity? = null

    @BeforeEach
    fun setUp() {
        // テストクラス内の共通で使う値、OBJを宣言
        item = ItemEntity(
            value = "aaa"
        )

        // base header
        headers.set("carrierName", "smartphone")
        headers.set("uName", "iPhone XS")
        headers.set("osVersion", "demae")
        headers.set("User-Agent", "iPhone XS 14.0")
    }

    @Test
    fun testMethod() {
        /** Mock定義とテストメソッドの実行 **/
        // ServiceのgetMessageメソッドをモック化
        doReturn("モック化できたよ").`when`(messageService).getMessage(i)
        // 呼び出し回数確認
        verify(messageService, times(1)).getMessage(i)
        // 期待している返り値と実際の返り値を比較検証
        assertThat(sampleController.sample1(i), `is`("モック化できたよ")) // assertThat(テストメソッド実行結果, 期待値)

        /** Voidメソッド **/
        //Mockito.doNothing().`when`<Any>(モックインスタンス).メソッド(任意の引数)

        /** Privateメソッド **/
        // 実行許可設定
        val kFunction = makeExecutablePrivateMethod("getTotalPrice") // メソッド引数あれば第二引数以降に設定
        // privateメソッド呼び出し
        kFunction?.call(cartRepo, param1, param2) // cartRepo内のgetTotalPriceを引数にparam1とparam2を設定して呼び出す

        /** 型式指定検証 **/
        verify(repository, never()).setCart(anyLong(), isA<List<OrderEntity>>())
        // isA(T.class)は、引数_instanceof T_がnullでないことを確認
        // same(obj)は、引数がobjと同じインスタンスであること、つまり_arg == obj_がtrueであることを確認
        // eq(obj)は、objメソッドに従って、引数がequalsに等しいことを確認
    }

    @Test
    public void testRequest() {
        //initialize ObjectMapper mapper
        //initialize Request req and Response res

        when(someServiceMock.doSomething(any(Request.class))).thenReturn(res);

        // リクエストのテスト
        mockMvc.perform(post("/do/something")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(req))
        )
            // 結果確認
            .andExpect(status().isOk())
            .andExpect(jsonPath("$message", is("done")));
    }

    @Test
    @WithMockUser // security contextを生成。認証エラーを回避？
    fun deleteCartSuccess() {
        val res = CartResponse(
            data = CartResponseDto(
                orderId = 0L,
            )
        )
        whenever(cartDeleteUseCase.deleteCart(any())).thenReturn(res)

        val request = MockMvcRequestBuilders
            .delete("/v1.0/cart/0?&author=test&orderType=0")
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .headers(headers)

        with(mvc) {
            perform(request)
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data.orderId").value(0L))
        }
    }

    private fun makeExecutablePrivateMethod(privateMethod: String): KFunction<*>? {
        val testMethod = service::class.memberFunctions.find { it.name == privateMethod }
        testMethod?.let {
            it.isAccessible = true
            return it
        }
        return null
    }
}
