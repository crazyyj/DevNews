package com.newchar.oscrepository.entry;

import com.newchar.oscrepository.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang
 * date 2020/6/14
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 * {
 * "post_list": [
 * {
 * "id": 82977,
 * "author": "彭博",
 * "pubDate": "2012-12-18 16:20:08.0",
 * "title": "测试youku视频地址",
 * "answerCount": 0,
 * "authorid": 89964,
 * "answer": "",
 * "portrait": "http://static.oschina.net/uploads/user/44/89964_50.jpg?t=1376365607000",
 * "viewCount": 12
 * },
 * {
 * "id": 83123,
 * "author": "彭博",
 * "pubDate": "2013-05-24 10:34:40.0",
 * "title": "测试站外活动",
 * "answerCount": 0,
 * "authorid": 89964,
 * "answer": "",
 * "portrait": "http://static.oschina.net/uploads/user/44/89964_50.jpg?t=1376365607000",
 * "viewCount": 0
 * }
 * ],
 * "notice": {
 * "replyCount": 0,
 * "msgCount": 0,
 * "fansCount": 0,
 * "referCount": 0
 * }
 * }
 */
public class OSCPostList {


    private List<Item> post_list;
    private OSCNoticeNumber notice;

    public static class Item {
        private int id;
        private String author;
        private String pubDate;
        private String title;
        private int authorid;
        private Answer answer;
        private int answerCount;
        private String portrait;
        private int viewCount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getAuthorid() {
            return authorid;
        }

        public void setAuthorid(int authorid) {
            this.authorid = authorid;
        }

        public Answer getAnswer() {
            return answer;
        }

        public void setAnswer(Answer answer) {
            this.answer = answer;
        }

        public int getAnswerCount() {
            return answerCount;
        }

        public void setAnswerCount(int answerCount) {
            this.answerCount = answerCount;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }
    }

    public List<Item> getPostList() {
        return post_list;
    }

    public void setPostList(List<Item> post_list) {
        this.post_list = post_list;
    }

    public OSCNoticeNumber getNotice() {
        return notice;
    }

    public void setNotice(OSCNoticeNumber notice) {
        this.notice = notice;
    }


    public static class Answer {

        public Answer() {
        }

        public Answer(String name, String time) {
            this.name = name;
            this.time = time;
        }

        public String name;
        public String time;
    }

    public static OSCPostList valueOf(String JSONString) throws JSONException {
        OSCPostList postList = new OSCPostList();
        JSONObject jsonString = new JSONObject(JSONString);
        final JSONArray post_list = jsonString.getJSONArray("post_list");
        if (!Utils.isEmpty(post_list)) {
            int length = post_list.length();
            postList.post_list = new ArrayList<>(length);
            Item item;
            for (int i = 0; i < length; i++) {
                try {
                    final JSONObject postJsonObject = post_list.getJSONObject(i);
                    item = new Item();
                    item.setPortrait(postJsonObject.getString("portrait"));
                    item.setViewCount(postJsonObject.getInt("viewCount"));
                    item.setPubDate(postJsonObject.getString("pubDate"));
                    item.setAuthorid(postJsonObject.getInt("authorid"));
                    item.setAuthor(postJsonObject.getString("author"));
                    item.setTitle(postJsonObject.getString("title"));
                    item.setId(postJsonObject.getInt("id"));

                    final JSONObject answerJson = postJsonObject.optJSONObject("answer");
                    if (answerJson != null && answerJson.has("name") && answerJson.has("time")) {
                        final Answer answer = new Answer(answerJson.getString("name"), answerJson.getString("time"));
                        item.setAnswer(answer);
                        item.setAnswerCount(postJsonObject.getInt("answerCount"));
                    }
                    postList.post_list.add(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        postList.setNotice(OSCNoticeNumber.valueOf(jsonString));
        return postList;
    }

}
