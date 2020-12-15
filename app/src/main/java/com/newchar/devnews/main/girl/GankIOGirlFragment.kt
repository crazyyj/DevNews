package com.newchar.devnews.main.girl

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.newchar.devnews.R
import com.newchar.devnews.base.BaseFragment
import com.newchar.devnews.http.HttpRequest
import com.newchar.devnews.http.JsonCompat
import com.newchar.devnews.http.entry.gankio.Girl
import com.newchar.devnews.http.params.GankIOParamsBuilder
import kotlinx.android.synthetic.main.fragment_gankio_girl_list.*
import okhttp3.Call
import okhttp3.Response
import java.io.IOException

/**
 *  @author wenliqiang
 *  date 2020/7/30
 *  @since GankIO 美图列表
 *  @since 迭代版本，（以及描述）
 */
class GankIOGirlFragment : BaseFragment(), Contract.IView {

    private lateinit var girlAdapter: GirlListAdapter


    override fun getContentViewId(): Int {
        return R.layout.fragment_gankio_girl_list
    }

    override fun initListener() {

    }

    override fun initData(savedInstanceState: Bundle?) {

        val girlImageUrl: String = GankIOParamsBuilder.buildGirlImageList(1, 20)
        HttpRequest.requestGirlList(girlImageUrl, object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val string = response.body()!!.string()
                    string?.let {
                        val parse = JsonCompat.parse(Girl::class.java, it)
                        onGirlListResponse(parse)
                    }
                }
            }
        })
    }

    private fun onGirlListResponse(parse: Girl?) {
        parse?.let {
            activity?.runOnUiThread {
                girlAdapter.notifyDataSetChanged(it.data)
            }
        }

    }

    override fun getInstance(bundle: Bundle?): BaseFragment {
        val fragment = GankIOGirlFragment()
        bundle?.let {
            fragment.arguments = it
        }
        return fragment
    }

    override fun initWidgets(frgView: View?) {
        girlAdapter = GirlListAdapter(obtainContext())
        rvGankIOGirlList.adapter = girlAdapter
        rvGankIOGirlList.itemAnimator = null
        rvGankIOGirlList.setHasFixedSize(true)

    }

    override fun obtainContext(): Context {
        return mContext
    }

}