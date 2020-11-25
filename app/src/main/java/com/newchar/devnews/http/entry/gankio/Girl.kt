package com.newchar.devnews.http.entry.gankio

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since gankIO 美女图片返回
 *  @since 迭代版本，（以及描述）
 */
class Girl {

    lateinit var data: MutableList<DataItem>

    var status: Int = 0

    var page: Int = 0

    var page_count: Int = 0

    var total_counts: Int = 0

    class DataItem {

        lateinit var images: MutableList<String>

        var _id: String? = null

        var author: String? = null

        var category: String? = null

        var createdAt: String? = null

        var desc: String? = null
        var publishedAt: String? = null
        var stars: String? = null
        var likeCounts: Int = 0
        var views: Int = 0
        var title: String? = null
        var type: String? = null
        var url: String? = null


    }
}