package cn.sjoner.khttp

import cn.sjoner.khttp.*
import cn.sjoner.khttp.bean.KuaiDiQueryReq
import cn.sjoner.khttp.bean.QueryResp
import cn.sjoner.khttp.converter.GsonResponseConverter
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response

/**
 * Created by linmq on 17-11-22.
 */

class Main{
    @Test fun main() {

        initRetrofit {
            baseUrl("http://www.kuaidi100.com")
            responseConverter = GsonResponseConverter()
            debug = true
        }
        var response = testHttp<KuaiDiQueryReq, QueryResp> {
            url = "/query"
            method = HttpMethod.GET
            body = body {
                type = "yuantong"
                postid = "11111111111"
            }
            headers {
                put("key", "value")
            }
        }
        val queryresp = response?.body()
        println("queryresp = ${queryresp?.message}")
        val result = "ok" == queryresp?.message
        assertTrue(result)
    }

}


inline fun <F:Any,reified T:Any> testHttp(init: Request<F, T>.() -> Unit):Response<T>{

    val request = Request<F,T>()

    request.init()

    val client = HttpClient.instance()
    val call = client.createCall(request)
    val simpleCall = SimpleCall<T>(T::class.java,call)
    return simpleCall.execute()
}