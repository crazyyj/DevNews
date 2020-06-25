package com.newchar.devnews.http.entry.osc;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 * {
 *     "id": 49262,
 *     "body": "博客内容Demo",
 *     "pubDate": "2013-10-08 16:19:38.0",
 *     "author": "张艺辰",
 *     "title": "博客标题Demo",
 *     "authorid": 253479,
 *     "notice": {
 *         "replyCount": 0,
 *         "msgCount": 0,
 *         "fansCount": 0,
 *         "referCount": 0
 *     },
 *     "favorite": 0,
 *     "commentCount": 0,
 *     "url": "http://home.oschina.org/yidongnan/blog/49262"
 * }
 */
public class OSCBlogDetail {

    private int id;
    private int favorite;
    private int commentCount;

    private String url;
    private String body;
    private String title;
    private String author;
    private String pubDate;
    private String authorid;

    private OSCNoticeNumber notice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public OSCNoticeNumber getNotice() {
        return notice;
    }

    public void setNotice(OSCNoticeNumber notice) {
        this.notice = notice;
    }
}
