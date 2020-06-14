package com.newchar.devnews.http.entry.osc;

import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2019-10-17
 * @since OSC 动弹 列表数据，
 * @since 迭代版本描述
 */
public class OSCTweet {

    /**
     * 动弹列表
     */
    public List<OSCTweetItem> tweetlist;

    /**
     * 通知更新
     */
    public OSCNoticeNumber notice;

    public static class OSCTweetItem {
        /**
         * 名字
         */
        public String author;
        /**
         * 头像
         */
        public String portrait;
        /**
         * 动弹id
         */
        public int id;
        /**
         * 评论个数（包括自己）
         */
        public int commentCount;
        /**
         * 作者id
         */
        public int authorid;
        /**
         * 描述
         */
        public String body;
        /**
         * 发布时间
         */
        public String pubDate;
        /**
         * 配图（大。多图，分割
         */
        public String imgBig;

        /**
         * 配图（小 多图，分割
         */
        public String imgSmall;

    }
}
