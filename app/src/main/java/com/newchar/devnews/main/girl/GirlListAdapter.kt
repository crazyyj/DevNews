package com.newchar.devnews.main.girl

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.newchar.devnews.R
import com.newchar.devnews.base.view.BaseRecyclerAdapter
import com.newchar.devnews.http.OKHttpClient
import com.newchar.devnews.http.entry.gankio.Girl
import okhttp3.Call
import okhttp3.Response
import java.io.IOException
import java.lang.Exception

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since 当前版本，（以及描述）
 *  @since 迭代版本，（以及描述）
 */
class GirlListAdapter(ctx: Context) : BaseRecyclerAdapter<Girl.DataItem, GirlListAdapter.VH>(ctx) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        super.onCreateViewHolder(parent, viewType)
        return VH(layoutInflater.inflate(R.layout.item_gankio_girl_list, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        super.onBindViewHolder(holder, position)
        val s = adapterData[position].images[0]
        Glide.with(mContext).load(s).dontAnimate()/*.placeholder(R.drawable.ic_splash_logo)*/.into(holder.ifvGirlItemImg)

    }



    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ifvGirlItemImg: AppCompatImageView = itemView.findViewById(R.id.ifvGirlItemImg)

    }

}