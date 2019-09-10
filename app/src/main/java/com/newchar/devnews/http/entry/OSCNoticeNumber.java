package com.newchar.devnews.http.entry;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCNoticeNumber {

    int msgCount;

    int fansCount;

    int replyCount;

    int referCount;

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getReferCount() {
        return referCount;
    }

    public void setReferCount(int referCount) {
        this.referCount = referCount;
    }
}
