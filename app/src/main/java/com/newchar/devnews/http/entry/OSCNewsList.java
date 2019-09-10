package com.newchar.devnews.http.entry;

import java.util.List;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since 开源中国新闻列表实体类
 * @since 迭代版本，（以及描述）
 */
public class OSCNewsList {

    public List<NewsItem> newslist;

    public OSCNoticeNumber notice;

    public static class NewsItem {

        public int id;

        public String type;

        public String author;

        public String title;

        public String pubDate;

        public String commentCount;

    }


}
