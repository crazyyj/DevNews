package com.newchar.devnews.http.entry.osc;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author wenliqiang
 * date 2019-09-10
 * @since
 * @since 迭代版本，（以及描述）
 */
public class OSCNoticeNumber implements Parcelable {

    public OSCNoticeNumber() {
    }

    public int msgCount;

    public int fansCount;

    public int replyCount;

    public int referCount;

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

    protected OSCNoticeNumber(Parcel in) {
        msgCount = in.readInt();
        fansCount = in.readInt();
        replyCount = in.readInt();
        referCount = in.readInt();
    }

    public static final Creator<OSCNoticeNumber> CREATOR = new Creator<OSCNoticeNumber>() {
        @Override
        public OSCNoticeNumber createFromParcel(Parcel in) {
            return new OSCNoticeNumber(in);
        }

        @Override
        public OSCNoticeNumber[] newArray(int size) {
            return new OSCNoticeNumber[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(msgCount);
        dest.writeInt(fansCount);
        dest.writeInt(replyCount);
        dest.writeInt(referCount);
    }

    public static OSCNoticeNumber valueOf(JSONObject jsonObject) {
        OSCNoticeNumber notice = new OSCNoticeNumber();
        try {
            final JSONObject noticeJson;
            if (jsonObject.has("notice") && (noticeJson = jsonObject.getJSONObject("notice")).length() > 0) {
                notice = new OSCNoticeNumber();
                notice.setReferCount(noticeJson.getInt("referCount"));
                notice.setFansCount(noticeJson.getInt("fansCount"));
                notice.setMsgCount(noticeJson.getInt("msgCount"));
                notice.setReplyCount(noticeJson.getInt("replyCount"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return notice;
    }



}
