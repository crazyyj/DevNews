package com.newchar.oscrepository.entry;

import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class OSCBlogList {


    private OSCNoticeNumber notice;
    private List<Item> bloglist;

    public OSCNoticeNumber getNotice() {
        return notice;
    }

    public void setNotice(OSCNoticeNumber notice) {
        this.notice = notice;
    }

    public List<Item> getBlogList() {
        return bloglist;
    }

    public void setBlogList(List<Item> blogList) {
        this.bloglist = blogList;
    }

    public class Item {

        private String commentCount;
        private String pubDate;
        private String author;
        private String title;
        private int authorid;
        private int type;
        private int id;

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getAuthorid() {
            return authorid;
        }

        public void setAuthorid(int authorid) {
            this.authorid = authorid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
