package com.newchar.devnews.main.girl

import android.content.Context
import android.os.Bundle
import android.view.View
import com.newchar.devnews.R
import com.newchar.devnews.base.BaseFragment
import com.newchar.devnews.base.IBaseContract
import com.newchar.devnews.http.HttpRequest
import com.newchar.devnews.http.JsonCompat
import com.newchar.devnews.http.entry.gankio.Girl
import com.newchar.devnews.http.params.GankIOParamsBuilder
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
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
class GankIOGirlFragment : BaseFragment(), IBaseContract.IBaseView {

    private lateinit var girlAdapter: GirlListAdapter
    private var currGirlPage = 0
    private lateinit var mPresenter: GirlListPresenter


    override fun getContentViewId(): Int {
        return R.layout.fragment_gankio_girl_list
    }

    override fun initListener() {

    }

    override fun initData(savedInstanceState: Bundle?) {
        mPresenter = GirlListPresenter(this)
        mPresenter.requestGankIOGirlList()
        currGirlPage = 1
        val girlImageUrl: String = GankIOParamsBuilder.buildGirlImageList(currGirlPage, 20)
        HttpRequest.requestGirlList(girlImageUrl, object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val string = response.body()!!.string()
                    string?.let {
                        val parse = JsonCompat.parse(Girl::class.java, it)
                        onGirlListResponse(parse)
                        currGirlPage++
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
        smart_refresh_layout?.finishRefresh()
    }

    private fun onGirlListMoreResponse(parse: Girl?) {
        parse?.let {
            activity?.runOnUiThread {
                girlAdapter.notifyMoreDataSetChanged(it.data)
            }
        }
        smart_refresh_layout?.finishLoadMore()
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

        smart_refresh_layout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                currGirlPage = 1
                val girlImageUrl: String = GankIOParamsBuilder.buildGirlImageList(currGirlPage, 20)
                HttpRequest.requestGirlList(girlImageUrl, object : okhttp3.Callback {
                    override fun onFailure(call: Call, e: IOException) {

                    }

                    override fun onResponse(call: Call, response: Response) {
                        if (response.isSuccessful) {
                            val string = response.body()!!.string()
                            string?.let {
                                val parse = JsonCompat.parse(Girl::class.java, it)
                                onGirlListResponse(parse)
                                currGirlPage++
                            }
                        }
                    }
                })
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                val girlImageUrl: String = GankIOParamsBuilder.buildGirlImageList(++currGirlPage, 20)
                HttpRequest.requestGirlList(girlImageUrl, object : okhttp3.Callback {
                    override fun onFailure(call: Call, e: IOException) {

                    }

                    override fun onResponse(call: Call, response: Response) {
                        if (response.isSuccessful) {
                            val string = response.body()!!.string()
                            string?.let {
                                val parse = JsonCompat.parse(Girl::class.java, it)
                                onGirlListMoreResponse(parse)
                                currGirlPage++
                            }
                        }
                    }
                })
            }
        })
    }

    override fun obtainContext(): Context {
        return mContext
    }

}