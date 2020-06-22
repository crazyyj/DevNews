package com.newchar.devnews.post.detail;

import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.entry.osc.OSCPostDetail;

/**
 * @author wenliqiang
 * date 2020/6/22
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
interface View extends IBaseView {

    void onPostDetailResponse(OSCPostDetail postDetail);

}
