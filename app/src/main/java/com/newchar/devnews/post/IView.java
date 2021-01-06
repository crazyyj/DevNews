package com.newchar.devnews.post;

import com.newchar.devnews.base.IBaseContract;
import com.newchar.oscrepository.entry.OSCNoticeNumber;
import com.newchar.oscrepository.entry.OSCPostList;

import java.util.List;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public interface IView extends IBaseContract.IBaseView {


    void onUpdateNoticeNumber(OSCNoticeNumber news);

    /**
     * 帖子列表
     *
     * @param postList 帖子列表
     */
    void onCreateOSCPost(List<OSCPostList.Item> postList);

    /**
     * 加载更多帖子数据
     *
     * @param postList 帖子列表
     */
    void onLoadMoreOSCPost(List<OSCPostList.Item> postList);
}
