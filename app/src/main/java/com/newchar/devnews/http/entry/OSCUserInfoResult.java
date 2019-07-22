package com.newchar.devnews.http.entry;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-22
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class OSCUserInfoResult {

//    {
//        id: 899**,
//        email: "****@gmail.com",
//        name: "彭博",
//        gender: "male",
//        avatar: "http://www.oschina.net/uploads/user/****",
//        location: "广东 深圳",
//        url: "http://home.oschina.net/****"
//    }

    public int id;
    public String name;
    public String email;
    public String gender;
    public String avatar;
    public String location;

    /**
     * 个人主页
     */
    public String url;

}
