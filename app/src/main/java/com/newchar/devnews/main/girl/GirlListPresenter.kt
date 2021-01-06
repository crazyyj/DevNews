package com.newchar.devnews.main.girl

import com.newchar.devnews.base.BasePresenter
import com.newchar.devnews.base.IBaseContract
import com.newchar.devnews.http.HttpRequest
import com.newchar.devnews.http.params.GankIOParamsBuilder
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since GankIO girl列表Presenter类
 *  @since 迭代版本，（以及描述）
 */
class GirlListPresenter(view: IBaseContract.IBaseView) : BasePresenter(view) {

    private var currGirlPage = 1

    fun requestGankIOGirlList() {
        val girlImageUrl: String = GankIOParamsBuilder.buildGirlImageList(currGirlPage, 20)
        HttpRequest.requestGirlList(girlImageUrl, object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
//                    val body = response.body()
//                    val string = body?.string()
//                    string?.let {
//                        val parse = JsonCompat.parse(Girl::class.java, it)
//                        view.onGirlListResponse(parse)
//                        currGirlPage++
//                    }
                }
            }
        })
    }

}