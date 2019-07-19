package com.newchar.devnews.http.entry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author wenliqiang
 * date 2019-07-03
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCLoginCodeToken implements Parcelable {

    private int uid;

    private int expires_in;

    private String token_type;

    private String access_token;

    private String refresh_token;

    public OSCLoginCodeToken() {
    }

    protected OSCLoginCodeToken(Parcel in) {
        uid = in.readInt();
        expires_in = in.readInt();
        token_type = in.readString();
        access_token = in.readString();
        refresh_token = in.readString();
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    @Override
    public String toString() {
        return "OSCLoginCodeToken{" +
                "uid=" + uid +
                ", expires_in=" + expires_in +
                ", token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeInt(expires_in);
        dest.writeString(token_type);
        dest.writeString(access_token);
        dest.writeString(refresh_token);
    }

    public static final Creator<OSCLoginCodeToken> CREATOR = new Creator<OSCLoginCodeToken>() {
        @Override
        public OSCLoginCodeToken createFromParcel(Parcel in) {
            return new OSCLoginCodeToken(in);
        }

        @Override
        public OSCLoginCodeToken[] newArray(int size) {
            return new OSCLoginCodeToken[size];
        }
    };

}
