package com.newchar.devnews.user;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author newChar
 * date 2020/12/6
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCUser implements Parcelable {


    public OSCUser() {
    }

    protected OSCUser(Parcel in) {
    }

    public static final Creator<OSCUser> CREATOR = new Creator<OSCUser>() {
        @Override
        public OSCUser createFromParcel(Parcel in) {
            return new OSCUser(in);
        }

        @Override
        public OSCUser[] newArray(int size) {
            return new OSCUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

}
