package com.newchar.oscrepository.entry;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-22
 * @since 当前版本描述，
 * @since 迭代版本描述
 * //    {
 * //        id: 899**,
 * //        email: "****@gmail.com",
 * //        name: "彭博",
 * //        gender: "male",
 * //        avatar: "http://www.oschina.net/uploads/user/****",
 * //        location: "广东 深圳",
 * //        url: "http://home.oschina.net/****"
 * //    }
 */
public class OSCUserInfoResult {

    /**
     * 用户id
     */
    public int id;

    /**
     * 个人主页
     */
    public String url;

    /**
     * 用户名
     */
    public String name;

    /**
     * 绑定的邮箱
     */
    public String email;

    /**
     * 性别
     */
    public String gender;

    /**
     * 头像
     */
    public String avatar;

    /**
     * 地址
     */
    public String location;

    private static OSCUserInfoResult mInstance;

    private OSCUserInfoResult() {
        if (mInstance != null) {
            throw new IllegalStateException("");
        }
    }

    public static OSCUserInfoResult getInstance() {
        if (mInstance == null) {
            synchronized (OSCUserInfoResult.class) {
                if (mInstance == null) {
                    mInstance = new OSCUserInfoResult();
                }
            }
        }
        return mInstance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
