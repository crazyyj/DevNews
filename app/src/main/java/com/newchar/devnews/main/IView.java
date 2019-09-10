package com.newchar.devnews.main;

import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.entry.OSCNewsList;
import com.newchar.devnews.http.entry.OSCNoticeNumber;

import java.util.List;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public interface IView extends IBaseView {


    void onCreateOSCNews(List<OSCNewsList.NewsItem> news);

    void onUpdateNoticeNumber(OSCNoticeNumber news);

}
