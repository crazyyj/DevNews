package com.newchar.devnews.blog.contract;

import com.newchar.devnews.base.IBasePresenter;
import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.entry.osc.OSCBlogList;

import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public interface IOSCBlogListContract {

    interface Presenter extends IBasePresenter<View> {

        /**
         * 请求 开源中国博客列表
         */
        void requestOSCBlogList();

    }

    interface View extends IBaseView {

        void onBlogListResponse(List<OSCBlogList.Item> blogList);

    }

}
