package com.newchar.supportlibrary.db.entry;


import com.newchar.supportlibrary.constant.Login;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 数据库中，每次登录成功记录一次登录
 * @since 迭代版本描述
 */
public class LoginRecord {

    /**
     * 自增id，主键
     */
    private Long _id;

    /**
     * 登录时间
     */
    private long loginTime;

    /**
     * 登录渠道
     */
    private String loginChannel;

    /**
     * 刷新token，校验值
     */
    private String refresh_token;

    /**
     * token
     */
    private String access_token;

    /**
     * token 类型
     */
    private String token_type;

    /**
     * token有效期还有多久
     */
    private long expires_in;


    public LoginRecord() {
    }

    public long getId() {
        return this._id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginChannel() {
        return this.loginChannel;
    }

    public void setLoginChannel(@Login.LoginChannel String loginChannel) {
        this.loginChannel = loginChannel;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    /**
     * 是否过期
     */
    public boolean isExpire(){
        return System.currentTimeMillis() < (getExpires_in() * 1000) + getLoginTime();
    }

    @Override
    public String toString() {
        return "LoginRecord{" +
                "_id=" + _id +
                ", loginTime=" + loginTime +
                ", loginChannel='" + loginChannel + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
