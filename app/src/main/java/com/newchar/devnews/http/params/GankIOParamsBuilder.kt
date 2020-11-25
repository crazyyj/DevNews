package com.newchar.devnews.http.params

import com.newchar.devnews.util.constant.GankIOField

/**
 *  @author wenliqiang
 *  date 2020/8/1
 *  @since GankIO网络请求参数构建
 *  @since 迭代版本，（以及描述）
 */
class GankIOParamsBuilder {

    companion object {

        /**
         *  获取gankIO 美图接口地址
         */
        fun buildGirlImageList(page: Int, count: Int): String {
            val address = String.format(GankIOField.GANKIO_GIRL_LIST, GankIOField.Category.GIRL, GankIOField.Type.GIRL, page, count)
            return GankIOField.BASE_URL + GankIOField.GANKIO_INTERFACE_VERSION + address
        }

    }

}