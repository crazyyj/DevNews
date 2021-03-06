package com.newchar.devnews.post;

import com.newchar.devnews.base.IBaseView;
import com.newchar.devnews.http.entry.osc.OSCNewsList;
import com.newchar.devnews.http.entry.osc.OSCNoticeNumber;
import com.newchar.devnews.http.entry.osc.OSCPostList;
import com.newchar.devnews.http.entry.osc.OSCTweet;

import java.util.List;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public interface IView extends IBaseView {


    void onUpdateNoticeNumber(OSCNoticeNumber news);

    /**
     * 帖子列表
     *
     * @param postList 帖子列表
     */
    void onCreateOSCPost(List<OSCPostList.Item> postList);
}
