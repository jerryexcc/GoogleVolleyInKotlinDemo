package idv.jerryexcc.googlevolleyinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/*
* Google親生兒子Volley(Kotlin ver)
* 簡化了Java又臭又長的HTTP請求
* 無需背景執行就可取得完整的網頁原始碼
*
* P.S 記得要在Manifest內加<uses-permission>
* */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化 Volley佇列
        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        //宣告請求 參數: 1.使用GET請求 2.網址(字串即可 無需轉成URL) 3.請求成功後做的事 4.請求失敗時候做的事
        val stringRequest = StringRequest(
            Request.Method.GET,
            "https://www.google.com.tw",
            Response.Listener {
                //Response Listener 反饋成功後會看到整個網頁的HTML原始碼
                    response ->
                //HTML原始碼可能因過長而在下方顯示不完,詳細可開瀏覽器去看該網頁的完整原始碼找你需要的資料
                Log.d("TAG", "Response success HTML: $response")
            },
            Response.ErrorListener { error ->
                //Error Listener 反饋回來有錯誤的時候執行這個區塊
                Log.d("TAG", "Response error HTML: $error")
            }
        )
        //加入到請求佇列
        requestQueue.add(stringRequest)
    }
}
