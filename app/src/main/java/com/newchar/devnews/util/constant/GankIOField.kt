package com.newchar.devnews.util.constant

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since GankIO 接口字段
 *  @since 迭代版本，（以及描述）
 */
class GankIOField {


    companion object {

        /**
         * gankIO 接口地址
         */
        const val BASE_URL: String = "https://gank.io"

        /**
         * gankIO 接口版本
         */
        const val GANKIO_INTERFACE_VERSION: String = "/api/v2"

        /**
         * gankIO 获取美女图片列表
         * count: [10, 50]
         * page: >=1
         */
        var GANKIO_GIRL_LIST = "/data/category/%s/type/%s/page/%d/count/%d"

    }

    /**
     * 可接受参数 All(所有分类) | Article | GanHuo | Girl
     */
    object Category {
        /**
         * 所有分类
         */
        const val All = "All"

        /**
         *
         */
        const val ARTICLE = "Article"

        /**
         * 美女图片
         */
        const val GIRL = "Girl"

        /**
         * 干货
         */
        const val GANHUO = "GanHuo"
    }

    /**
     * 可接受参数 All(全部类型) | Android | iOS | Flutter | Girl
     */
    object Type {

        /**
         * 所有类型
         */
        const val All = "All"

        /**
         * 美女图片类型
         */
        const val GIRL = "Girl"


    }
}